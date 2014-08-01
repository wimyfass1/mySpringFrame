package book30.ch11.additional.service;

import org.springframework.transaction.annotation.Transactional;

import book30.ch11.domain.Member;

//아래 @Transactional 삭제시에 member 테이블과 contact 테이블간의 일관성 문제가 발생할 수 있다.
@Transactional
public interface MemberService {
	//deleteAll	
	public void deleteAll();
	
	//addMember
	public void addMember(Member member);
}
