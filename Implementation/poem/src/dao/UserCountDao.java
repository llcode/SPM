package dao;

import domain.UserCount;

public interface UserCountDao {

	public UserCount findById(Integer id);

	public UserCount checkLogin(UserCount usercount);

	public UserCount checkUserName(UserCount usercount);

	public boolean regist(UserCount usercount);

	public UserCount checkUserEmail(UserCount usercount);

	public void updateUserCount(UserCount usercount);
	
	public void delete(UserCount usercount);

}
