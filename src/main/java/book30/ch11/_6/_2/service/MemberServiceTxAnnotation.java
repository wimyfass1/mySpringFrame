package book30.ch11._6._2.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import book30.ch11.domain.Member;

//List 11-50
@Transactional
public interface MemberServiceTxAnnotation {
	//deleteAll	
	public void deleteAll();
	
	//addMember
	public void addMember(Member member);
	
	//numMembers
	@Transactional(readOnly=true)
	public int numMembers();
	
	//numMembersOverPoint
	@Transactional(readOnly=true)
	public int numMembersOverPoint(int point);
	
	//getMember
	@Transactional(readOnly=true)	
	public Member getMember(String number);

	//getMember
	@Transactional(readOnly=true)	
	public Member getMemberById(int id);
		
	//getMemberName
	@Transactional(readOnly=true)	
	public String getMemberName(String number);
		
	//getMemberList	
	@Transactional(readOnly=true)	
	public List<Member> getMemberList(int point);
	
	//addMemberList
	public int[] addMemberList(List<Member> memberList);
	
	//addEachMemberListWithTransaction
	public void addEachMemberListWithTransaction(final List<Member> memberList);
}
