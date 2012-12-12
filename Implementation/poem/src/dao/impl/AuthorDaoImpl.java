package dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import dao.AuthorDao;
import domain.Author;

public class AuthorDaoImpl extends BaseDaoImpl implements AuthorDao {

	@SuppressWarnings("unchecked")
	@Override
	public Author findByName(String name) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Author.class);
		criteria.add(Restrictions.eq("name", name));
		List<Author> list = template.findByCriteria(criteria);
		return list.size() == 0 ? null : list.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> queryAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Author.class);
		List<Author> list = template.findByCriteria(criteria);
		return list;
	}

	@Override
	public Author findByAid(Author author) {
		Session session = sessionFactory.openSession();
		author = (Author) session.get(Author.class, author.getAid());
		Hibernate.initialize(author.getPoems());
		session.close();
		return author;
	}

	@Override
	public void updateAuthor(Author author) {
		template.saveOrUpdate(author);
	}

	@Override
	public void insertAuthor(Author author) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.save(author);
		transaction.commit();
		session.close();
	}

	@Override
	public void delete(Author author) {
		template.delete(author);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Author> queryByName(String name) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Author.class);
		criteria.add(Restrictions.like("name", "%" + name + "%"));
		List<Author> list = template.findByCriteria(criteria);
		return list;
	}

}
