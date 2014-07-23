package book30.ch10._1._2.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import book30.ch10.domain.Hello;
import book30.ch10.domain.Printer;

//List 10-13
public class GenericApplicationContextTest3 {
	@Test
	public void genericApplicationContext() {
		GenericApplicationContext applicationContext = new GenericXmlApplicationContext("book30/ch10/_1/_2/genericApplicationContext.xml");
		
		//applicationContext.refresh();
		
		Hello hello = applicationContext.getBean("hello", Hello.class);
		Printer printer = applicationContext.getBean("printer", Printer.class);
		
		hello.print();
		
		assertThat(hello.sayHello(), is("Hello Spring"));
		assertThat(printer.toString(), is("Hello Spring"));
		applicationContext.close();
	}
}
