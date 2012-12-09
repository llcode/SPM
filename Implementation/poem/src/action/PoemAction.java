package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import dao.AuthorDao;
import dao.MyNewPoemDao;
import dao.PoemDao;
import domain.Author;
import domain.MyNewPoem;
import domain.Poem;
import domain.UserCount;

public class PoemAction {

	private Poem poem;
	private PoemDao poemDao;
	private AuthorDao authorDao;
	private MyNewPoemDao myNewPoemDao;

	private List<Poem> list;

	public void setPoemDao(PoemDao poemDao) {
		this.poemDao = poemDao;
	}

	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	public void setMyNewPoemDao(MyNewPoemDao myNewPoemDao) {
		this.myNewPoemDao = myNewPoemDao;
	}

	public Poem getPoem() {
		return poem;
	}

	public void setPoem(Poem poem) {
		this.poem = poem;
	}

	public List<Poem> getList() {
		return list;
	}

	public void setList(List<Poem> list) {
		this.list = list;
	}

	public String index() {
		list = poemDao.queryAll();
		return "index";
	}

	public String show() {
		poem = poemDao.findById(poem);
		return "show";
	}

	public String edit() {
		poem = poemDao.findById(poem);
		System.out.println("poemid: " + poem.getPid() + "\npoem author: "
				+ poem.getAuthor().getName());
		return "edit";
	}

	public String add() {
		Author author = authorDao.findByName(poem.getAuthor().getName());
		if (author == null) {
			poem.setAuthor(null);
			return "add";
		} else {
			poem.setAuthor(author);
			poemDao.savePoem(poem);
			return index();
		}
	}

	public String update() {
		Author author = authorDao.findByName(poem.getAuthor().getName());
		poem.setAuthor(author);
		poemDao.update(poem);
		return show();
	}

	public String delete() {
		poemDao.deletePoem(poem);
		return index();
	}

	public String addToNewPoem() {
		MyNewPoem newPoem = new MyNewPoem();
		UserCount user = (UserCount) ActionContext.getContext().getSession()
				.get("userInSession");
		poem = poemDao.findById(poem);
		newPoem.setUser(user);
		newPoem.setPoem(poem);

		// TODO: Check whether the poem is already in new poem list.
		// Maybe we can do that by adding a method in user domain.
		myNewPoemDao.save(newPoem);
		return show();
	}

}
