package domain;

import java.util.Date;
import java.util.Set;

public class Section {

	private Integer sectionid;
	private String name;
	private String description;
	private Integer status; // 板块状态
	private Date lastDate;
	private Set<UserCount> managers; // 板块版主列表
	private Set<Topic> topics; // 板块主题列表

	public Date getLastDate() {
		return lastDate;
	}

	public void setLastDate(Date lastDate) {
		this.lastDate = lastDate;
	}

	public Integer getSectionid() {
		return sectionid;
	}

	public Set<UserCount> getManagers() {
		return managers;
	}

	public void setManagers(Set<UserCount> managers) {
		this.managers = managers;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	public void setSectionid(Integer sectionid) {
		this.sectionid = sectionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
