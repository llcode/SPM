package dao.impl;

import org.hibernate.Transaction;
import org.hibernate.classic.Session;

import dao.FavoriteDao;
import domain.Favorite;
import domain.Poem;

public class FavoriteDaoImpl extends BaseDaoImpl implements FavoriteDao {

	@Override
	public void saveFavorite(Favorite favorite) {
		template.save(favorite);
	}

	@Override
	public void addPoem(Favorite favorite, Poem poem) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Favorite f = (Favorite) session.get(Favorite.class, favorite.getFid());
		f.getPoemLists().add(poem);
		session.update(f);
		tx.commit();
		session.close();
	}

	@Override
	public Favorite findById(Integer id) {
		return (Favorite) template.get(Favorite.class, id);
	}

}
