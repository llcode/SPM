package test.unit;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.FavoriteDao;

public class FavoriteDaoImplTest {

	private final static Log log = LogFactory.getLog(FavoriteDaoImplTest.class);

	private FavoriteDao favoriteDao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"/WebContent/WEB-INF/applicationContext.xml");
		favoriteDao = (FavoriteDao) ctx.getBean("favoriteDao");
	}

	@Test
	public void testSave() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindById() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryAll() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddPoem() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemovePoem() {
		fail("Not yet implemented");
	}

}
