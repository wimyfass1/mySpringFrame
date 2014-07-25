package book30.ch11._6._2.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import book30.ch11._6._2.service.MemberService;
import book30.ch11.domain.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="../../applicationContext.xml")
public class RollbackTestWithBatchUpdate {
	@Autowired
	private MemberService memberService;
	
	@Before
	public void init() {
	    this.memberService.deleteAll();
	}

	// batchUpdate라도 트랜잭션 설정 없으면 Rollback 되지 않는다.
	@Test
	public void addTransactionTestWithBatchUpdate() {
		List<Member> memberList = new ArrayList<Member>();
		memberList.add(new Member("0000000001", "GilDong Hong", 90));
		memberList.add(new Member("0000000002", "ChulSoo Kim", 80));
		memberList.add(new Member("0000000003", "SungHo Ahn", 70));
		//memberList.add(new Member("0000000004", "YounSim Lee", 60));
		memberList.add(new Member("00000000004", "YounSim Lee", 60));
		
		memberService.addMemberList(memberList);
	}
}