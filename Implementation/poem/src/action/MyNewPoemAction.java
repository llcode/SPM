package action;

import java.util.Date;

import dao.MyNewPoemDao;
import dao.UserCountDao;
import domain.MyNewPoem;
import domain.Poem;
import domain.UserCount;

public class MyNewPoemAction {

	private MyNewPoemDao myNewPoemDao;
	private Poem poem;
	private MyNewPoem myNewPoem;

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

	public String addMyNewPoem() {
		// Later, the userid should be get from user session.
		MyNewPoem newPoem = new MyNewPoem();
		UserCount user = new UserCount();
		user.setUserid(200);
		newPoem.setUser(user);
		newPoem.setPoem(poem);
		newPoem.setCount(0);
		newPoem.setCreatedate(new Date(System.currentTimeMillis()));
		myNewPoemDao.save(newPoem);
		return "index";
	}
}
