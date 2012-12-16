package test.unit;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.MyNewPoemDao;

public class MyNewPoemDaoImplTest {

	private final static Log log = LogFactory.getLog(MyNewPoemDaoImplTest.class);

	private MyNewPoemDao myNewPoemDao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"/WebContent/WEB-INF/applicationContext.xml");
		myNewPoemDao = (MyNewPoemDao) ctx.getBean("myNewPoemDao");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryAll() {
		fail("Not yet implemented");
	}

}
