package book30.ch11._6._2.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import book30.ch11.domain.Member;
import book30.ch11.domain.MemberRowMapper;

public class MemberDao {
	@Autowired
	private MemberRowMapper memberRowMapper;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	//deleteAll
	public void deleteAll() {
		this.namedParameterJdbcTemplate.update("DELETE FROM MEMBERS", (SqlParameterSource)null);
	}
	
	//addMember
	public void addMember(Member member) {
		this.namedParameterJdbcTemplate.update("INSERT INTO MEMBERS(NUMBER, NAME, POINT) VALUES(:number, :name, :point)", 
													new BeanPropertySqlParameterSource(member));
	}
	
	//numMembers
	public int numMembers() {
		return this.namedParameterJdbcTemplate.queryForObject("SELECT count(*) FROM MEMBERS", (SqlParameterSource)null, Integer.class);
	}
	
	//numMembersOverPoint
	public int numMembersOverPoint(int point) {
		return this.namedParameterJdbcTemplate.queryForObject("SELECT count(*) FROM MEMBERS WHERE POINT > :point", 
																new MapSqlParameterSource("point", point), Integer.class);
	}
	
	//getMember	
	public Member getMember(String number) {
		try {
			return this.namedParameterJdbcTemplate.queryForObject("SELECT * FROM MEMBERS WHERE NUMBER = :number", 
														new MapSqlParameterSource("number", number), 
														this.memberRowMapper);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public Member getMemberById(int id) {
		try {
			return this.namedParameterJdbcTemplate.queryForObject("SELECT * FROM MEMBERS WHERE NUMBER = :id", 
														new MapSqlParameterSource("id", id), 
														this.memberRowMapper);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//getMemberName
	public String getMemberName(String number) {
		try {
			return this.namedParameterJdbcTemplate.queryForObject("SELECT NAME FROM MEMBERS WHERE NUMBER = :number", 
														new MapSqlParameterSource("number", number), String.class);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
		
	//getMemberList
	public List<Member> getMemberList(int point) {
		return this.namedParameterJdbcTemplate.query("SELECT * FROM MEMBERS WHERE POINT > :point", 
														new MapSqlParameterSource("point", point), 
														this.memberRowMapper);
	}
		
	//addMemberList
	public int[] addMemberList(final List<Member> memberList) {
		SqlParameterSource[] sqlParameterSource = new SqlParameterSource[memberList.size()];
		int i = 0;
		for (Member member: memberList) {
			sqlParameterSource[i] = new BeanPropertySqlParameterSource(member);
			i++;
		}
		
		int[] updateCount = this.namedParameterJdbcTemplate.batchUpdate("INSERT INTO MEMBERS(NUMBER, NAME, POINT) VALUES(:number, :name, :point)", sqlParameterSource);
		return updateCount;
	}
}