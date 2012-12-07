package dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import dao.FavoriteDao;
import domain.Favorite;
import domain.Poem;
import domain.UserCount;

public class FavoriteDaoImpl extends BaseDaoImpl implements FavoriteDao {

	@Override
	public void save(Favorite favorite) {
		template.save(favorite);
	}

	@Override
	public Favorite findById(Favorite favorite) {
		Session session = sessionFactory.openSession();
		favorite = (Favorite) session.get(Favorite.class, favorite.getFid());
		Hibernate.initialize(favorite.getPoemLists());
		return favorite;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Favorite> queryAll(UserCount user) {
		// Two ways to query all favorites.

		// Session session = sessionFactory.openSession();
		// Criteria criteria = session.createCriteria(Favorite.class);
		// criteria.add(Restrictions.eq("owner", user));
		// List<Favorite> list = criteria.list();
		// session.close();

		DetachedCriteria criteria = DetachedCriteria.forClass(Favorite.class);
		criteria.add(Restrictions.eq("owner", user));
		List<Favorite> list = template.findByCriteria(criteria);
		return list;
	}

	@Override
	public void update(Favorite favorite) {
		template.update(favorite);
	}

	@Override
	public void delete(Favorite favorite) {
		template.delete(favorite);
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
	public void removePoem(Favorite favorite, Poem poem) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Favorite f = (Favorite) session.get(Favorite.class, favorite.getFid());
		Poem p = (Poem) session.get(Poem.class, poem.getPid());
		f.getPoemLists().remove(p);
		session.update(f);
		tx.commit();
		session.close();
	}

}
