package test.unit;

import junit.framework.Assert;

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

	// TODO: create a seeddata.sql to populate the test data. All the test
	// should use and only use the date in the seeddata.sql file.

	@Before
	public void setUp() throws Exception {
		ApplicationContext ctx = new FileSystemXmlApplicationContext(
				"/WebContent/WEB-INF/applicationContext.xml");
		userCountDao = (UserCountDao) ctx.getBean("userCountDao");
	}

	@Test
	public void findById() {
		UserCount user = userCountDao.findById(200);
		log.info("user name find by dao : " + user.getName());
		Assert.assertNotNull(user);
		Assert.assertEquals("keke", user.getName());
	}

	@Test
	public void checkLogin() {
		UserCount user1 = new UserCount();
		user1.setName("keke");
		user1.setPassword("123456");
		UserCount user2 = userCountDao.checkLogin(user1);
		log.info("check login user name: " + user2.getName());
		log.info("check login user password: " + user2.getPassword());
		Assert.assertNotNull(user2);
		Assert.assertEquals(user1.getName(), user2.getName());
		Assert.assertEquals(user1.getPassword(), user2.getPassword());
	}

	@Test
	public void checkNonExistingUserLogin() {
		UserCount user1 = new UserCount();
		user1.setName("iamNotExist");
		user1.setPassword("123456");
		log.info("non existing user with name iamNotExisting, password 123456");
		UserCount user2 = userCountDao.checkLogin(user1);
		Assert.assertNull(user2);
	}

	@Test
	public void checkUserName() {
		UserCount user1 = new UserCount();
		user1.setName("keke");
		log.info("an existing user with name " + user1.getName());
		UserCount user2 = userCountDao.checkUserName(user1);
		Assert.assertNotNull(user2);
	}

	@Test
	public void checkNonExistingUserName() {
		UserCount user1 = new UserCount();
		user1.setName("iamNotExist");
		log.info("non existing user with name " + user1.getName());
		UserCount user2 = userCountDao.checkUserName(user1);
		Assert.assertNull(user2);
	}

	@Test
	public void checkUserEmail() {
		UserCount user1 = new UserCount();
		user1.setEmail("keke@keke.com");
		log.info("an existing user with email " + user1.getEmail());
		UserCount user2 = userCountDao.checkUserEmail(user1);
		Assert.assertNotNull(user2);
	}

	@Test
	public void checkNonExistingEmail() {
		UserCount user1 = new UserCount();
		user1.setEmail("iamNotExist@notexisting.com");
		log.info("non existing user with email " + user1.getEmail());
		UserCount user2 = userCountDao.checkUserEmail(user1);
		Assert.assertNull(user2);
	}

	@Test
	public void registAndDelete() {
		UserCount user = new UserCount();
		user.setName("anewname");
		user.setPassword("123456");
		log.info("test user register with name: " + user.getName()
				+ "and password: " + user.getPassword());
		boolean result = userCountDao.regist(user);
		Assert.assertEquals(result, true);

		log.info("registered user should be able to login");
		user = userCountDao.checkLogin(user);
		Assert.assertNotNull(user);

		log.info("we should delete test data after adding");
		userCountDao.delete(user);

		log.info("deleted user should not be able to login");
		user = userCountDao.checkLogin(user);
		Assert.assertNull(user);
	}

	@Test
	public void updateUserCount() {
		UserCount user = userCountDao.findById(200);
		Assert.assertEquals("keke", user.getName());
		log.info("before we update, user name is: " + user.getName());
		user.setName("kerie");
		userCountDao.updateUserCount(user);

		user = userCountDao.findById(200);
		log.info("after we update, user name is: " + user.getName());
		Assert.assertEquals("kerie", user.getName());

		log.info("we should set the name back after testing, or we will fail the test next time");
		user.setName("keke");
		userCountDao.updateUserCount(user);
		Assert.assertEquals("keke", user.getName());
	}

}
