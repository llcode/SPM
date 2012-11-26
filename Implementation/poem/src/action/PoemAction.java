package action;

import dao.AuthorDao;
import dao.PoemDao;
import domain.Author;
import domain.Poem;

public class PoemAction {

	private String authorName;
	private Poem poem;
	private PoemDao poemDao;
	private AuthorDao authorDao;

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

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String addPoem() {
		Author author = authorDao.findByName(authorName);
		if (author == null) {
			return "add";
		} else {
			poem.setAuthor(author);
			poemDao.savePoem(poem);
			return "index";
		}
	}
}
