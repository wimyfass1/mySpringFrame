package book30.ch10._2._3.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import book30.ch10._2._3.scanningDomain.Hello;
import book30.ch10._2._3.scanningDomain.Printer;
import book30.ch10._2._3.scanningDomain.StringPrinter;

//List 10-49
public class ComponentScanDITest {
	@Test
	public void diTest() {
		ApplicationContext ctx = new GenericXmlApplicationContext("book30/ch10/_2/_3/componentScanApplicationContext.xml");
		
		Hello hello = ctx.getBean("hello", Hello.class);
		Printer printer = ctx.getBean("printer", StringPrinter.class);
		assertThat(hello.getPrinter(), is(sameInstance(printer)));
	}
}