package book30.ch10._2._1.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import book30.ch10._2._1.domain.AnnotatedHello;

public class AnnotatedBeanTest2 {
	@Test
	public void simpleBeanScanning() {
		GenericApplicationContext applicationContext = new GenericXmlApplicationContext("book30/ch10/_2/_1/genericApplicationContext.xml");

		AnnotatedHello hello = applicationContext.getBean("annotatedHello", AnnotatedHello.class);
		
		assertThat(hello, is(notNullValue()));
		
		hello.setMessage("Spring3.0");
		
		assertThat(hello.sayHello(), is("Hello Spring3.0"));
		applicationContext.close();
	}
}
