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

import dao.PoemDao;
import domain.Favorite;
import domain.Poem;

public class PoemDaoImplTest {

	private final static Log log = LogFactory.getLog(PoemDaoImplTest.class);

	private PoemDao poemDao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"/WebContent/WEB-INF/applicationContext.xml");
		poemDao = (PoemDao) ctx.getBean("poemDao");
	}

	@Test
	public void testFindById() {
		Poem poem = new Poem();
		poem.setPid(300);
		poem = poemDao.findById(poem);
		log.info("poem find by id title is : " + poem.getTitle());
<<<<<<< HEAD
		Assert.assertNotNull(poem);
		Assert.assertEquals("ï¿½ï¿½ï¿½Ò°ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ç¾°ï¿½ï¿½", poem.getTitle());
=======
		assertNotNull(poem);
		assertEquals("Óæ¼Ò°Á¡¤ÈûÏÂÇïÀ´·ç¾°Òì", poem.getTitle());
>>>>>>> changed junit test import library.

		poem.setPid(3000);
		log.info("find a non existing id : 3000");
		poem = poemDao.findById(poem);
		assertNull(poem);
	}

	@Test
	public void testSavePoem() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeletePoem() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryAll() {
		List<Poem> list = new ArrayList<Poem>();
		// we need to compare ids only, because objects have association
		// relationships. -_-!!!
		List<Integer> ids = new ArrayList<Integer>();
		list = poemDao.queryAll();
		for (Poem poem : list) {
			log.info("poem id in query all list: " + poem.getPid());
			ids.add(poem.getPid());
			log.info("poem title in all poems list: " + poem.getTitle());
		}
		assertNotNull(list);
		for (int i = 0; i < 6; i++) {
			assertTrue(ids.contains(300 + i));
		}
	}

	@Test
	public void testAddToFavorites() {
		Poem poem = new Poem();
		poem.setPid(300);
		poem = poemDao.findById(poem);
		log.info("poem add to favorites: " + poem.getPid());

		List<Favorite> oldfl = new ArrayList<Favorite>(poem.getFavoriteLists());
		assertNotNull(oldfl);
		for (Favorite favorite : oldfl) {
			log.info(poem.getTitle() + " already in list: " + favorite.getFid());
		}

		List<Favorite> newfl = new ArrayList<Favorite>();
		for (int i = 0; i < 3; i++) {
			Favorite f = new Favorite();
			f.setFid(300 + i);
			log.info("favorite id in newfl: " + f.getFid());
			newfl.add(f);
		}

		poemDao.addToFavorites(newfl, poem);
		poem = poemDao.findById(poem);
		newfl = new ArrayList<Favorite>(poem.getFavoriteLists());
		assertNotNull(newfl);

		List<Integer> ids = new ArrayList<Integer>();
		for (Favorite f : newfl) {
			log.info("favorite id in newfl: " + f.getFid());
			ids.add(f.getFid());
		}

		for (int i = 0; i < 3; i++) {
			assertTrue(ids.contains(300 + i));
		}

		poemDao.addToFavorites(oldfl, poem);
	}

	@Test
	public void testAddToNewPoems() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryByTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testQueryByContent() {
		fail("Not yet implemented");
	}

}
