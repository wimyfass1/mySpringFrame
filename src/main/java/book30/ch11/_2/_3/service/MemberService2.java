package book30.ch11._2._3.service;

import org.springframework.beans.factory.annotation.Autowired;

import book30.ch11._2._3.dao.NamedParameterMemberDaoImpl2;
import book30.ch11.domain.Member;

public class MemberService2 {
	@Autowired
	private NamedParameterMemberDaoImpl2 namedParameterMemberDao2;
	
	//addMemebr, List 11-5
	public void addMemberUsingJdbcInsert1(Member member) {
		this.namedParameterMemberDao2.addMemberUsingJdbcInsert1(member);
	}
	
	//addMemebr, List 11-6
	public int addMemberUsingJdbcInsert2(Member member) {
		return this.namedParameterMemberDao2.addMemberUsingJdbcInsert2(member);
	}
	
	public Member getMemberById(int id) {
		return this.namedParameterMemberDao2.getMemberById(id);
	}
}
