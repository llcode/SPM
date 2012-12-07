package action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dao.AuthorDao;
import dao.PoemDao;
import domain.Author;
import domain.Favorite;
import domain.Poem;

public class PoemAction {

	private Poem poem;
	private PoemDao poemDao;
	private AuthorDao authorDao;
	private List<Poem> list;
	private Map<Integer, String> favoriteList = new HashMap<Integer, String>();

	public void setPoemDao(PoemDao poemDao) {
		this.poemDao = poemDao;
	}

	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
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

	public Map<Integer, String> getFavoriteList() {
		return favoriteList;
	}

	public void setFavoriteList(Map<Integer, String> favoriteList) {
		this.favoriteList = favoriteList;
	}

	public String index() {
		list = poemDao.queryAll();
		return "index";
	}

	public String show() {
		poem = poemDao.findById(poem);
		Set<Favorite> favorites = poem.getFavoriteLists();
		for (Favorite favorite : favorites) {
			favoriteList.put(favorite.getFid(), favorite.getName());
		}
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

}
