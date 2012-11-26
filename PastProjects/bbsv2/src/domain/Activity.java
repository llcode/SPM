package domain;

import java.util.Date;
import java.util.Set;

public class Activity {
	private Integer activityid;		//����  ����
	private UserCount creater;		//�������  
	private String title;			//��ı��� 		 ����100
	private String content;			//�����   	����1000
	private Date starttime;			//���ʼʱ��
	private String place;			//��ص�		����100
	private float cost;				//�����
	private String status;			//״̬��Ƿ���  1�������ã�0������
	private Set<UserCount> attendUsers;		//�μӻ��
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
