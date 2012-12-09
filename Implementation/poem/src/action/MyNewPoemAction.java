package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import dao.MyNewPoemDao;
import dao.UserCountDao;
import domain.Item;
import domain.MyNewPoem;
import domain.Poem;
import domain.UserCount;

public class MyNewPoemAction {

	private Double result;
	private MyNewPoemDao myNewPoemDao;
	private Poem poem;
	private MyNewPoem myNewPoem;
	private List<MyNewPoem> myNewPoems;

	// For go test page. Poem list with blanks.
	private List<Item> allItems = new ArrayList<Item>();

	// For forms in go test page. values are stored in this list.
	// Also used in the result page.
	private List<Item> testItems = new ArrayList<Item>();

	private List<Item> wrongItems = new ArrayList<Item>();

	public void setMyNewPoemDao(MyNewPoemDao myNewPoemDao) {
		this.myNewPoemDao = myNewPoemDao;
	}

	public void setUserCountDao(UserCountDao userCountDao) {
	}

	public Poem getPoem() {
		return poem;
	}

	public void setPoem(Poem poem) {
		this.poem = poem;
	}

	public MyNewPoem getMyNewPoem() {
		return myNewPoem;
	}

	public void setMyNewPoem(MyNewPoem myNewPoem) {
		this.myNewPoem = myNewPoem;
	}

	public List<MyNewPoem> getMyNewPoems() {
		return myNewPoems;
	}

	public void setMyNewPoems(List<MyNewPoem> myNewPoems) {
		this.myNewPoems = myNewPoems;
	}

	public List<Item> getAllItems() {
		return allItems;
	}

	public void setAllItems(List<Item> allItems) {
		this.allItems = allItems;
	}

	public List<Item> getTestItems() {
		return testItems;
	}

	public void setTestItems(List<Item> testItems) {
		this.testItems = testItems;
	}

	public Double getResult() {
		return result;
	}

	public void setResult(Double result) {
		this.result = result;
	}

	public List<Item> getWrongItems() {
		return wrongItems;
	}

	public void setWrongItems(List<Item> wrongItems) {
		this.wrongItems = wrongItems;
	}

	public List<Item> findByPoemid(Integer id) {
		List<Item> splitPoem = new ArrayList<Item>();
		for (Item item : allItems) {
			if (item.getPoemid() == id) {
				splitPoem.add(item);
			}
		}
		return splitPoem;
	}

	// Will not be used later. Moved to poem action.
	public String addMyNewPoem() {
		MyNewPoem newPoem = new MyNewPoem();
		UserCount user = (UserCount) ActionContext.getContext().getSession()
				.get("userInSession");
		newPoem.setUser(user);
		newPoem.setPoem(poem);
		myNewPoemDao.save(newPoem);
		return "index";
	}

	public String index() {
		UserCount user = (UserCount) ActionContext.getContext().getSession()
				.get("userInSession");
		myNewPoems = myNewPoemDao.queryAll(user);
		return "index";
	}

	public String removePoem() {
		myNewPoemDao.delete(myNewPoem);
		return index();
	}

	public String goTest() {
		setAllItems(TestItems());
		return "goTest";
	}

	public String goResult() {
		double correct = 0.0, total = 0.0;
		setAllItems(TestItems());
		for (Item item : testItems) {
			// Item not null is not enough.
			try {
				System.out.println("testItems poemid : " + item.getPoemid()
						+ " with sentenceid : " + item.getSentenceid());
				Item right = findByPidAndSid(item.getPoemid(),
						item.getSentenceid());
				if (right.getSentence().equalsIgnoreCase(
						item.getSentence().trim())) {
					correct++;
					total++;
				} else {
					total++;
					wrongItems.add(item);
					wrongItems.add(right);
				}
			} catch (Exception e) {
				System.out.println("Oops, another null pointer exception!");
			}
		}
		result = correct / total;
		return "goResult";
	}

	private List<MyNewPoem> TestPoems() {
		List<MyNewPoem> testPoems = new ArrayList<MyNewPoem>();
		UserCount user = (UserCount) ActionContext.getContext().getSession()
				.get("userInSession");
		List<MyNewPoem> allNewPoems = myNewPoemDao.queryAll(user);
		for (MyNewPoem myNewPoem : allNewPoems) {
			// Date createday = myNewPoem.getCreatedate();
			Date testday = myNewPoem.getTestdate();
			Date today = new Date(System.currentTimeMillis());

			// The following is simplified.
			// (today.getTime() - createday.getTime()) / (24 * 60 * 60 * 1000)
			// >= 1 &&
			if (testday == null) {
				testPoems.add(myNewPoem);
			} else {
				Long distance = ((today.getTime() - testday.getTime()) / (24 * 60 * 60 * 1000));
				if (distance != 0
						&& distance >= Math.pow(2, myNewPoem.getCount())) {
					testPoems.add(myNewPoem);
				}
			}
		}
		return testPoems;
	}

	private List<Item> TestItems() {
		List<MyNewPoem> testPoems = TestPoems();
		setMyNewPoems(testPoems);

		for (MyNewPoem myNewPoem : testPoems) {
			System.out.println("author:"
					+ myNewPoem.getPoem().getAuthor().getName());
		}
		List<Item> allTestItems = new ArrayList<Item>();

		for (MyNewPoem myNewPoem : testPoems) {
			Poem poem = myNewPoem.getPoem();
			List<String> sentences = poem.getSentences();
			List<Integer> blanks = poem.geneRand();
			String puncs = poem.getPuncs();

			for (int i = 0; i < sentences.size(); i++) {
				Item item = new Item();
				item.setPoemid(poem.getPid());
				item.setSentenceid(i);
				item.setSentence(sentences.get(i));
				item.setPunc(puncs.charAt(i));
				if (blanks.contains(i)) {
					item.setExist(false);
				} else {
					item.setExist(true);
				}
				System.out.println("Item informaion: poemid: "
						+ item.getPoemid() + " sentenceid: "
						+ item.getSentenceid() + " sentence: "
						+ item.getSentence());
				allTestItems.add(item);
			}
		}
		return allTestItems;
	}

	private Item findByPidAndSid(Integer poemid, Integer sentenceid) {
		for (Item item : allItems) {
			if (item.getPoemid() == poemid
					&& item.getSentenceid() == sentenceid)
				return item;
		}
		return null;
	}

}
