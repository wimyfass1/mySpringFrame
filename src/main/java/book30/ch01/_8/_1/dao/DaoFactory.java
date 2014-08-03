package book30.ch01._8._1.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import book30.ch01._8._1.dao.ConnectionMaker;
import book30.ch01._8._1.dao.DConnectionMaker;

@Configuration
public class DaoFactory {
	@Bean
	public UserDao userDao() {
		UserDao userDao = new UserDao();
		userDao.setConnectionMaker(connectionMaker());
		return userDao;
	}
	
	@Bean
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
	
	
}
