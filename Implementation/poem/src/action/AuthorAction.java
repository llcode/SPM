package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import dao.AuthorDao;
import domain.Author;
import domain.Poem;

public class AuthorAction {
	private Author author;
	private AuthorDao authorDao;
	private List<Poem> poems;
	private List<Author> authors;

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Poem> getPoems() {
		return poems;
	}

	public void setPoems(List<Poem> poems) {
		this.poems = poems;
	}

	public AuthorDao getAuthorDao() {
		return authorDao;
	}

	public void setAuthorDao(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public String index() {
		authors = authorDao.queryAll();
		return "index";
	}

	// 显示作者个人信息
	public String show() {
		author = authorDao.findByAid(author);
		poems = new ArrayList<Poem>(author.getPoems());
		System.out.println("size in action: " + poems.size());
		return "show";
	}

	public String edit() {
		author = authorDao.findByAid(author);
		return "edit";
	}

	// 添加诗人信息
	public String add() {
		if (authorDao.findByName(author.getName()) != null) {
			ActionContext.getContext().getSession()
					.put("author", "sorry，该作者已存在！");
			return "add";
		}
		authorDao.insertAuthor(author);
		ActionContext.getContext().getSession().put("author", null);
		return index();
	}

	// 更新诗人信息
	public String update() {
		authorDao.updateAuthor(author);
		author = authorDao.findByAid(author);
		return show();
	}

	public String delete() {
		authorDao.delete(author);
		return index();
	}

}
