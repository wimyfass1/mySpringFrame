package book30.ch11.additional.service;

import org.springframework.beans.factory.annotation.Autowired;

import book30.ch11.additional.dao.MemberDao;
import book30.ch11.additional.dao.ContactDao;
import book30.ch11.domain.Member;

public class MemberServiceImpl implements MemberService{	
	@Autowired
	private MemberDao memberDao;

	@Autowired
	private ContactDao contactDao;
	
	//deleteAll	
	public void deleteAll() {
		this.memberDao.deleteAll();
	}
	
	//addMember
	public void addMember(Member member) {
		int memberId = this.memberDao.addMember(member);
		member.setId(memberId);
		contactDao.addContact(member.getContact());
	}
}