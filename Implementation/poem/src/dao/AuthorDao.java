package dao;

import domain.Author;

public interface AuthorDao {
	
	public Author findByName(String name);

}
