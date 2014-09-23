package book30.ch02._5._2._3.junit;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertTrue;
//import static org.junit.matchers.JUnitMatchers.either;
import static org.hamcrest.CoreMatchers.either;

//import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.junit.Assert.assertThat;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import book30.ch02.practice.dao.UserDaoFailTest;
import book30.ch02.practice.dao.UserDaoTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="junit.xml")
//1

public class JUnitTest {
	@Autowired 
	ApplicationContext context;
	
	//이건 테스트 목적이 하나 더 추가됐다.
	//스프링 컨테이너가 일단 추가됐다. > 1
	//아래를 보면 junit이 추가되어있다.
	//context에 junit의 정보가 들어감.
	
	
	
	static Set<JUnitTest> testObjects = new HashSet<JUnitTest>();
	static ApplicationContext contextObject = null;
	
	@Test
	public void test1() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
		
		//여기까지 바로위와 동일함

		assertThat(contextObject == null || contextObject == this.context, is(true));
		
		//앞의 평가 결과가 true인지 확인한다.
		//여긴 assertThat
		contextObject = this.context;
		
		//
	}
	
	@Test
	public void test2() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
		
		assertTrue(contextObject == null || contextObject == this.context);
		//여긴 assertTrue 
		//여긴 평과결과가 True인지 보는것
		
		contextObject = this.context;
	}
	
	//test1과 2의 this의 객체는 다르나 context는 같다
	//3개중 뭐가 먼저될지 몰라서 null이라 하낟.
	//같은이유는 컨테이너는 같기때문이다.
	
	
	@Test
	public void test3() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
		
		//assertThat(contextObject, either(is(nullValue())).or(is(this.contextObject)));
		assertThat(contextObject, 
				   either(is(nullValue(ApplicationContext.class))).or(is(this.context)));
		
		//A가 B이거나 C일대 이건 오바야
		contextObject = this.context;
	}
	

}
