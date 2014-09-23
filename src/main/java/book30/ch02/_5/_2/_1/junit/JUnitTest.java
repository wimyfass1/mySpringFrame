package book30.ch02._5._2._1.junit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class JUnitTest {
	static JUnitTest testObject;
	
	@Test
	public void test1() {
		assertThat(this, is(not(sameInstance(testObject))));
		//동일하지 않아야 통과가 된다.
		testObject = this;
	}
	
	@Test
	public void test2() {
		assertThat(this, is(not(sameInstance(testObject))));
		testObject = this;
	}
	
	@Test
	public void test3() {
		assertThat(this, is(not(sameInstance(testObject))));
		testObject = this;
	}
	
	
	//3가지 모두다 똑같은 비교
	//Spring 의 동작하는 자체적인 방식이다. 
	//test메써드 3개가 있으며 3개가 생성된다.
	//test1생성 후 test2가 나오면 1은 garbage가 된다.
	//test1에서 this로 testObject에 넣고 그 이후에 test1의 결과가 test2에 들어가서 새로운걸 만든다.
	//맞아? 정말맞아? 진짜정말맞아? << 뭐 이런느낌
	//각각의 다른 instance라는걸 보장해준다.
	
	//만약에 not이 빠지면 어떻게 될까?
	//마지막 test3에서 not을빼면 fail이 난다. 왜냐하면 같지않길 바래쓴데 같았기때문으디ㅏ?
	//객체가 다르기때문에
	

}
