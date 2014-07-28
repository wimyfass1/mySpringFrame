package book30.ch11.isolation.service;

import org.springframework.beans.factory.annotation.Autowired;

import book30.ch11.additional.dao.MemberDao;
import book30.ch11.additional.dao.ContactDao;
import book30.ch11.domain.Member;

public class MemberServiceImpl implements MemberService{	
	@Autowired
	private MemberDao memberDao;
	
	//deleteAll	
	public void deleteAll() {
		this.memberDao.deleteAll();
	}
	
	//addMember
	public void addMember(Member member) {
		int memberId = this.memberDao.addMember(member);
	}
}