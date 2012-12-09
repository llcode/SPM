package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import dao.FavoriteDao;
import dao.PoemDao;
import domain.Favorite;
import domain.Poem;
import domain.UserCount;

public class FavoriteAction {

	private FavoriteDao favoriteDao;
	private PoemDao poemDao;

	private Favorite favorite;
	private Poem poem;

	private List<Favorite> list;
	private List<Poem> poemList;
	private List<String> chklist;

	public Favorite getFavorite() {
		return favorite;
	}

	public void setFavorite(Favorite favorite) {
		this.favorite = favorite;
	}

	public Poem getPoem() {
		return poem;
	}

	public void setPoem(Poem poem) {
		this.poem = poem;
	}

	public List<Favorite> getList() {
		return list;
	}

	public void setList(List<Favorite> list) {
		this.list = list;
	}

	public List<Poem> getPoemList() {
		return poemList;
	}

	public void setPoemList(List<Poem> poemList) {
		this.poemList = poemList;
	}

	public List<String> getChklist() {
		return chklist;
	}

	public void setChklist(List<String> chklist) {
		this.chklist = chklist;
	}

	public void setFavoriteDao(FavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
	}

	public void setPoemDao(PoemDao poemDao) {
		this.poemDao = poemDao;
	}

	public String index() {
		UserCount user = (UserCount) ActionContext.getContext().getSession()
				.get("userInSession");
		list = favoriteDao.queryAll(user);
		return "index";
	}

	public String show() {
		favorite = favoriteDao.findById(favorite);
		poemList = new ArrayList<Poem>(favorite.getPoemLists());
		return "show";
	}

	public String edit() {
		favorite = favoriteDao.findById(favorite);
		return "edit";
	}

	public String add() {
		UserCount user = (UserCount) ActionContext.getContext().getSession()
				.get("userInSession");
		if (user == null) {
			return "add";
		} else {
			favorite.setOwner(user);
			favoriteDao.save(favorite);
			return index();
		}
	}

	public String update() {
		UserCount user = (UserCount) ActionContext.getContext().getSession()
				.get("userInSession");
		favorite.setOwner(user);
		favoriteDao.update(favorite);
		return show();
	}

	public String delete() {
		favoriteDao.delete(favorite);
		return index();
	}

	public String goAddPoem() {
		UserCount user = (UserCount) ActionContext.getContext().getSession()
				.get("userInSession");
		list = favoriteDao.queryAll(user);
		poem = poemDao.findById(poem);
		return "addPoem";
	}

	public String addPoem() {
		poem = poemDao.findById(poem);
		List<Favorite> fl = new ArrayList<Favorite>();
		for (String s : chklist) {
			if (!s.equals("false")) {
				Favorite f = new Favorite();
				f.setFid(Integer.parseInt(s));
				fl.add(f);
			}
		}
		poemDao.addToFavorites(fl, poem);
		return index();
	}

	public String removePoem() {
		favoriteDao.removePoem(favorite, poem);
		return show();
	}

}
