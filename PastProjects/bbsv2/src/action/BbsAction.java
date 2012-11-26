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

	/** �����ҳ */
	public String goBbsIndex() {
		sections = bbsDao.queryAll();
		return "index";
	}

	/** ���������ҳ�� */
	public String goAddSection() {
		// TODO �û�Ȩ��У�飺�����¼������Ϊ����Ա
		// ��ѯ��Ч�û��б�
		userCounts = bbsDao.queryUserCounts();
		return "addSection";
	}

	/** ������� */
	public String addSection() {
		// TODO �û�Ȩ��У�飺�����¼������Ϊ����Ա

		System.out.println(Arrays.toString(userids));
		// �����û�ID��ѯ�û��б�
		Set<UserCount> userCounts = bbsDao.queryUserCounts(userids);

		// �������
		section.setManagers(userCounts);
		section.setStatus(1);// ��Ч

		bbsDao.saveSection(section);
		return goBbsIndex();
	}

	/** ��������ҳ�� */
	public String goSectionManage() {
		sections = bbsDao.queryAll();
		return "sectionManage";
	}

	/** ��������ҳ�� */
	public String goEditSection() {
		section = bbsDao.querySection(section);
		managers = section.getManagers();
		// ��ѯ��Ч�û��б�
		userCounts = bbsDao.queryUserCounts();
		System.out.println(userCounts.size() + ":" + managers.size());
		return "editSection";
	}

	/** ������ */
	public String editSection() {
		// ���±�����
		Section sec = bbsDao.querySection(section);

		// ���ñ�����
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
	 * @return ǰ̨���ذ��ID sectionid;
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
