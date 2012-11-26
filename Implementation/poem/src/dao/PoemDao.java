package dao;

import domain.Poem;

public interface PoemDao {
	
	public Poem findById(Integer id);
	
	public void savePoem(Poem poem);
	
}
