package book30.ch02._2._2.dao;

import java.sql.SQLException;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.junit.runner.JUnitCore;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import book30.ch02._2._2.domain.User;


public class UserDaoTest {

	@Test
	public void addAndGet() throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		//class
		//ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		//xml
		ApplicationContext context = new GenericXmlApplicationContext("book30/ch02/_2/_2/applicationContext.xml");
		
		UserDao dao = context.getBean("userDao", UserDao.class);

		User user = new User();
		user.setId("gyumee");
		user.setName("박성철");
		user.setPassword("springno1");
		
		dao.add(user);
		
		User user2 = dao.get(user.getId());
		
		assertThat(user2.getName(), is(user.getName()));
		assertThat(user2.getPassword(), is(user.getPassword()));
				
	}
	
	public static void main(String[] args) {
		JUnitCore.main("book30.ch02._2._2.dao.UserDaoTest");
	}

}
