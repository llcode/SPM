package dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import dao.MyNewPoemDao;
import domain.MyNewPoem;
import domain.UserCount;

public class MyNewPoemDaoImpl extends BaseDaoImpl implements MyNewPoemDao {

	@Override
	public void save(MyNewPoem myNewPoem) {
		myNewPoem.setCount(0);
		myNewPoem.setCreatedate(new Date(System.currentTimeMillis()));
		template.save(myNewPoem);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MyNewPoem> queryAll(UserCount user) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(MyNewPoem.class);
		criteria.add(Restrictions.eq("user", user));
		criteria.addOrder(Order.asc("newpid"));

		// lazy load poem information
		List<MyNewPoem> list = criteria.list();
		for (MyNewPoem myNewPoem : list) {
			Hibernate.initialize(myNewPoem.getPoem());
			Hibernate.initialize(myNewPoem.getPoem().getAuthor());
		}
		session.close();
		return list;
	}

}
