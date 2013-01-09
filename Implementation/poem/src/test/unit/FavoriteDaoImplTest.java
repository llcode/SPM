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

import dao.FavoriteDao;
import domain.Favorite;
import domain.Poem;
import domain.UserCount;

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
	public void testFindById() {
		Favorite favorite = new Favorite();
		favorite.setFid(300);
		favorite = favoriteDao.findById(favorite);
		assertNotNull(favorite);
		log.info("favorite find by id 300: " + favorite.getName());
		assertTrue(favorite.getName().equalsIgnoreCase("所有欧阳修的词"));
	}

	@Test
	public void testQueryAll() {
		List<Favorite> flist = new ArrayList<Favorite>();
		List<Integer> ids = new ArrayList<Integer>();
		UserCount user = new UserCount();
		user.setUserid(300);
		flist = favoriteDao.queryAll(user);
		assertNotNull(flist);

		for (Favorite favorite : flist) {
			log.info("favorite of user 300 : " + favorite.getName());
			ids.add(favorite.getFid());
		}
		assertTrue(ids.contains(300));
		assertTrue(ids.contains(301));
		assertTrue(ids.contains(302));
		assertTrue(ids.contains(303));
	}

	@Test
	public void testUpdate() {
		Favorite favorite = new Favorite();
		favorite.setFid(300);
		favorite = favoriteDao.findById(favorite);

		assertNotNull(favorite);
		log.info("old favorite name is : " + favorite.getName());
		assertTrue(favorite.getName().equalsIgnoreCase("所有欧阳修的词"));

		favorite.setName("my poems");
		favoriteDao.update(favorite);
		favorite = favoriteDao.findById(favorite);
		assertNotNull(favorite);
		log.info("new favorite name is : " + favorite.getName());
		assertTrue(favorite.getName().equalsIgnoreCase("my poems"));

		favorite.setName("所有欧阳修的词");
		favoriteDao.update(favorite);
	}

	@Test
	public void testSaveAndDelete() {
		UserCount user = new UserCount();
		user.setUserid(300);
		Favorite favorite = new Favorite();
		favorite.setOwner(user);
		favorite.setName("a very special favorite");
		log.info("the favorite saved is : " + favorite.getName());

		List<Favorite> oldfl = favoriteDao.queryAll(user);
		log.info("the size of old favorite list: " + oldfl.size());
		favoriteDao.save(favorite);
		List<Favorite> newfl = favoriteDao.queryAll(user);
		log.info("the size of new favorite list: " + newfl.size());
		assertEquals(1, newfl.size() - oldfl.size());

		log.info("delete the favorite");
		favoriteDao.delete(favorite);
		newfl = favoriteDao.queryAll(user);
		assertEquals(oldfl.size(), newfl.size());
	}

	@Test
	public void testAddAndRemovePoem() {
		Poem poem = new Poem();
		poem.setPid(305);
		Favorite favorite = new Favorite();
		favorite.setFid(300);
		favorite = favoriteDao.findById(favorite);
		Set<Poem> oldpl = favorite.getPoemLists();
		log.info("poem numbers in old poem list: " + oldpl.size());

		favoriteDao.addPoem(favorite, poem);
		favorite = favoriteDao.findById(favorite);
		Set<Poem> newpl = favorite.getPoemLists();
		log.info("poem numbers in new poem list: " + newpl.size());

		assertEquals(1, newpl.size() - oldpl.size());

		log.info("remove poem from favorie");
		favoriteDao.removePoem(favorite, poem);
		favorite = favoriteDao.findById(favorite);
		newpl = favorite.getPoemLists();
		log.info("poem numbers after delete: " + newpl.size());
		assertEquals(oldpl.size(), newpl.size());
	}

}