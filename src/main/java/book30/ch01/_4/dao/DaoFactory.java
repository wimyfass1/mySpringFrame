package book30.ch01._4.dao;

public class DaoFactory {
	public UserDao userDao() {
		ConnectionMaker connectionMaker = new DConnectionMaker();
		UserDao userDao = new UserDao(connectionMaker);
		
		return userDao;
	}
	
	/*List 1-16
	public UserDao userDao() {
		return new UserDao(new DConnectionMaker());
	}
	
	public AccountDao accountDao() {
		return new AccountDao(new DConnectionMaker());
	}
	
	public MessageDao messageDao() {
		return new MessageDao(new DConnectionMaker());
	}
	*/
	
	/*List 1-17
	public UserDao userDao() {
		return new UserDao(connectionMaker());
	}
	
	public AccountDao accountDao() {
		return new AccountDao(connectionMaker());
	}
	
	public MessageDao messageDao() {
		return new MessageDao(connectionMaker());
	}
	
	public ConnectionMaker connectionMaker() {
		return new DConnectionMaker();
	}
	*/
}
