package action;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import dao.BbsDao;
import domain.Section;
import domain.Topic;
import domain.UserCount;

public class BbsAction {

	private BbsDao bbsDao;

	private Section section;
	private List<Section> sections;
	private List<UserCount> userCounts;
	private UserCount usercount;
	private Set<UserCount> managers;
	private List<Topic> topics;

	public Set<UserCount> getManagers() {
		return managers;
	}

	public void setManagers(Set<UserCount> managers) {
		this.managers = managers;
	}

	private Integer[] userids;

	public List<UserCount> getUserCounts() {
		return userCounts;
	}

	public void setUserCounts(List<UserCount> userCounts) {
		this.userCounts = userCounts;
	}

	public Integer[] getUserids() {
		return userids;
	}

	public void setUserids(Integer[] userids) {
		this.userids = userids;
	}

	public void setBbsDao(BbsDao bbsDao) {
		this.bbsDao = bbsDao;
	}

	public UserCount getUsercount() {
		return usercount;
	}

	public void setUsercount(UserCount usercount) {
		this.usercount = usercount;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	public void setSection(Section section) {
		this.section = section;
	}

	public Section getSection() {
		return this.section;
	}

	/** 版块首页 */
	public String goBbsIndex() {
		sections = bbsDao.queryAll();
		return "index";
	}

	/** 至新增版块页面 */
	public String goAddSection() {
		// TODO 用户权限校验：必须登录，必须为管理员
		// 查询有效用户列表
		userCounts = bbsDao.queryUserCounts();
		return "addSection";
	}

	/** 新增版块 */
	public String addSection() {
		// TODO 用户权限校验：必须登录，必须为管理员

		System.out.println(Arrays.toString(userids));
		// 根据用户ID查询用户列表
		Set<UserCount> userCounts = bbsDao.queryUserCounts(userids);

		// 新增版块
		section.setManagers(userCounts);
		section.setStatus(1);// 有效

		bbsDao.saveSection(section);
		return goBbsIndex();
	}

	/** 至版块管理页面 */
	public String goSectionManage() {
		sections = bbsDao.queryAll();
		return "sectionManage";
	}

	/** 至版块更新页面 */
	public String goEditSection() {
		section = bbsDao.querySection(section);
		managers = section.getManagers();
		// 查询有效用户列表
		userCounts = bbsDao.queryUserCounts();
		System.out.println(userCounts.size() + ":" + managers.size());
		return "editSection";
	}

	/** 版块更新 */
	public String editSection() {
		// 更新表单数据
		Section sec = bbsDao.querySection(section);

		// 设置表单数据
		sec.setName(section.getName());
		sec.setDescription(section.getDescription());
		sec.setStatus(section.getStatus());
		System.out.println(Arrays.toString(userids));
		managers = bbsDao.queryUserCounts(userids);
		sec.setManagers(managers);

		bbsDao.saveSection(sec);
		return goSectionManage();
	}

	public String delSection() {
		bbsDao.delSection(section);
		return goSectionManage();
	}

	public String login() {
		return goBbsIndex();
	}

	/**
	 * 
	 * @return 前台传回版块ID sectionid;
	 */
	public String goInTo() {
		bbsDao.querySection(section);
		System.out.println(section.getSectionid());
		return "intoTopic";
	}

	
	
	public String goInUser() {
		System.out.println(usercount.getUserid());
		return "intoUser";
	}

}
