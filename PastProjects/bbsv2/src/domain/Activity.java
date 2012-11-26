package domain;

import java.util.Date;
import java.util.Set;

public class Activity {
	private Integer activityid;		//主键  活动编号
	private UserCount creater;		//创建活动人  
	private String title;			//活动的标题 		 长度100
	private String content;			//活动内容   	长度1000
	private Date starttime;			//活动开始时间
	private String place;			//活动地点		长度100
	private float cost;				//活动花费
	private String status;			//状态标记符：  1正常可用，0不可用
	private Set<UserCount> attendUsers;		//参加活动人
	private Set<Reply> replys;
	
	
	public Set<Reply> getReplys() {
		return replys;
	}

	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}

	public Set<UserCount> getAttendUsers() {
		return attendUsers;
	}

	public void setAttendUsers(Set<UserCount> attendUsers) {
		this.attendUsers = attendUsers;
	}

	public UserCount getCreater() {
		return creater;
	}

	public void setCreater(UserCount creater) {
		this.creater = creater;
	}

	public Integer getActivityid() {
		return activityid;
	}

	public void setActivityid(Integer activityid) {
		this.activityid = activityid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
