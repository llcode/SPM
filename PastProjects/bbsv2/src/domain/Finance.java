package domain;

import java.util.Date;

public class Finance {

	private Integer financeid;			//
	private String classname;			//班级
	private Date excutedate;			//执行日期
	private String status;				//状态  ： +收，-支
	private String reason;				//事由
	private String person;				//执行人
	private float money;
	private float balance;				//余额
	private Userinfo userinfo;

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Integer getFinanceid() {
		return financeid;
	}

	public void setFinanceid(Integer financeid) {
		this.financeid = financeid;
	}

	public String getClassname() {
		return classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public Date getExcutedate() {
		return excutedate;
	}

	public void setExcutedate(Date excutedate) {
		this.excutedate = excutedate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}





}
