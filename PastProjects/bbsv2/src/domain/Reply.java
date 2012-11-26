package domain;

import java.util.Date;

public class Reply {
	private Integer replyid;
	private Integer parentid;		//回复的主题(活动，照片)编号
	private String content;
	private UserCount user;			//回复人
	private String type;			//回复类型，T回复论坛主题帖，A回复活动，P回复照片
	private Date createtime;		//回复时间
	private Date modifytime;		//修改时间

	
	public UserCount getUser() {
		return user;
	}

	public void setUser(UserCount user) {
		this.user = user;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Integer getReplyid() {
		return replyid;
	}

	public void setReplyid(Integer replyid) {
		this.replyid = replyid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

}
