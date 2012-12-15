package dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import dao.UserCountDao;
import domain.UserCount;

public class UserCountDaoImpl extends BaseDaoImpl implements UserCountDao {

	@Override
	public UserCount findById(Integer id) {
		return (UserCount) template.get(UserCount.class, id);

	}

	@Override
	@SuppressWarnings("unchecked")
	public UserCount checkLogin(UserCount usercount) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserCount.class);

		criteria.add(Restrictions.eq("name", usercount.getName()));
		criteria.add(Restrictions.eq("password", usercount.getPassword()));

		List<UserCount> list = template.findByCriteria(criteria);
		return list.size() == 0 ? null : list.get(0);
	}

	@Override
	@SuppressWarnings("unchecked")
	public UserCount checkUserName(UserCount usercount) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserCount.class);

		criteria.add(Restrictions.eq("name", usercount.getName()));
		List<UserCount> list = template.findByCriteria(criteria);
		return list.size() == 0 ? null : list.get(0);
	}

	@Override
	public boolean regist(UserCount usercount) {
		Session session = template.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		session.save(usercount);
		transaction.commit();
		session.close();
		return true;
	}

	@Override
	@SuppressWarnings("unchecked")
	public UserCount checkUserEmail(UserCount usercount) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserCount.class);

		criteria.add(Restrictions.eq("email", usercount.getEmail()));
		List<UserCount> list = template.findByCriteria(criteria);
		return list.size() == 0 ? null : list.get(0);
	}

	@Override
	public void updateUserCount(UserCount usercount) {
		template.update(usercount);
	}

	@Override
	public void delete(UserCount usercount) {
		template.delete(usercount);
	}

}
