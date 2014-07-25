package book30.ch11._2._5.service;

import org.springframework.beans.factory.annotation.Autowired;

import book30.ch11._2._5.dao.NamedParameterMemberDao3;
import book30.ch11.domain.Member;

public class MemberService3 {
	@Autowired
	private NamedParameterMemberDao3 namedParameterMemberDao3;
	
	//addMemebr, List 11-5
	public void addMemberUsingJdbcInsert1(Member member) {
		this.namedParameterMemberDao3.addMemberUsingJdbcInsert1(member);
	}
	
	//addMemebr, List 11-6
	public int addMemberUsingJdbcInsert2(Member member) {
		return this.namedParameterMemberDao3.addMemberUsingJdbcInsert2(member);
	}
	
	public Member getMemberById(int id) {
		return this.namedParameterMemberDao3.getMemberById(id);
	}
}
