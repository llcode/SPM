package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import dao.UserCountDao;
import domain.UserCount;
import domain.Userinfo;

public class UserCountAction {
	private UserCountDao dao;
	private UserCount user;
	private String code;
	private Userinfo userinfo;
	private String pwd;
	private String newPwd1;
	private String newPwd2;
	private String sname;
	private String className;
	private List<Userinfo> userinfoList;
	private List<UserCount> userList;
	private String keyName;
	private String power;
	private String classPower;

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNewPwd1() {
		return newPwd1;
	}

	public void setNewPwd1(String newPwd1) {
		this.newPwd1 = newPwd1;
	}

	public String getNewPwd2() {
		return newPwd2;
	}

	public void setNewPwd2(String newPwd2) {
		this.newPwd2 = newPwd2;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String valicode) {
		this.code = valicode;
	}

	public UserCount getUser() {
		return user;
	}

	public void setUser(UserCount user) {
		this.user = user;
	}

	public void setDao(UserCountDao dao) {
		this.dao = dao;
	}

	public List<Userinfo> getUserinfoList() {
		return userinfoList;
	}

	public void setUserinfoList(List<Userinfo> userinfoList) {
		this.userinfoList = userinfoList;
	}

	public List<UserCount> getUserList() {
		return userList;
	}

	public void setUserList(List<UserCount> userList) {
		this.userList = userList;
	}

	public String getKeyName() {
		return keyName;
	}

	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getClassPower() {
		return classPower;
	}

	public void setClassPower(String classPower) {
		this.classPower = classPower;
	}

	public String login() {
		/*String ran = (String) ActionContext.getContext().getSession()
				.get("ran");
		if (code.equals(ran)) {*/
			UserCount check = dao.checkLogin(user);
			if (check != null) {
				// 将登陆的用户信息保存在会话中
				ActionContext.getContext().getSession()
						.put("userInSession", check);
				return "SuccessLogin";
			} else {
				return "failLogin";
			}
	/*	} else {
			return "failLogin";
		}*/
	}

	public String goUserEdit() {
		user = (UserCount) ActionContext.getContext().getSession().get("userInSession");
		userinfo = dao.getUserinfoById(user.getUserid());
		return "useredit";
	}

	public String useredit() {
		System.out.println(user.getUserid()+user.getUsername());
		Userinfo ui=dao.getUserinfo(user);
		userinfo.setUserinfoid(ui.getUserinfoid());
		if (dao.checkPwd(user)) {
			dao.updateUserCount(user);
			dao.updateUserinfo(userinfo);
			return "userCenter";
		} else {
			return "useredit";
		}
	}

	public String goPwd() {
		user = (UserCount) ActionContext.getContext().getSession().get("userInSession");
		return "pwdedit";
	}

	public String updatePwd() {
		user=(UserCount) ActionContext.getContext().getSession().get("userInSession");
		if (dao.checkPwd(user) && newPwd1.equals(newPwd2)) {
			user.setPwd(newPwd1);
			dao.updateUserCount(user);
			return "userCenter";
		} else
			return "pwdedit";
	}

	public String goPhoneBook() {
		userinfoList = dao.getUserinfoList(null, null);
		return "phonebook";
	}

	// action 函数名和返回值都需要修改###
	public String searchUserinfo() {
		userinfoList = dao.getUserinfoList(sname, className);
		// 再将userList传递到jsp页面中
		// 返回到本页,struts2是否需要带参数返回###
		return "phonebook";
	}

	public String goRegister(){
		ActionContext.getContext().getSession().clear();
		return "logout";
	}
	
	public String logout(){
		ActionContext.getContext().getSession().clear();
		return "logout";
	}
	
	public String goUserCenter() {
		user = (UserCount) ActionContext.getContext().getSession().get("userInSession");
		System.out.println("asdf:"+user.getUsername());
		
		userinfo = dao.getUserinfo(user);
		return "userCenter";
	}

	public String search() {
		userList = dao.queryAll(keyName, power, classPower);
		return "userManagerList";

	}

	public String goManagerList() {
		userList = dao.queryAll(null, "-1", "-1");
		return "userManagerList";
	}

	public String managerUser() {
		user = dao.getUserCountById(user.getUserid());
		return "userUpdate";
	}

	public String userUpdate() {
		dao.updateUserCount(user);
		return goManagerList();
	}
	
	public String register() {
		if (!dao.checkUserName(user))
			return "no";
		else {
			int userinfoid = dao.checkClassPower(userinfo);
			dao.saveUserCount(user, userinfoid);
			return "ok";
		}
	}
}
