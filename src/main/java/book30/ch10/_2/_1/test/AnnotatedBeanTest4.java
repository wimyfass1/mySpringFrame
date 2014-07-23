package book30.ch10._2._1.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import book30.ch10._2._1.configuration.HelloConfig;
import book30.ch10.domain.Hello;

//Page 814
public class AnnotatedBeanTest4 {
	@Test
	public void simpleBeanScanning() {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HelloConfig.class);

		Hello hello1 = applicationContext.getBean("hello1", Hello.class);
		Hello hello2 = applicationContext.getBean("hello2", Hello.class);
		
		assertThat(hello1.getPrinter(), is(sameInstance(hello2.getPrinter())));
	}
}
