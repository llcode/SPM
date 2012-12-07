package dao;

import java.util.List;

import domain.Poem;

public interface PoemDao {
	
	public Poem findById(Poem poem);
	
	public void savePoem(Poem poem);
	
	public void deletePoem(Poem poem);
	
	public List<Poem> queryAll();
	
	public void update(Poem poem);
	
}
