package dao.impl;

import dao.UserCountDao;
import domain.UserCount;

public class UserCountDaoImpl extends BaseDaoImpl implements UserCountDao {

	@Override
	public UserCount findById(Integer id) {
		return (UserCount) template.get(UserCount.class, id);
	}

}
