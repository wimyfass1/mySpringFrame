package book30.ch02.practice.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Before;
import org.junit.runner.RunWith;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import book30.ch02.practice.dao.UserDao;
import book30.ch02.practice.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="../test-applicationContext.xml")
public class UserDaoTest {
	@Autowired
	private UserDao dao;
	
	@Autowired
	private ApplicationContext context;
	
	private User user1;
	private User user2;
	private User user3;
	
	static UserDao testUserDao;
	
	@Before
	public void setUp() {
		testUserDao = this.dao;

		this.user1 = new User("gyumee", "박성철", "springno1");
		this.user2 = new User("leegw700", "이길원", "springno2");
		this.user3 = new User("bumjin", "박범진", "springno3");
	}

	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException {
		assertThat(testUserDao, is(this.dao));
		assertTrue(UserDaoFailTest.testUserDao == null || UserDaoFailTest.testUserDao == UserDaoTest.testUserDao);
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		dao.add(user2);
		assertThat(dao.getCount(), is(2));
		
		User userget1 = dao.get(user1.getId());
		assertThat(userget1.getName(), is(user1.getName()));
		assertThat(userget1.getPassword(), is(user1.getPassword()));
		
		User userget2 = dao.get(user2.getId());
		assertThat(userget2.getName(), is(user2.getName()));
		assertThat(userget2.getPassword(), is(user2.getPassword()));
	}
	
	@Test
	public void count() throws SQLException, ClassNotFoundException {
		assertThat(testUserDao, is(this.dao));
		assertTrue(UserDaoFailTest.testUserDao == null || UserDaoFailTest.testUserDao == UserDaoTest.testUserDao);
		
		dao.deleteAll();
		assertThat(dao.getCount(), is(0));
		
		dao.add(user1);
		assertThat(dao.getCount(), is(1));
		
		dao.add(user2);
		assertThat(dao.getCount(), is(2));
		
		dao.add(user3);
		assertThat(dao.getCount(), is(3));
	}
	
	@Test
	public void compareBean() {
		assertThat(testUserDao, is(this.dao));
		assertTrue(UserDaoFailTest.testUserDao == null || UserDaoFailTest.testUserDao == UserDaoTest.testUserDao);
		
		UserDao dao2 = context.getBean("userDao", UserDao.class);
		assertThat(dao2, is(this.dao));		
	}
}
