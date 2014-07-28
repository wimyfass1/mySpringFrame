package book30.ch11.isolation.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import book30.ch11.additional.service.MemberService;
import book30.ch11.domain.Contact;
import book30.ch11.domain.Member;

@SuppressWarnings("unused")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="../applicationContext.xml")
public class IsoluationTest {
	@Autowired
	private MemberService memberService;
	
	@Before
	public void init() {
	    this.memberService.deleteAll();
	}
	
	@Test
	public void addTransactionTestWithXmlAopConfiguration() {
		Contact contact1 = new Contact("CheonAn", "010-0000-0000");
		Member member1 = new Member("0000000001", "GilDong Hong", 90, contact1);
		memberService.addMember(member1);
		
		Contact contact2 = new Contact("Seoul", "010-1111-1111-1111-1111-1111-1111-1111");
		Member member2 = new Member("0000000002", "ChulSoo Kim", 80, contact2);
		memberService.addMember(member2);
	}
}