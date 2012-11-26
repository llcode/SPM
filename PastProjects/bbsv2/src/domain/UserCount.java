package domain;

import java.util.Set;

public class UserCount {

	private Integer userid;
	private String username;
	private String pwd;
	private String power; // 权限 1管理员 2版主 3普通用户 0删除
	private String classPower; // 班级权限 1班干 2班里成员 3普通用户
	private Integer status;
	private String avatar; // 头像连接
	private String sign; // 个性签名
	private Set<Activity> createActivitys; // 创建的活动
	private Set<Activity> attendActivitys; // 参加的活动
	private Set<Msg> fromMsgs; // 发件箱
	private Set<Msg> toMsgs; // 收件箱
	private Userinfo userinfo; // 对应的真实信息
	private Set<Album> albums; // 相册列表
	private Set<Topic> topics; // 所发主题帖
	private Set<Section> sections; // 管理的板块
	private Set<Reply> replys; // 所有回复

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<Reply> getReplys() {
		return replys;
	}

	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}

	public Set<Section> getSections() {
		return sections;
	}

	public void setSections(Set<Section> sections) {
		this.sections = sections;
	}

	public Set<Topic> getTopics() {
		return topics;
	}

	public void setTopics(Set<Topic> topics) {
		this.topics = topics;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	public void setAlbums(Set<Album> albums) {
		this.albums = albums;
	}

	public Set<Activity> getCreateActivitys() {
		return createActivitys;
	}

	public void setCreateActivitys(Set<Activity> createActivitys) {
		this.createActivitys = createActivitys;
	}

	public Set<Activity> getAttendActivitys() {
		return attendActivitys;
	}

	public void setAttendActivitys(Set<Activity> attendActivitys) {
		this.attendActivitys = attendActivitys;
	}

	public Userinfo getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}

	public Set<Msg> getFromMsgs() {
		return fromMsgs;
	}

	public void setFromMsgs(Set<Msg> fromMsgs) {
		this.fromMsgs = fromMsgs;
	}

	public Set<Msg> getToMsgs() {
		return toMsgs;
	}

	public void setToMsgs(Set<Msg> toMsgs) {
		this.toMsgs = toMsgs;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPower() {
		return power;
	}

	public void setPower(String power) {
		this.power = power;
	}

	public String getClassPower() {
		return classPower;
	}

	public void setClassPower(String classPower) {
		this.classPower = classPower;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
