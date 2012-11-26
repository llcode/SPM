package dao;

import domain.Favorite;
import domain.Poem;

public interface FavoriteDao {
	
	public Favorite findById(Integer id);

	public void saveFavorite(Favorite favorite);
	
	public void addPoem(Favorite favorite, Poem poem);

}
