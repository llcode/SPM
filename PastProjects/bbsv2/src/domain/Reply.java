package domain;

import java.util.Date;

public class Reply {
	private Integer replyid;
	private Integer parentid;		//�ظ�������(�����Ƭ)���
	private String content;
	private UserCount user;			//�ظ���
	private String type;			//�ظ����ͣ�T�ظ���̳��������A�ظ����P�ظ���Ƭ
	private Date createtime;		//�ظ�ʱ��
	private Date modifytime;		//�޸�ʱ��

	
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
