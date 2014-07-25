package book30.ch11._6._2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import book30.ch11._6._2.dao.NamedParameterMemberDao4;
import book30.ch11.domain.Member;

public class MemberService4 {	
	@Autowired
	private NamedParameterMemberDao4 namedParameterMemberDao;
	
	//deleteAll	
	public void deleteAll() {
		this.namedParameterMemberDao.deleteAll();
	}
	
	//addMember
	public void addMember(Member member) {
		this.namedParameterMemberDao.addMember(member);
	}
	
	//numMembers
	public int numMembers() {
		return this.namedParameterMemberDao.numMembers();
	}
	
	//numMembersOverPoint	
	public int numMembersOverPoint(int point) {
		return this.namedParameterMemberDao.numMembersOverPoint(point);
	}
	
	//getMember
	public Member getMember(String number) {
		return this.namedParameterMemberDao.getMember(number);
	}

	//getMember
	public Member getMemberById(int id) {
		return this.namedParameterMemberDao.getMemberById(id);
	}
		
	//getMemberName
	public String getMemberName(String number) {
		return this.namedParameterMemberDao.getMemberName(number);
	}
		
	//getMemberList	
	public List<Member> getMemberList(int point) {
		return this.namedParameterMemberDao.getMemberList(point);
	}
	
	//addMemberList
	public int[] addMemberList(List<Member> memberList) {
		return this.namedParameterMemberDao.addMemberList(memberList);
	}
	
	//addEachMemberList, 11-6-2
	public void addEachMemberList(List<Member> memberList) {
		for (Member member: memberList) {
			this.namedParameterMemberDao.addMember(member);
		}
	}
}