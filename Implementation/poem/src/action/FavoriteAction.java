package action;

import dao.FavoriteDao;
import dao.PoemDao;
import domain.Favorite;
import domain.Poem;

public class FavoriteAction {

	private FavoriteDao favoriteDao;
	private PoemDao poemDao;

	private Favorite favorite;
	private Poem poem;

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

	public void setFavoriteDao(FavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
	}

	public void setPoemDao(PoemDao poemDao) {
		this.poemDao = poemDao;
	}

	public String addPoem() {
		poem = poemDao.findById(poem.getPid());
		favorite = favoriteDao.findById(favorite.getFid());
		favoriteDao.addPoem(favorite, poem);
		return "index";
	}

}
