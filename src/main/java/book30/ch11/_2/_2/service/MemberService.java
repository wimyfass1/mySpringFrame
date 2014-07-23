package book30.ch11._2._2.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import book30.ch11._2._2.dao.MemberDao;
import book30.ch11._2._2.dao.NamedParameterMemberDao;
import book30.ch11._2.domain.Member;

public class MemberService {
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private NamedParameterMemberDao namedParameterMemberDao;
	
	//deleteAll	
	public void deleteAll() {
		this.memberDao.deleteAll();
	}
	
	//addMember
	public void addMember1(String number, String name, int point) {
		this.memberDao.addMember1(number, name, point);
	}
	
	public void addMember2(String number, String name, int point) {
		this.namedParameterMemberDao.addMember2(number, name, point);
	}
	
	public void addMember3(Map<String, Object> memberMap) {
		this.namedParameterMemberDao.addMember3(memberMap);
	}
	
	public void addMember4(Member member) {
		this.namedParameterMemberDao.addMember4(member);
	}
	
	//numMembers
	public int numMembers() {
		return this.memberDao.numMembers();
	}
	
	//numMembersOverPoint
	public int numMembersOverPoint1(int point) {
		return this.memberDao.numMembersOverPoint1(point);
	}
	
	public int numMembersOverPoint2(int point) {
		return this.namedParameterMemberDao.numMembersOverPoint2(point);
	}
	
	//getMemberName, List 11-4
	public String getMemberName1(String number) {
		return this.memberDao.getMemberName1(number);
	}
	
	public String getMemberName2(String number) {
		return this.namedParameterMemberDao.getMemberName2(number);
	}
	
	//getMember
	public Member getMember1(String number) {
		return this.memberDao.getMember1(number);
	}
	
	public Member getMember2(String number) {
		return this.memberDao.getMember2(number);
	}
	
	public Member getMember3(String number) {
		return this.namedParameterMemberDao.getMember3(number);
	}
	
	public Member getMember4(String number) {
		return this.namedParameterMemberDao.getMember4(number);
	}
	
	//getMemberMap
	public Map<String, Object> getMemberMap1(String number) {
		return this.memberDao.getMemberMap1(number);
	}
	
	public Map<String, Object> getMemberMap2(String number) {
		return this.namedParameterMemberDao.getMemberMap2(number);
	}
	
	//getMemberList
	public List<Member> getMemberList1(int point) {
		return this.memberDao.getMemberList1(point);
	}
	
	public List<Member> getMemberList2(int point) {
		return this.memberDao.getMemberList2(point);
	}
	
	public List<Member> getMemberList3(int point) {
		return this.namedParameterMemberDao.getMemberList3(point);
	}
	
	public List<Member> getMemberList4(int point) {
		return this.namedParameterMemberDao.getMemberList4(point);
	}
	
	//getMemberMapList
	public List<Map<String, Object>> getMemberMapList1(int point) {
		return this.memberDao.getMemberMapList1(point);
	}

	public List<Map<String, Object>> getMemberMapList2(int point) {
		return this.namedParameterMemberDao.getMemberMapList2(point);
	}
}