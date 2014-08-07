package book30.ch01._2._3.dao;

import java.sql.Connection;
import java.sql.SQLException;

public class NUserDao extends UserDao {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		// N 사 DB connection 생성코드
		return null;
	}
}