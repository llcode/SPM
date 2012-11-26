package dao.impl;

import dao.PoemDao;
import domain.Poem;

public class PoemDaoImpl extends BaseDaoImpl implements PoemDao {

	@Override
	public void savePoem(Poem poem) {
		template.save(poem);
	}

	@Override
	public Poem findById(Integer id) {
		return (Poem) template.get(Poem.class, id);
	}

}
