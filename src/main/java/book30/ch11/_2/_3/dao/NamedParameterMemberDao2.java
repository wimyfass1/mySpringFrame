package book30.ch11._2._3.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import book30.ch11.domain.Member;
import book30.ch11.domain.MemberRowMapper;

public class NamedParameterMemberDao2 {
	@Autowired
	private MemberRowMapper memberRowMapper;
	
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	private SimpleJdbcInsert simpleJdbcInsert;
	
	@Autowired
	public void init(DataSource dataSource) {
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		
		this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
									.withTableName("MEMBERS")
									.usingColumns("NUMBER", "NAME", "POINT")
									.usingGeneratedKeyColumns("ID");
	}
	
	//addMember, List 11-5
	public void addMemberUsingJdbcInsert1(Member member) {
		this.simpleJdbcInsert.execute(new BeanPropertySqlParameterSource(member));
	}
	
	//addMember, List 11-6
	public int addMemberUsingJdbcInsert2(Member member) {
		return this.simpleJdbcInsert.executeAndReturnKey(new BeanPropertySqlParameterSource(member)).intValue();
	}
	
	public Member getMemberById(int id) {
		try {
			return this.namedParameterJdbcTemplate.queryForObject("SELECT * FROM MEMBERS WHERE ID = :id", 
														new MapSqlParameterSource("id", id), 
														this.memberRowMapper);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}