package test.unit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.PoemDao;
import domain.Favorite;
import domain.MyNewPoem;
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
		assertNotNull(poem);
		assertEquals("渔家傲·塞下秋来风景异", poem.getTitle());

		poem.setPid(3000);
		log.info("find a non existing poem by id : 3000");
		poem = poemDao.findById(poem);
		assertNull(poem);
	}

	@Test
	public void testSaveAndDeletePoem() {
		Poem poem = new Poem();
		poem.setTitle("a very special title");
		poemDao.savePoem(poem);
		log.info("save a very special poem with title : " + poem.getTitle());

		Poem newPoem = poemDao.queryByTitle("a very special title").get(0);
		assertNotNull(newPoem);
		assertEquals(newPoem.getTitle(), "a very special title");

		poemDao.deletePoem(newPoem);
	}

	@Test
	public void testUpdate() {
		Poem poem = new Poem();
		poem.setPid(300);
		poem = poemDao.findById(poem);
		log.info("get poem with title : " + poem.getTitle());
		assertNotNull(poem);
		assertEquals(poem.getTitle(), "渔家傲·塞下秋来风景异");

		log.info("chage title to \"a special title\"");
		poem.setTitle("a special title");
		poemDao.update(poem);
		poem = poemDao.findById(poem);
		assertNotNull(poem);
		assertTrue(poem.getTitle().equalsIgnoreCase("a special title"));

		poem.setTitle("渔家傲·塞下秋来风景异");
		poemDao.update(poem);
		log.info("change title back to 渔家傲·塞下秋来风景异");
		poem = poemDao.findById(poem);
		assertNotNull(poem);
		assertEquals(poem.getTitle(), "渔家傲·塞下秋来风景异");
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
	public void testAddToAndRemoveFromNewPoems() {
		Poem poem = new Poem();
		poem.setPid(300);
		poem = poemDao.findById(poem);
		log.info("poem added to new poem list is : " + poem.getTitle());

		Set<MyNewPoem> oldnpl = poem.getNewLists();
		log.info("old poem list size is : " + oldnpl.size());
		assertNotNull(oldnpl);
		for (MyNewPoem myNewPoem : oldnpl) {
			log.info("poem already in new poem list: " + myNewPoem.getNewpid());
		}

		MyNewPoem myNewPoem = new MyNewPoem();
		myNewPoem.setPoem(poem);
		poemDao.addToNewPoems(myNewPoem);
		poem = poemDao.findById(poem);

		Set<MyNewPoem> newnpl = poem.getNewLists();
		assertNotNull(newnpl);
		log.info("new poem list size is : " + newnpl.size());
		for (MyNewPoem myNewPoem2 : newnpl) {
			log.info("now poem is in new poem list: " + myNewPoem2.getNewpid());
		}

		log.info("the total new poem list size should increased by 1");
		assertEquals(1, newnpl.size() - oldnpl.size());

		log.info("set new poem list back");
		poemDao.removeFromNewPoems(myNewPoem);
		
		poem = poemDao.findById(poem);
		Set<MyNewPoem> newnpl2 = poem.getNewLists();
		log.info("the size after update : " + newnpl2.size());
		assertEquals(oldnpl.size(), newnpl2.size());
	}

	@Test
	public void testQueryByTitle() {
		List<Poem> plist = poemDao.queryByTitle("浣溪沙");
		List<Integer> ids = new ArrayList<Integer>();
		for (Poem poem : plist) {
			ids.add(poem.getPid());
			log.info("poem in query by title 浣溪沙 : " + poem.getTitle());
		}
		assertNotNull(plist);
		assertTrue(ids.contains(302));
		assertTrue(ids.contains(303));
	}

	@Test
	public void testQueryByContent() {
		List<Poem> plist = poemDao.queryByContent("天");
		List<Integer> ids = new ArrayList<Integer>();
		for (Poem poem : plist) {
			ids.add(poem.getPid());
			log.info("poem in query by content 天 : " + poem.getTitle());
		}
		assertNotNull(plist);
		assertTrue(ids.contains(301));
		assertTrue(ids.contains(302));
	}

}
