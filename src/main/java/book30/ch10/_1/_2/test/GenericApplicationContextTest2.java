package book30.ch10._1._2.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import book30.ch10.domain.Hello;
import book30.ch10.domain.Printer;

//List 10-12
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"../genericApplicationContext.xml"})
public class GenericApplicationContextTest2 {
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void genericApplicationContext2() {		
		Hello hello = applicationContext.getBean("hello", Hello.class);
		Printer printer = applicationContext.getBean("printer", Printer.class);
		
		hello.print();
		
		assertThat(hello.sayHello(), is("Hello Spring"));
		assertThat(printer.toString(), is("Hello Spring"));
	}
}
