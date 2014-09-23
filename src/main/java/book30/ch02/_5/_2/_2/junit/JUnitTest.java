package book30.ch02._5._2._2.junit;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
//import static org.junit.matchers.JUnitMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItem;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class JUnitTest {
	static Set<JUnitTest> testObjects = new HashSet<JUnitTest>();
	
	//2_5_1과 다른점은 HashSet으로 바뀌었다.
	//Type은 JUnitTest으로
	//HashSet안에 JUnit객체만 담겠다.
	
	//특징은 동일한 객체가 안들어온다.
	//아래와 같은 테스트를 하면 각자 다른 객체이기때문에 다 들어간다.
	
	@Test
	public void test1() {
		assertThat(testObjects, not(hasItem(this)));
		//hashItem이 this를 갖고있지말아야된다는뜻
		testObjects.add(this);
	}
	
	@Test
	public void test2() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
	}
	
	@Test
	public void test3() {
		assertThat(testObjects, not(hasItem(this)));
		testObjects.add(this);
	}
	

}
