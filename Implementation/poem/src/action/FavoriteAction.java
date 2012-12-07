package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import dao.FavoriteDao;
import domain.Favorite;
import domain.Poem;
import domain.UserCount;

public class FavoriteAction {

	private FavoriteDao favoriteDao;

	private Favorite favorite;
	private Poem poem;

	private List<Favorite> list;
	private List<Poem> poemList;

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

	public void setFavoriteDao(FavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
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

	public String addPoem() {
		favoriteDao.addPoem(favorite, poem);
		return "index";
	}
	
	public String removePoem() {
		favoriteDao.removePoem(favorite, poem);
		return show();
	}

}
