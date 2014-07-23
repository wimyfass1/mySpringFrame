package book30.ch10._1._3.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import book30.ch10.domain.Hello;
import book30.ch10.domain.Printer;

//List 10-17, 10-18, 10-19, 10-20, 10-21
public class HierarchyApplicationContextTest {
	@Test(expected=BeanCreationException.class)
	public void createContextWithoutParent() {
		ApplicationContext child = new GenericXmlApplicationContext("book30/ch10/_1/_3/childContext.xml");
	}
	
	@Test
	public void contextHierachy() {
		ApplicationContext parent = new GenericXmlApplicationContext("book30/ch10/_1/_3/parentContext.xml");

		GenericApplicationContext child = new GenericApplicationContext(parent);
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(child);
		reader.loadBeanDefinitions("book30/ch10/_1/_3/childContext.xml");
		child.refresh();
		
		Printer printer = child.getBean("printer", Printer.class);
		assertThat(printer, is(notNullValue()));
		
		Hello hello = child.getBean("hello", Hello.class);
		assertThat(hello, is(notNullValue()));
		
		hello.print();
		assertThat(printer.toString(), is("Hello Child"));
		
		Hello hello2 = parent.getBean("hello", Hello.class);
		hello2.print();
		assertThat(printer.toString(), is("Hello ChildHello Parent"));
	}
}