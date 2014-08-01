package book30.ch11.txAttributes.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public class DBUtil {
	@Autowired
	private DataSource dataSource;
	 
	public void initialize(){
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();
			statement.executeUpdate("DROP TABLE IF EXISTS ACCOUNTS");
			statement.executeUpdate("CREATE TABLE ACCOUNTS (NUMBER VARCHAR(50), BALANCE DECIMAL(10,2))");
			statement.close();
			connection.close();
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
}