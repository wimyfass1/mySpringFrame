package book30.ch11._2._2.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import book30.ch11._2.domain.Member;

public class NamedParameterMemberDao {
	@Autowired
	private MemberRowMapper memberRowMapper;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}
	
	//addMember
	public void addMember2(String number, String name, int point) {
		this.namedParameterJdbcTemplate.update("INSERT INTO MEMBERS(NUMBER, NAME, POINT) VALUES(:number, :name, :point)", 
												new MapSqlParameterSource().addValue("number", number)
																		   .addValue("name", name)
																		   .addValue("point", point));
	}
	
	public void addMember3(Map<String, Object> memberMap) {
		this.namedParameterJdbcTemplate.update("INSERT INTO MEMBERS(NUMBER, NAME, POINT) VALUES(:number, :name, :point)", memberMap);
	}
	
	public void addMember4(Member member) {
		this.namedParameterJdbcTemplate.update("INSERT INTO MEMBERS(NUMBER, NAME, POINT) VALUES(:number, :name, :point)", 
												new BeanPropertySqlParameterSource(member));
	}
	
	//numMembersOverPoint
	public int numMembersOverPoint2(int point) {
		return this.namedParameterJdbcTemplate.queryForObject("SELECT count(*) FROM MEMBERS WHERE POINT > :point", 
																new MapSqlParameterSource("point", point), Integer.class);
	}
	
	//getMemberName, List 11-4
	public String getMemberName2(String number) {
		try {
			return this.namedParameterJdbcTemplate.queryForObject("SELECT NAME FROM MEMBERS WHERE NUMBER = :number", 
														new MapSqlParameterSource("number", number), String.class);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}

	//getMember
	public Member getMember3(String number) {
		try {
			return this.namedParameterJdbcTemplate.queryForObject("SELECT * FROM MEMBERS WHERE NUMBER = :number", 
														new MapSqlParameterSource("number", number), 
														new BeanPropertyRowMapper<Member>(Member.class));
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public Member getMember4(String number) {
		try {
			return this.namedParameterJdbcTemplate.queryForObject("SELECT * FROM MEMBERS WHERE NUMBER = :number", 
														new MapSqlParameterSource("number", number), 
														this.memberRowMapper);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//getMemberMap (note: get a single member)
	public Map<String, Object> getMemberMap2(String number) {
		try {
			return this.namedParameterJdbcTemplate.queryForMap("SELECT * FROM MEMBERS WHERE NUMBER = :number", 
																new MapSqlParameterSource("number", number));
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//getMemberList
	public List<Member> getMemberList3(int point) {
		return this.namedParameterJdbcTemplate.query("SELECT * FROM MEMBERS WHERE POINT > :point", 
														new MapSqlParameterSource("point", point), 
														new BeanPropertyRowMapper<Member>(Member.class));
	}
	
	public List<Member> getMemberList4(int point) {
		return this.namedParameterJdbcTemplate.query("SELECT * FROM MEMBERS WHERE POINT > :point", 
														new MapSqlParameterSource("point", point), 
														this.memberRowMapper);
	}
	
	//getMemberMapList
	public List<Map<String, Object>> getMemberMapList2(int point) {
		return this.namedParameterJdbcTemplate.queryForList("SELECT * FROM MEMBERS WHERE POINT > :point", 
														new MapSqlParameterSource("point", point));
	}
}