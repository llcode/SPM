package dao;

import java.util.List;

import domain.Author;

public interface AuthorDao {

	public Author findByName(String name);

	public List<Author> queryAll();

	public Author findByAid(Author author);

	public void updateAuthor(Author author);

	public void insertAuthor(Author author);

	public void delete(Author author);

}
