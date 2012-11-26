package domain;

import java.util.Date;
import java.util.Set;

public class Userinfo {
	private Integer userinfoid;
	private String sname;
	private String sno;
	private String gender;
	private Date birthday;
	private String QQ;
	private String Tel;
	private String email;
	private String classname;
	private String dormitory;
	private String hometown;
	private UserCount user;
	private Set<Finance> financeCreater;

	public Set<Finance> getFinanceCreater() {
		return financeCreater;
	}

	public void setFinanceCreater(Set<Finance> financeCreater) {
		this.financeCreater = financeCreater;
	}

	public UserCount getUser() {
		return user;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public void setUser(UserCount user) {
		this.user = user;
	}

	public Integer getUserinfoid() {
		return userinfoid;
	}

	public void setUserinfoid(Integer userinfoid) {
		this.userinfoid = userinfoid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}


	public String getSno() {
		return sno;
	}

	public void setStuno(String sno) {
		this.sno = sno;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public String getTel() {
		return Tel;
	}

	public void setTel(String tel) {
		Tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getDormitory() {
		return dormitory;
	}

	public void setDormitory(String dormitory) {
		this.dormitory = dormitory;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

}
