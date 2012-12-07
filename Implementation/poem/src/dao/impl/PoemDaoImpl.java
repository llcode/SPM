package dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.classic.Session;
import dao.PoemDao;
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
		Hibernate.initialize(poem.getAuthor());
		Hibernate.initialize(poem.getFavoriteLists());
		return poem;
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

}
