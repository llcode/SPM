package dao;

import java.util.List;

import domain.UserCount;
import domain.Userinfo;

public interface UserCountDao {
	public UserCount getUserCountById(int userid);

	public boolean checkPwd(UserCount user);

	public Userinfo getUserinfoById(int userid);

	public void updateUserCount(UserCount user);

	public void updateUserinfo(Userinfo userinfo);

	public UserCount checkLogin(UserCount user);

	public List<Userinfo> getUserinfoList(String sname, String className);

	public Userinfo getUserinfo(UserCount user);

	public List<UserCount> queryAll(String username, String power,String classPower);

	public boolean checkUserName(UserCount user);

	public int checkClassPower(Userinfo userinfo);

	public void saveUserCount(UserCount user, int userinfoid);

}