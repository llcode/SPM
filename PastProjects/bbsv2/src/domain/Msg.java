package domain;

import java.util.Date;

public class Msg {
	private Integer msgid;
	private UserCount fromUser;			//发送人
	private UserCount toUser;			//收件人
	private String title;
	private String content;
	private Date sendtime;
	private String status;			//1未读 2已读 0删除

	public UserCount getFromUser() {
		return fromUser;
	}

	public void setFromUser(UserCount fromUser) {
		this.fromUser = fromUser;
	}

	public void setToUser(UserCount toUser) {
		this.toUser = toUser;
	}

	public Integer getMsgid() {
		return msgid;
	}

	public void setMsgid(Integer msgid) {
		this.msgid = msgid;
	}


	public UserCount getFromid() {
		return fromUser;
	}

	public void setFromid(UserCount fromUser) {
		this.fromUser = fromUser;
	}

	public UserCount getToUser() {
		return toUser;
	}

	public void setToid(UserCount toUser) {
		this.toUser = toUser;
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

	public Date getSendtime() {
		return sendtime;
	}

	public void setSendtime(Date sendtime) {
		this.sendtime = sendtime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
