package book30.ch11.txAttributes.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import book30.ch11.txAttributes.domain.Account;

public class AccountDaoImpl implements AccountDao {
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
		
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public void deleteAll() {
		this.namedParameterJdbcTemplate.update("DELETE FROM ACCOUNTS", (SqlParameterSource)null);
	}

	@Override
	public void insert(Account account){
		String insertSql ="INSERT INTO ACCOUNTS (NUMBER, BALANCE) VALUES(:balance, :number);";
		namedParameterJdbcTemplate.update(insertSql, new BeanPropertySqlParameterSource(account));
	}
	
	@Override
	public void update(Account account){
		String updateSql ="UPDATE ACCOUNTS SET BALANCE = :balance where NUMBER = :number";
		namedParameterJdbcTemplate.update(updateSql, new BeanPropertySqlParameterSource(account));	 
	}
		 
	@Override
	public Account select(String accountNumber) {
		String selectSql = "SELECT * FROM ACCOUNTS WHERE NUMBER = :number";
		Account account = namedParameterJdbcTemplate.queryForObject(selectSql, new MapSqlParameterSource("number", accountNumber), new AccountRowMapper());
		return account;
	}
		
	static private class AccountRowMapper implements RowMapper<Account>{
		@Override
		public Account mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
			Account account = new Account();
			account.setNumber(resultSet.getString("NUMBER"));
			account.setBalance(resultSet.getDouble("BALANCE"));
			return account;
		}		 
	}
}
