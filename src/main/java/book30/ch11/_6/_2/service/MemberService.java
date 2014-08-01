package book30.ch11._6._2.service;

import java.util.List;

import book30.ch11.domain.Member;

//List 11-50
public interface MemberService {
	//deleteAll	
	public void deleteAll();
	
	//addMember
	public void addMember(Member member);
	
	//numMembers
	public int numMembers();
	
	//numMembersOverPoint	
	public int numMembersOverPoint(int point);
	
	//getMember
	public Member getMember(String number);

	//getMember
	public Member getMemberById(int id);
		
	//getMemberName
	public String getMemberName(String number);
		
	//getMemberList	
	public List<Member> getMemberList(int point);
	
	//addMemberList
	public int[] addMemberList(List<Member> memberList);
	
	//addEachMemberListWithoutTransaction
	public void addEachMemberListWithoutTransaction(List<Member> memberList);
	
	//addEachMemberListWithTransaction1, List 11-48, page 980
	public void addEachMemberListWithTransaction1(final List<Member> memberList);
	
	//addEachMemberListWithTransaction1, List 11-50
	public void addEachMemberListWithTransaction2(final List<Member> memberList);
}
