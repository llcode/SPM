package test.unit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.MyNewPoemDao;
import domain.MyNewPoem;
import domain.Poem;
import domain.UserCount;

public class MyNewPoemDaoImplTest {

	private final static Log log = LogFactory
			.getLog(MyNewPoemDaoImplTest.class);

	private MyNewPoemDao myNewPoemDao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"/WebContent/WEB-INF/applicationContext.xml");
		myNewPoemDao = (MyNewPoemDao) ctx.getBean("myNewPoemDao");
	}

	@Test
	public void testSaveAndDelete() {
		UserCount user = new UserCount();
		user.setUserid(300);
		Poem poem = new Poem();
		poem.setPid(305);
		MyNewPoem myNewPoem = new MyNewPoem();
		myNewPoem.setUser(user);
		myNewPoem.setPoem(poem);

		List<MyNewPoem> oldnpl = myNewPoemDao.queryAll(user);
		log.info("My new poem size before add : " + oldnpl.size());
		myNewPoemDao.save(myNewPoem);
		List<MyNewPoem> newnpl = myNewPoemDao.queryAll(user);
		log.info("My new poem size after add: " + newnpl.size());
		assertEquals(1, newnpl.size() - oldnpl.size());

		log.info("remove poem from new poem list.");
		myNewPoemDao.delete(myNewPoem);
		newnpl = myNewPoemDao.queryAll(user);
		log.info("My new poem size after delete: " + newnpl.size());
		assertEquals(oldnpl.size(), newnpl.size());
	}

	@Test
	public void testQueryAll() {
		UserCount user = new UserCount();
		user.setUserid(300);
		List<MyNewPoem> nplist = myNewPoemDao.queryAll(user);
		List<Integer> ids = new ArrayList<Integer>();
		for (MyNewPoem myNewPoem : nplist) {
			log.info("poem id in user 300's new poem list: " + myNewPoem.getNewpid());
			ids.add(myNewPoem.getPoem().getPid());
		}
		for (int i = 300; i < 304; i++) {
			assertTrue(ids.contains(i));
		}
	}

}