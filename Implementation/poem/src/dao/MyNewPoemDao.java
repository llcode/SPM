package dao;

import java.util.List;

import domain.MyNewPoem;
import domain.UserCount;

public interface MyNewPoemDao {
	
	public void save(MyNewPoem myNewPoem);
	
	public void delete(MyNewPoem myNewPoem);
	
	public List<MyNewPoem> queryAll(UserCount user);

}
