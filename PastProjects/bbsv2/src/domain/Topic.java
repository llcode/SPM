package domain;

import java.util.Date;
import java.util.Set;

public class Topic {

	private Integer topicid;
	private String title;
	private String content;
	private Date createtime;
	private Date lastreplytime; // 最后回复时间
	private Date modifytime; // 修改时间
	private String status; // 帖子状态 ：2置顶，1正常，0删除
	private UserCount user; // 发帖人
	private Section section;
	private Set<Reply> replys;

	public Set<Reply> getReplys() {
		return replys;
	}

	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}

	public UserCount getUser() {
		return user;
	}

	public void setUser(UserCount user) {
		this.user = user;
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Integer getTopicid() {
		return topicid;
	}

	public void setTopicid(Integer topicid) {
		this.topicid = topicid;
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

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getLastreplytime() {
		return lastreplytime;
	}

	public void setLastreplytime(Date lastreplytime) {
		this.lastreplytime = lastreplytime;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
