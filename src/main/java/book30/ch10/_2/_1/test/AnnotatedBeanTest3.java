package book30.ch10._2._1.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import book30.ch10._2._1.configuration.AnnotatedHelloConfig;
import book30.ch10._2._1.domain.AnnotatedHello;

//List 10-32, Page 811
public class AnnotatedBeanTest3 {
	@Test
	public void simpleBeanScanning() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AnnotatedHelloConfig.class);

		AnnotatedHelloConfig config = applicationContext.getBean("annotatedHelloConfig", AnnotatedHelloConfig.class);
		AnnotatedHello hello = applicationContext.getBean("annotatedHello", AnnotatedHello.class);
		
		assertThat(hello, is(notNullValue()));
		
		hello.setMessage("Spring3.0");
		
		assertThat(hello.sayHello(), is("Hello Spring3.0"));
		
		assertThat(config, is(notNullValue()));
		assertThat(config.annotatedHello(), is(sameInstance(hello))); //bean scope - singleton
	}
}
