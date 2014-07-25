package book30.ch11._6._2.service;

import java.util.List;

import javax.transaction.Transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import book30.ch11._6._2.dao.NamedParameterMemberDao4;
import book30.ch11.domain.Member;

public class MemberService4 {	
	@Autowired
	private NamedParameterMemberDao4 namedParameterMemberDao;
	
	private TransactionTemplate transactionTemplate;
	
	@Autowired
	public void init(PlatformTransactionManager transactionManager) {
		this.transactionTemplate = new TransactionTemplate(transactionManager);
	}
	
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
	
	//addEachMemberList, 11-48, page 980
	public void addEachMemberListWithoutTransaction(List<Member> memberList) {
		for (Member member: memberList) {
			this.namedParameterMemberDao.addMember(member);
		}
	}
	
	public void addEachMemberListWithTransaction(final List<Member> memberList) {
		this.transactionTemplate.execute(new TransactionCallback<Object>() {
			public Object doInTransaction(TransactionStatus status) {
				System.out.println("isNewTransaction: " + status.isNewTransaction());
				System.out.println("isCompleted1: " + status.isCompleted());
				for (Member member: memberList) {
					namedParameterMemberDao.addMember(member);
				}
				System.out.println("isCompleted2: " + status.isCompleted());
				return null;
			}
		});
	}
}