package dao.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import dao.PoemDao;
import domain.Favorite;
import domain.MyNewPoem;
import domain.Poem;

public class PoemDaoImpl extends BaseDaoImpl implements PoemDao {

	@Override
	public void savePoem(Poem poem) {
		template.save(poem);
	}

	@Override
	public Poem findById(Poem poem) {
		Session session = sessionFactory.openSession();
		poem = (Poem) session.get(Poem.class, poem.getPid());
		if (poem != null) {
			Hibernate.initialize(poem.getAuthor());
			Hibernate.initialize(poem.getFavoriteLists());
			session.close();
			return poem;
		} else {
			return null;
		}
	}

	@Override
	public void deletePoem(Poem poem) {
		template.delete(poem);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Poem> queryAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Poem.class);
		List<Poem> list = criteria.list();
		for (Poem poem : list) {
			Hibernate.initialize(poem.getAuthor());
		}
		session.close();
		return list;
	}

	@Override
	public void update(Poem poem) {
		template.update(poem);
	}

	@Override
	public void addToFavorites(List<Favorite> favorites, Poem poem) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Poem p = (Poem) session.get(Poem.class, poem.getPid());
		Set<Favorite> set = new HashSet<Favorite>(favorites);
		p.setFavoriteLists(set);
		session.update(p);
		tx.commit();
		session.close();
	}

	@Override
	public void addToNewPoems(MyNewPoem myNewPoem) {
		myNewPoem.setCount(0);
		myNewPoem.setCreatedate(new Date(System.currentTimeMillis()));
		template.save(myNewPoem);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Poem> queryByTitle(String title) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Poem.class);
		criteria.add(Restrictions.like("title", "%" + title + "%"));
		List<Poem> list = criteria.list();
		for (Poem poem : list) {
			Hibernate.initialize(poem.getAuthor());
		}
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Poem> queryByContent(String content) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Poem.class);
		criteria.add(Restrictions.like("content", "%" + content + "%"));
		List<Poem> list = criteria.list();
		for (Poem poem : list) {
			Hibernate.initialize(poem.getAuthor());
		}
		session.close();
		return list;
	}

}
