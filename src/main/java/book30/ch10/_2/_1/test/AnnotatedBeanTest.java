package book30.ch10._2._1.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import book30.ch10._2._1.domain.AnnotatedHello;

public class AnnotatedBeanTest {
	@Test
	public void simpleBeanScanning() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext("book30.ch10._2._1.domain");
		AnnotatedHello hello = ctx.getBean("annotatedHello", AnnotatedHello.class);
		
		assertThat(hello, is(notNullValue()));
		
		hello.setMessage("Spring3.0");
		
		assertThat(hello.sayHello(), is("Hello Spring3.0"));
	}
}
