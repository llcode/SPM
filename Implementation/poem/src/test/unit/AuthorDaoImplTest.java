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

import dao.AuthorDao;
import domain.Author;

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
		Author author = authorDao.findByName("范仲淹");
		assertNotNull(author);
		assertTrue(author.getName().equals("范仲淹"));
		log.info("author find by name 范仲淹: " + author.getName());

		log.info("finding a non existing author");
		author = authorDao.findByName("a strange name");
		assertNull(author);
	}

	@Test
	public void testQueryAll() {
		List<Author> authors = authorDao.queryAll();
		List<Integer> ids = new ArrayList<Integer>();
		assertNotNull(authors);
		for (Author author : authors) {
			ids.add(author.getAid());
			log.info("author in all authors : " + author.getName());
		}
		assertTrue(ids.contains(300));
		assertTrue(ids.contains(301));
		assertTrue(ids.contains(302));
	}

	@Test
	public void testFindByAid() {
		Author author = new Author();
		author.setAid(300);
		author = authorDao.findByAid(author);
		assertNotNull(author);
		log.info("author find by aid : " + author.getName());
	}

	@Test
	public void testUpdateAuthor() {
		Author author = new Author();
		author.setAid(300);
		author = authorDao.findByAid(author);
		log.info("author name before update is : " + author.getName());
		assertTrue(author.getName().equalsIgnoreCase("范仲淹"));

		author.setName("me");
		authorDao.updateAuthor(author);
		author = authorDao.findByAid(author);
		log.info("author name after update is : " + author.getName());
		assertTrue(author.getName().equalsIgnoreCase("me"));

		author.setName("范仲淹");
		authorDao.updateAuthor(author);
	}

	@Test
	public void testInsertAndDeleteAuthor() {
		Author author = new Author();
		author.setName("anonexistingname");
		authorDao.insertAuthor(author);
		author = authorDao.findByName("anonexistingname");
		assertNotNull(author);
		log.info("the name of inserted author : " + author.getName());

		log.info("delete the inserted author");
		authorDao.delete(author);
		author = authorDao.findByName("anonexistingname");
		assertNull(author);
	}

	@Test
	public void testQueryByName() {
		List<Author> alist = authorDao.queryByName("欧");
		List<Integer> ids = new ArrayList<Integer>();
		for (Author author : alist) {
			log.info("all authors find by name 欧 : " + author.getName());
			ids.add(author.getAid());
		}
		assertTrue(ids.contains(302));
	}

}