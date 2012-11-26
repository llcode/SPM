package dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.UserCountDao;
import domain.UserCount;
import domain.Userinfo;

public class UserCountDaoImpl implements UserCountDao {
	private HibernateTemplate template;

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public UserCount getUserCountById(int userid) {
		return (UserCount) template.get(UserCount.class, userid);
	}

	public boolean checkPwd(UserCount user) {

		System.out.println(user.getUserid());
		UserCount u = (UserCount) template.get(UserCount.class,
				user.getUserid());
		return u.getPwd().equals(user.getPwd());
	}

	public Userinfo getUserinfoById(int userid) {
		Session session = template.getSessionFactory().openSession();
		UserCount user = (UserCount) session.get(UserCount.class, userid);
		Userinfo userinfo = user.getUserinfo();
		session.close();
		return userinfo;
	}

	public void updateUserinfo(Userinfo userinfo) {
		Userinfo u = (Userinfo) template.get(Userinfo.class,
				userinfo.getUserinfoid());
		u.setEmail(userinfo.getEmail());
		u.setBirthday(userinfo.getBirthday());
		u.setDormitory(userinfo.getDormitory());
		u.setHometown(userinfo.getHometown());
		u.setQQ(userinfo.getQQ());
		u.setSname(userinfo.getSname());
		u.setSno(userinfo.getSno());
		template.update(u);
	}

	@SuppressWarnings("unchecked")
	public UserCount checkLogin(UserCount user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserCount.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		criteria.add(Restrictions.eq("pwd", user.getPwd()));

		List<UserCount> list = template.findByCriteria(criteria);
		return list.size() == 0 ? null : list.get(0);
	}

	public List<Userinfo> getUserinfoList(String sname, String className) {
		List<Userinfo> list;

		DetachedCriteria criteria = DetachedCriteria.forClass(Userinfo.class);

		if (null != sname) {
			if (sname.trim().length() != 0)
				criteria.add(Restrictions.like("sname", "%" + sname + "%"));
		}
		if (null != className) {
			if (className.trim().length() != 0)
				criteria.add(Restrictions.like("classname", "%" + className
						+ "%"));
		}
		list = template.findByCriteria(criteria);
		return list;
	}

	public Userinfo getUserinfo(UserCount user) {
		Session session = template.getSessionFactory().openSession();

		user = (UserCount) session.get(UserCount.class, user.getUserid());

		Userinfo userinfo = user.getUserinfo();
		session.close();
		return userinfo;

		// DetachedCriteria criteria =
		// DetachedCriteria.forClass(Userinfo.class);
		// criteria.add(Restrictions.eq("user", user));
		// System.out.println(template.findByCriteria(criteria).size());
		// return (Userinfo) template.findByCriteria(criteria).get(0);
	}

	public List<UserCount> queryAll(String username, String power,
			String classPower) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserCount.class);
		if (username != null)
			criteria.add(Restrictions.like("username", "%" + username + "%"));
		if (!power.equals("-1"))
			criteria.add(Restrictions.eq("power", power));
		if (!classPower.equals("-1"))
			criteria.add(Restrictions.eq("classPower", classPower));
		List<UserCount> u = template.findByCriteria(criteria);
		return u;
	}

	public UserCount findById(Integer userid) {

		UserCount u = (UserCount) template.get(UserCount.class, userid);
		return u;
	}

	// 5.更新用户名 初始化密码及用户权限
	public void updateUserCount(UserCount user) {
		UserCount u = getUserCountById(user.getUserid());
		u.setUsername(user.getUsername());
		u.setPwd(user.getPwd());
		u.setPower(user.getPower());
		template.update(u);
	}

	public int checkClassPower(Userinfo userinfo) {
		Session session = template.getSessionFactory().openSession();

		Criteria criteria = session.createCriteria(Userinfo.class);
		criteria.add(Restrictions.eq("sno", userinfo.getSno()));
		criteria.add(Restrictions.eq("sname", userinfo.getSname()));
		// criteria.add(Restrictions.isEmpty("user"));
		List<Userinfo> list = criteria.list();
		if (list.size() > 0) {
			Userinfo u = list.get(0);
			System.out.println(u.getUser());
			if (u.getUser() != null) {
				System.out.println(u.getUser().getUsername());
				session.close();
				return 0;
			} else {
				session.close();
				return u.getUserinfoid();
			}
		} else {
			session.close();
			return 0;
		}
	}

	public boolean checkUserName(UserCount user) {
		DetachedCriteria criteria = DetachedCriteria.forClass(UserCount.class);
		criteria.add(Restrictions.eq("username", user.getUsername()));
		List<UserCount> list = template.findByCriteria(criteria);
		if (list.size() > 0)
			return false;
		else
			return true;
	}

	public void saveUserCount(UserCount user, int userinfoid) {
		if (userinfoid > 0) {
			Userinfo userinfo = (Userinfo) template.get(Userinfo.class,
					userinfoid);
			user.setClassPower("2");
			user.setPower("3");
			user.setUserinfo(userinfo);
			template.save(user);
			userinfo.setUser(user);
			template.update(userinfo);
		} else {
			user.setPower("3");
			user.setClassPower("3");
			template.save(user);
		}
	}
}
