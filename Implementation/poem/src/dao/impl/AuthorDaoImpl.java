package dao.impl;

import java.util.List;

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

}
