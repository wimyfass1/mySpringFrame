package book30.ch11._2._5.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import book30.ch11.domain.Member;
import book30.ch11.domain.MemberRowMapper;

public class NamedParameterMemberDao3 extends NamedParameterJdbcDaoSupport {
	@Autowired
	private MemberRowMapper memberRowMapper;
	
	private SimpleJdbcInsert simpleJdbcInsert;
	
	public void init() {	//<- Note!
		this.simpleJdbcInsert = new SimpleJdbcInsert(getDataSource()) //<- Note!
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
			return this.getNamedParameterJdbcTemplate().queryForObject("SELECT * FROM MEMBERS WHERE ID = :id",  //<- Note!
														new MapSqlParameterSource("id", id), 
														this.memberRowMapper);
		} catch(EmptyResultDataAccessException e) {
			return null;
		}
	}
}