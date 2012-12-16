package test.unit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.PoemDao;
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
		Assert.assertNotNull(poem);
		Assert.assertEquals("渔家傲·塞下秋来风景异", poem.getTitle());

		poem.setPid(3000);
		log.info("find a non existing id : 3000");
		poem = poemDao.findById(poem);
		Assert.assertNull(poem);
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
	public void testQueryAll() {
		List<Poem> list = new ArrayList<Poem>();
		// we need to compare ids only, because objects have association relationships. -_-!!!
		List<Integer> ids = new ArrayList<Integer>();
		list = poemDao.queryAll();
		for (Poem poem : list) {
			ids.add(poem.getPid());
		}
		Assert.assertNotNull(list);
		for (int i = 0; i < 6; i++) {
			Assert.assertTrue(ids.contains(300 + i));
		}
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddToFavorites() {
		fail("Not yet implemented");
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
