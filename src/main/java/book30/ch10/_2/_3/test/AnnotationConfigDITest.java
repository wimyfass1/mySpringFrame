package book30.ch10._2._3.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import book30.ch10._2._3.domain.ResourceHello;
import book30.ch10.domain.Printer;

//List 10-49
public class AnnotationConfigDITest {
	@Test
	public void diTest() {
		ApplicationContext ctx = new GenericXmlApplicationContext("book30/ch10/_2/_3/annotationConfigApplicationContext.xml");
		
		ResourceHello rHello = ctx.getBean("rHello", ResourceHello.class);
		Printer printer = ctx.getBean("printer", Printer.class);
		assertThat(rHello.getPrinter(), is(sameInstance(printer)));
	}
}