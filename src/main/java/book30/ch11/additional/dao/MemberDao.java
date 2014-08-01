package book30.ch11.additional.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import book30.ch11.domain.Member;
import book30.ch11.domain.MemberRowMapper;

public class MemberDao {
	@Autowired
	private MemberRowMapper memberRowMapper;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	private SimpleJdbcInsert simpleJdbcInsert;
	
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
									.withTableName("MEMBERS")
									.usingColumns("NUMBER", "NAME", "POINT")
									.usingGeneratedKeyColumns("ID");
	}
	
	//deleteAll
	public void deleteAll() {
		this.namedParameterJdbcTemplate.update("DELETE FROM MEMBERS", (SqlParameterSource)null);
	}
	
	//addMember
	public int addMember(Member member) {
		return this.simpleJdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(member)).intValue();
	}
}