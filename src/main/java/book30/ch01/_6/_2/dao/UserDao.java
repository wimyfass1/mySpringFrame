package book30.ch01._6._2.dao;



/* List 1-22

public class UserDao {
	private static UserDao INSTANCE;
	
	private ConnectionMaker connectionMaker;
	
	private UserDao(ConnectionMaker connectionMaker) {
		this.connectionMaker = connectionMaker;
	}

	public static synchronized UserDao getInstance() {
		if ( INSTANCE == null)
			INSTANCE = new UserDao(???);
		return INSTANCE;
	}
}


 */