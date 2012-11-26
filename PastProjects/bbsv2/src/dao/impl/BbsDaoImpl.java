package dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import dao.BbsDao;
import domain.Reply;
import domain.Section;
import domain.Topic;
import domain.UserCount;

public class BbsDaoImpl extends BaseDaoImpl implements BbsDao {

	@SuppressWarnings("unchecked")
	public List<Section> queryAll() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Section.class);
		criteria.addOrder(Order.asc("sectionid"));

		// ÀÁ¼ÓÔØ°æÖ÷ÐÅÏ¢(set)
		List<Section> list = criteria.list();
		for (Section section : list) {
			Hibernate.initialize(section.getManagers());
			Set<Topic> topics = section.getTopics();
			for (Topic topic : topics) {
				Hibernate.initialize(topic.getReplys());
			}
		}
		session.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	public List<UserCount> queryUserCounts() {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserCount.class);
		criteria.add(Restrictions.eq("power", "2"));
		criteria.add(Restrictions.eq("status", 1));
		List<UserCount> list = template.findByCriteria(criteria);
		return list;
	}

	public Set<UserCount> queryUserCounts(Integer[] userids) {
		Set<UserCount> set = new HashSet<UserCount>();
		Session session = sessionFactory.openSession();
		for (Integer id : userids) {
			set.add((UserCount) session.get(UserCount.class, id));
		}
		session.close();
		return set;
	}

	public void saveSection(Section section) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.saveOrUpdate(section);

		transaction.commit();
		session.close();

	}

	public Section querySection(Section section) {
		Session session = sessionFactory.openSession();
		section = (Section) session.get(Section.class, section.getSectionid());
		Hibernate.initialize(section.getManagers());
		session.close();
		return section;
	}

	public void delSection(Section section) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		section = (Section) session.get(Section.class, section.getSectionid());
		Set<Topic> topics = section.getTopics();
		for (Topic topic : topics) {
			Set<Reply> replys = topic.getReplys();
			for (Reply reply : replys) {
				// É¾³ý»Ø¸´
				session.delete(reply);
			}
			// É¾³ýÖ÷ÌâÌû
			session.delete(topic);
		}
		// É¾³ý°æ¿é
		session.delete(section);

		transaction.commit();
		session.close();
	}

}
