package book30.ch11._2._2.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import book30.ch11._2.domain.Member;

public class MemberDao {
	@Autowired
	private MemberRowMapper memberRowMapper;
	
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	//deleteAll		
	public void deleteAll() {
		this.jdbcTemplate.update("DELETE FROM MEMBERS");
	}
	
	//addMember
	public void addMember1(String number, String name, int point) {
		this.jdbcTemplate.update("INSERT INTO MEMBERS(NUMBER, NAME, POINT) VALUES(?, ?, ?)", number, name, point);
	}

	//numMembers
	public int numMembers() {
		return this.jdbcTemplate.queryForObject("SELECT count(*) FROM MEMBERS", Integer.class);
	}

	//numMembersOverPoint
	public int numMembersOverPoint1(int point) {
		return this.jdbcTemplate.queryForObject("SELECT count(*) FROM MEMBERS WHERE POINT > ?", Integer.class, point);
	}
	
	//getMemberName, List 11-4
	public String getMemberName1(String number) {
		try {
			return this.jdbcTemplate.queryForObject("SELECT NAME FROM MEMBERS WHERE NUMBER = ?", String.class, number);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//getMember
	public Member getMember1(String number) {
		try {
			return this.jdbcTemplate.queryForObject("SELECT * FROM MEMBERS WHERE NUMBER = ?", 
													new BeanPropertyRowMapper<Member>(Member.class), number);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	public Member getMember2(String number) {
		try {
			return this.jdbcTemplate.queryForObject("SELECT * FROM MEMBERS WHERE NUMBER = ?", this.memberRowMapper, number);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//getMemberMap (note: get a single member)
	public Map<String, Object> getMemberMap1(String number) {
		try {
			return this.jdbcTemplate.queryForMap("SELECT * FROM MEMBERS WHERE NUMBER = ?", number);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
	
	//getMemberList
	public List<Member> getMemberList1(int point) {
		return this.jdbcTemplate.query("SELECT * FROM MEMBERS WHERE POINT > ?", 
											new BeanPropertyRowMapper<Member>(Member.class), point);
	}
	
	public List<Member> getMemberList2(int point) {
		return this.jdbcTemplate.query("SELECT * FROM MEMBERS WHERE POINT > ?", this.memberRowMapper, point);
	}
	
	//getMemberMapList
	public List<Map<String, Object>> getMemberMapList1(int point) {
		return this.jdbcTemplate.queryForList("SELECT * FROM MEMBERS WHERE POINT > ?", point);
	}
	
	/*
	public int[] addMembers1(Map<String, Object>[] memberMaps) {
		this.jdbcTemplate.batchUpdate(sql, batchArgs, argTypes)
	}
	*/
}