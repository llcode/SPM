package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import dao.FavoriteDao;
import dao.UserCountDao;
import domain.Favorite;
import domain.UserCount;

public class UserCountAction {

	// userCountDao是在配置文件中依赖注入（IOC）确定名字，若需重新定义，则要配置该配置文件。
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
		// 判断session中是否还有usercount的信息
		if (usercount != null) {
			userInSession = userCountDao.checkLogin(usercount);
		} else {
			System.out.println("确认usercount中没有内容");
			return "error";
		}
		if (userInSession != null) {
			// 如果登录成功，将用户信息存入会话中
			ActionContext.getContext().getSession()
					.put("userInSession", userInSession);
			// 调用查询模块接口
			// ActionContext.getContext().getSession()
			// .remove(userInSession);
			return goMain();
		} else {
			return "error";

		}

	}

	// 注销用户
	public String loginout() throws Exception {
		System.out.println("进入注销函数");
		ActionContext.getContext().getSession().clear();
		return login();
	}

	// 注册用户
	public String regist() {
		// clear();
		ActionContext.getContext().getSession().put("userNameError", null);
		ActionContext.getContext().getSession().put("userEmailError", null);
		if (usercount != null) {
			if (userCountDao.checkUserName(usercount) != null) {
				ActionContext.getContext().getSession()
						.put("userNameError", "sorry，该用户名已存在。");
				// this.setUsercount(usercount);
				return "regist";
			}
			if (userCountDao.checkUserEmail(usercount) != null) {
				System.out.println("zaaz");
				ActionContext.getContext().getSession()
						.put("userEmailError", "sorry，该邮箱已被注册。");
				return "regist";
			}

		}

		userCountDao.regist(usercount);

		clear();
		return "registsuccess";

	}

	// 由注册页面返回到登陆页面
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

	// 清理session
	public void clear() {
		ActionContext.getContext().getSession().clear();
	}

	public String queryById() {
		System.out.println("显示");
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
					.put("userNameError", "sorry，该用户名已存在。");
			return queryById();
		}
		if (list1 != null && (list1.getUserid() != usercount.getUserid())) {
			ActionContext.getContext().getSession()
					.put("userEmailError", "sorry，该邮箱已存在。");
			return queryById();
		}

		userCountDao.updateUserCount(usercount);
		return login();
	}

}
