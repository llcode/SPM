package dao.impl;

import org.hibernate.Hibernate;

import dao.PoemDao;
import domain.Poem;

public class PoemDaoImpl extends BaseDaoImpl implements PoemDao {

	@Override
	public void savePoem(Poem poem) {
		template.save(poem);
	}

	@Override
	public Poem findById(Integer id) {
		Poem poem = (Poem) template.get(Poem.class, id);
		Hibernate.initialize(poem.getAuthor());
		return poem;
	}

}
