package dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import dao.AlbumDao;
import domain.Album;
import domain.UserCount;

public class AlbumDaoImpl extends BaseDaoImpl implements AlbumDao {

	@SuppressWarnings("unchecked")
	public List<Album> queryAlbums() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Album.class);
		criteria.add(Restrictions.eq("power", 1));
		List<Album> list = criteria.list();
		for (Album album : list) {
			Hibernate.initialize(album.getPhotos());
		}
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<Album> queryAlbumsByUser(UserCount userCount) {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Album.class);
		criteria.add(Restrictions.eq("owner.userid", userCount.getUserid()));
		List<Album> list = criteria.list();
		for (Album album : list) {
			Hibernate.initialize(album.getPhotos());
		}
		session.close();
		return list;
	}
}
