package book30.ch02._2._1.dao;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import book30.ch02._2._1.domain.User;


public class UserDaoTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//class  
		ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
		//xml
		//ApplicationContext context = new GenericXmlApplicationContext("book30/ch02/_2/_1/applicationContext.xml");
		UserDao dao = context.getBean("userDao", UserDao.class);

		User user = new User();
		user.setId("whiteship");
		user.setName("백기선");
		user.setPassword("married");
		
		dao.add(user);
		
		System.out.println(user.getId() + "등록 성공");
		
		User user2 = dao.get(user.getId());
		
		if(!user.getName().equals(user2.getName())){
			System.out.println("테스트 실패 (name)");
		}
		else if (!user.getPassword().equals(user2.getPassword())) {
			System.out.println("테스트 실패 (password)");
		}
		else {
			System.out.println("조회 테스트 성공");
		}
		
		/*
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		System.out.println(user2.getId() + "조회 성공");
		*/
		
		
	}

}
