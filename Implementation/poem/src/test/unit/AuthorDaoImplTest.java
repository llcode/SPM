package test.unit;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.AuthorDao;

public class AuthorDaoImplTest {

	private final static Log log = LogFactory.getLog(AuthorDaoImplTest.class);

	private AuthorDao authorDao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"/WebContent/WEB-INF/applicationContext.xml");
		authorDao = (AuthorDao) ctx.getBean("authorDao");
	}

	@Test
	public void testFindByName() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindByAid() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateAuthor() {
		fail("Not yet implemented");
	}

	@Test
	public void testInsertAuthor() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryByName() {
		fail("Not yet implemented");
	}

}
