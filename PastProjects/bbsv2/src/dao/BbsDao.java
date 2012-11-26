package dao;

import java.util.List;
import java.util.Set;

import domain.Section;
import domain.UserCount;

public interface BbsDao {

	public List<Section> queryAll();

	public List<UserCount> queryUserCounts();

	public Set<UserCount> queryUserCounts(Integer[] userids);

	public void saveSection(Section section);

	public Section querySection(Section section);

	public void delSection(Section section);

}
