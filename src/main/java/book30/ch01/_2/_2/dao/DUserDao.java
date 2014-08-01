package book30.ch01._2._2.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class DUserDao extends UserDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// D 사 DB connection 생성코드
		return null;
	}
}