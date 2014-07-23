package book30.ch11._2._3.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import book30.ch11._2._2.dao.NamedParameterMemberDao;
import book30.ch11._2.domain.Member;

public class NamedParameterMemberDao2 extends NamedParameterMemberDao {
	private SimpleJdbcInsert simpleJdbcInsert;
	
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
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
}