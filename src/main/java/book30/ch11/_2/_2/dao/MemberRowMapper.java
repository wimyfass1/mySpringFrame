package book30.ch11._2._2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import book30.ch11._2.domain.Member;

public class MemberRowMapper implements RowMapper<Member> {
	@Override
	public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
		Member member = new Member();
		member.setId(rs.getInt("ID"));
		member.setNumber(rs.getString("NUMBER"));
		member.setName(rs.getString("NAME"));
		member.setPoint(rs.getInt("POINT"));
		return member;
	}
}
