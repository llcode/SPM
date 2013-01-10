package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import dao.FavoriteDao;
import dao.UserCountDao;
import domain.Favorite;
import domain.UserCount;

public class UserCountAction {

	// userCountDao���������ļ�������ע�루IOC��ȷ�����֣��������¶��壬��Ҫ���ø������ļ���
	private UserCountDao userCountDao;
	private FavoriteDao favoriteDao;

	private UserCount usercount;
	private List<Favorite> favoriteList;

	public UserCount getUsercount() {
		return usercount;
	}

	public void setUsercount(UserCount usercount) {
		this.usercount = usercount;
	}

	public UserCountDao getUserCountDao() {
		return userCountDao;
	}

	public List<Favorite> getFavoriteList() {
		return favoriteList;
	}

	public void setFavoriteList(List<Favorite> favoriteList) {
		this.favoriteList = favoriteList;
	}

	public void setUserCountDao(UserCountDao userCountDao) {
		this.userCountDao = userCountDao;
	}

	public void setFavoriteDao(FavoriteDao favoriteDao) {
		this.favoriteDao = favoriteDao;
	}

	public String login() {
		UserCount userInSession = null;
		// �ж�session���Ƿ���usercount����Ϣ
		if (usercount != null) {
			userInSession = userCountDao.checkLogin(usercount);
		} else {
			System.out.println("ȷ��usercount��û������");
			return "error";
		}
		if (userInSession != null) {
			// �����¼�ɹ������û���Ϣ����Ự��
			ActionContext.getContext().getSession()
					.put("userInSession", userInSession);
			// ���ò�ѯģ��ӿ�
			// ActionContext.getContext().getSession()
			// .remove(userInSession);
			return goMain();
		} else {
			return "error";

		}

	}

	// ע���û�
	public String loginout() throws Exception {
		System.out.println("����ע������");
		ActionContext.getContext().getSession().clear();
		return login();
	}

	// ע���û�
	public String regist() {
		// clear();
		ActionContext.getContext().getSession().put("userNameError", null);
		ActionContext.getContext().getSession().put("userEmailError", null);
		if (usercount != null) {
			if (userCountDao.checkUserName(usercount) != null) {
				ActionContext.getContext().getSession()
						.put("userNameError", "sorry�����û����Ѵ��ڡ�");
				// this.setUsercount(usercount);
				return "regist";
			}
			if (userCountDao.checkUserEmail(usercount) != null) {
				System.out.println("zaaz");
				ActionContext.getContext().getSession()
						.put("userEmailError", "sorry���������ѱ�ע�ᡣ");
				return "regist";
			}

		}

		userCountDao.regist(usercount);

		clear();
		return "registsuccess";

	}

	// ��ע��ҳ�淵�ص���½ҳ��
	public String goLogin() {
		clear();
		return "gologin";
	}

	public String goMain() {
		ActionContext.getContext().getSession().put("userNameError", null);
		ActionContext.getContext().getSession().put("userEmailError", null);

		UserCount user = (UserCount) ActionContext.getContext().getSession()
				.get("userInSession");
		favoriteList = favoriteDao.queryAll(user);
		System.out.println("favorite size: " + favoriteList.size());
		return "goMain";
	}

	// ����session
	public void clear() {
		ActionContext.getContext().getSession().clear();
	}

	public String queryById() {
		System.out.println("��ʾ");
		System.out.println(usercount.getUserid());
		usercount = userCountDao.findById(usercount.getUserid());
		return "queryById";
	}

	public String update() {
		UserCount list = userCountDao.checkUserName(usercount);
		UserCount list1 = userCountDao.checkUserEmail(usercount);
		ActionContext.getContext().getSession().put("userNameError", null);
		ActionContext.getContext().getSession().put("userEmailError", null);
		if (list != null && (list.getUserid() != usercount.getUserid())) {
			ActionContext.getContext().getSession()
					.put("userNameError", "sorry�����û����Ѵ��ڡ�");
			return queryById();
		}
		if (list1 != null && (list1.getUserid() != usercount.getUserid())) {
			ActionContext.getContext().getSession()
					.put("userEmailError", "sorry���������Ѵ��ڡ�");
			return queryById();
		}

		userCountDao.updateUserCount(usercount);
		return login();
	}

}
