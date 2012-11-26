package dao;

import java.util.List;

import domain.Section;
import domain.UserCount;

public interface SectionDao {
	
	public List<Section> queryAll();
	
	public List<UserCount> getManagerById(Section section);

}
