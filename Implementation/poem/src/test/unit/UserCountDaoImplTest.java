package test.unit;

import static org.junit.Assert.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import dao.UserCountDao;
import domain.UserCount;

public class UserCountDaoImplTest {

	private final static Log log = LogFactory
			.getLog(UserCountDaoImplTest.class);

	private UserCountDao userCountDao;

	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"/WebContent/WEB-INF/applicationContext.xml");
		userCountDao = (UserCountDao) ctx.getBean("userCountDao");
	}

	@Test
	public void testFindById() {
		UserCount user = userCountDao.findById(300);
		log.info("user name find by 300 : " + user.getName());
		assertNotNull(user);
		assertEquals("test", user.getName());

		log.info("find a non existing id : 3000");
		user = userCountDao.findById(3000);
		assertNull(user);
	}

	@Test
	public void testCheckLogin() {
		UserCount user1 = new UserCount();
		user1.setName("keke");
		user1.setPassword("123456");
		UserCount user2 = userCountDao.checkLogin(user1);
		log.info("check login user name: " + user2.getName());
		log.info("check login user password: " + user2.getPassword());
		assertNotNull(user2);
		assertEquals(user1.getName(), user2.getName());
		assertEquals(user1.getPassword(), user2.getPassword());
	}

	@Test
	public void testCheckNonExistingUserLogin() {
		UserCount user1 = new UserCount();
		user1.setName("iamNotExist");
		user1.setPassword("123456");
		log.info("non existing user login with name iamNotExisting, password 123456");
		UserCount user2 = userCountDao.checkLogin(user1);
		assertNull(user2);
	}

	@Test
	public void testCheckUserName() {
		UserCount user1 = new UserCount();
		user1.setName("keke");
		log.info("an existing user check with name " + user1.getName());
		UserCount user2 = userCountDao.checkUserName(user1);
		assertNotNull(user2);
	}

	@Test
	public void testCheckNonExistingUserName() {
		UserCount user1 = new UserCount();
		user1.setName("iamNotExist");
		log.info("non existing user check with name " + user1.getName());
		UserCount user2 = userCountDao.checkUserName(user1);
		assertNull(user2);
	}

	@Test
	public void testCheckUserEmail() {
		UserCount user1 = new UserCount();
		user1.setEmail("keke@poem.com");
		log.info("an existing user check with email " + user1.getEmail());
		UserCount user2 = userCountDao.checkUserEmail(user1);
		assertNotNull(user2);
	}

	@Test
	public void testCheckNonExistingEmail() {
		UserCount user1 = new UserCount();
		user1.setEmail("iamNotExist@notexisting.com");
		log.info("non existing user check with email " + user1.getEmail());
		UserCount user2 = userCountDao.checkUserEmail(user1);
		assertNull(user2);
	}

	@Test
	public void testRegistAndDelete() {
		UserCount user = new UserCount();
		user.setName("anewname");
		user.setPassword("123456");
		log.info("test user register with name: " + user.getName()
				+ "and password: " + user.getPassword());
		boolean result = userCountDao.regist(user);
		assertEquals(result, true);

		log.info("registered user should be able to login");
		user = userCountDao.checkLogin(user);
		assertNotNull(user);

		log.info("we should delete test data after adding");
		userCountDao.delete(user);

		log.info("deleted user should not be able to login");
		user = userCountDao.checkLogin(user);
		assertNull(user);
	}

	@Test
	public void testUpdateUserCount() {
		UserCount user = userCountDao.findById(300);
		assertEquals("test", user.getName());
		log.info("before we update, user name is: " + user.getName());
		user.setName("kerie");
		userCountDao.updateUserCount(user);

		user = userCountDao.findById(300);
		log.info("after we update, user name is: " + user.getName());
		assertEquals("kerie", user.getName());

		log.info("we should set the name back after testing, or we will fail the test next time");
		user.setName("test");
		userCountDao.updateUserCount(user);
		assertEquals("test", user.getName());
	}

}
