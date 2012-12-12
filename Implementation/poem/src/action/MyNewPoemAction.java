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
	private String mode;
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

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
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
		setAllItems(TestItems(getPercent()));
		return "goTest";
	}

	public String goResult() {
		double correct = 0.0, total = 0.0;
		setAllItems(TestItems(getPercent()));
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

			// testday is used to make sure we do test once a day!
			Date createday = myNewPoem.getCreatedate();
			Date testday = myNewPoem.getTestdate();
			Date today = new Date(System.currentTimeMillis());

			Long distance = ((today.getTime() - createday.getTime()) / (24 * 60 * 60 * 1000));

			// If we havn't do test even once, then do it.
			// If we havn't do test for a long time, then we will do it now.
			// If we have do it today or shortly before, then we wouldn't do it
			// again.
			if (testday == null) {
				testPoems.add(myNewPoem);
			} else if (testday != today && distance > 0
					&& distance >= Math.pow(2, myNewPoem.getCount())) {
				testPoems.add(myNewPoem);
			}
		}
		return testPoems;
	}

	private List<Item> TestItems(double percent) {
		// TODO: User a set to store the right poems!
		List<MyNewPoem> testPoems = TestPoems();
		setMyNewPoems(testPoems);

		List<Item> allTestItems = new ArrayList<Item>();

		for (MyNewPoem myNewPoem : testPoems) {
			Poem poem = myNewPoem.getPoem();
			List<String> sentences = poem.getSentences();
			List<Integer> blanks = poem.geneRand(percent);
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

	// Set the percent of blanks by mode.
	private double getPercent() {
		if (mode.equalsIgnoreCase("easy")) {
			return 0.25;
		} else if (mode.equalsIgnoreCase("hard")) {
			return 0.75;
		} else {
			return 0.5;
		}
	}

}
