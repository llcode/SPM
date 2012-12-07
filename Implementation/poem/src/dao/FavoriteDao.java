package dao;

import java.util.List;

import domain.Favorite;
import domain.Poem;
import domain.UserCount;

public interface FavoriteDao {

	public Favorite findById(Favorite favorite);

	public void save(Favorite favorite);
	
	public void update(Favorite favorite);
	
	public void delete(Favorite favorite);

	public List<Favorite> queryAll(UserCount user);

	public void addPoem(Favorite favorite, Poem poem);
	
	public void removePoem(Favorite favorite, Poem poem);

}
