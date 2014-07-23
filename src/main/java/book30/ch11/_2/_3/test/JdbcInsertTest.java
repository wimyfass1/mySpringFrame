package book30.ch11._2._3.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import book30.ch11._2._3.service.MemberService2;
import book30.ch11._2.domain.Member;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="../../applicationContext.xml")
public class JdbcInsertTest {
	@Autowired
	private MemberService2 memberService2;
	
	@Before
	public void init() {
	    this.memberService2.deleteAll();
	}
	
	//List 11-5
	@Test
	public void jdbcInsertTest() {
		//addMember	using simpleJdbcInsert
		memberService2.addMemberUsingJdbcInsert1(new Member("001", "GilDong Hong", 90));
		memberService2.addMemberUsingJdbcInsert1(new Member("002", "ChulSoo Kim", 80));
		memberService2.addMemberUsingJdbcInsert1(new Member("003", "SungHo Ahn", 70));
		memberService2.addMemberUsingJdbcInsert1(new Member("004", "YounSim Lee", 60));
		
		assertThat(memberService2.numMembers(), is(4));
	}
	
	//List 11-6
	@Test
	public void jdbcInsertAndRetuenKeyTest() {
		//addMember	using simpleJdbcInsert
		int key1 = memberService2.addMemberUsingJdbcInsert2(new Member("001", "GilDong Hong", 90));
		int key2 = memberService2.addMemberUsingJdbcInsert2(new Member("002", "ChulSoo Kim", 80));
		int key3 = memberService2.addMemberUsingJdbcInsert2(new Member("003", "SungHo Ahn", 70));
		int key4 = memberService2.addMemberUsingJdbcInsert2(new Member("004", "YounSim Lee", 60));
		
		assertThat(memberService2.numMembers(), is(4));
		
		Member member = memberService2.getMemberById(key4);
		assertThat(member.getName(), is("YounSim Lee"));
	}
}