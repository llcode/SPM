package dao.impl;

import dao.MyNewPoemDao;
import domain.MyNewPoem;

public class MyNewPoemDaoImpl extends BaseDaoImpl implements MyNewPoemDao {

	@Override
	public void save(MyNewPoem myNewPoem) {
		template.save(myNewPoem);
	}

}
