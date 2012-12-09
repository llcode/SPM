package dao;

import java.util.List;

import domain.Favorite;
import domain.MyNewPoem;
import domain.Poem;

public interface PoemDao {
	
	public Poem findById(Poem poem);
	
	public void savePoem(Poem poem);
	
	public void deletePoem(Poem poem);
	
	public List<Poem> queryAll();
	
	public void update(Poem poem);
	
	public void addToFavorites(List<Favorite> favorites, Poem poem);
	
	public void addToNewPoems(MyNewPoem myNewPoem);
	
}
