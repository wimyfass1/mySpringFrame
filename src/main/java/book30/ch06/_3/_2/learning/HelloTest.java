package book30.ch06._3._2.learning;

import java.lang.reflect.Proxy;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HelloTest {
	@Test
	public void noProxy() {
		Hello hello = new HelloTarget();
		assertThat(hello.sayHello("Toby"), is("Hello Toby"));
		assertThat(hello.sayHi("Toby"), is("Hi Toby"));
		assertThat(hello.sayThankYou("Toby"), is("Thank You Toby"));
	}
	
	@Test
	public void simpleProxy() {
		Hello proxiedHello = new HelloUppercaseProxy(new HelloTarget());
		assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
		assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
		assertThat(proxiedHello.sayThankYou("Toby"), is("THANK YOU TOBY"));
	}
	
	@Test
	public void dynamicProxy() {
		Hello proxiedHello = (Hello)Proxy.newProxyInstance(
								getClass().getClassLoader(), 
								new Class[]{Hello.class}, 
								new HelloUppercaseHandler(new HelloTarget()));
		assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
		assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
		assertThat(proxiedHello.sayThankYou("Toby"), is("THANK YOU TOBY"));
	}
	
	@Test
	public void extendedDynamicProxy() {
		Hello proxiedHello = (Hello)Proxy.newProxyInstance(
								getClass().getClassLoader(), 
								new Class[]{Hello.class}, 
								new HelloUppercaseHandler2(new HelloTarget()));
		assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
		assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
		assertThat(proxiedHello.sayThankYou("Toby"), is("THANK YOU TOBY"));
	}
	
	@Test
	public void selectiveExtendedDynamicProxy() {
		Hello proxiedHello = (Hello)Proxy.newProxyInstance(
								getClass().getClassLoader(), 
								new Class[]{Hello.class}, 
								new HelloUppercaseHandler3(new HelloTarget()));
		assertThat(proxiedHello.sayHello("Toby"), is("HELLO TOBY"));
		assertThat(proxiedHello.sayHi("Toby"), is("HI TOBY"));
		assertThat(proxiedHello.sayThankYou("Toby"), is("Thank You Toby"));
	}
}