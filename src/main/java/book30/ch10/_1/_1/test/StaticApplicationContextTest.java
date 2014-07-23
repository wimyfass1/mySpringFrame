package book30.ch10._1._1.test;

import book30.ch10.domain.ConsolePrinter;
import book30.ch10.domain.Hello;
import book30.ch10.domain.StringPrinter;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;

@SuppressWarnings("unused")
public class StaticApplicationContextTest {
	//List 10-5, 10-6, 10-7
	@Test
	public void registerBean() {
		//List 10-5
		StaticApplicationContext ac = new StaticApplicationContext();
		ac.registerSingleton("hello1", Hello.class);
		
		Hello hello1 = ac.getBean("hello1", Hello.class);
		assertThat(hello1, is(notNullValue()));
		assertThat(hello1.sayHello(), is("Hello null"));
		
		//List 10-6
		BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
		helloDef.getPropertyValues().addPropertyValue("name", "Spring");
		ac.registerBeanDefinition("hello2", helloDef);

		//List 10-7
		Hello hello2 = ac.getBean("hello2", Hello.class);
		assertThat(hello2, is(notNullValue()));
		assertThat(hello2.sayHello(), is("Hello Spring"));
		
		assertThat(hello1, is(not(hello2)));
		assertThat(hello1.sayHello(), is("Hello null"));
		
		assertThat(ac.getBeanFactory().getBeanDefinitionCount(), is(2));
		ac.close();
	}
	
	//List 10-8
	@Test
	public void registerBeanWithDependency() {
		StaticApplicationContext ac = new StaticApplicationContext();
		
		ac.registerBeanDefinition("printer", new RootBeanDefinition(StringPrinter.class));
		//ac.registerBeanDefinition("printer", new RootBeanDefinition(ConsolePrinter.class));

		BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
		helloDef.getPropertyValues().addPropertyValue("name", "Spring");
		helloDef.getPropertyValues().addPropertyValue("printer", new RuntimeBeanReference("printer"));
		ac.registerBeanDefinition("hello", helloDef);

		Hello hello = ac.getBean("hello", Hello.class);
		hello.print();

		assertThat(ac.getBean("printer").toString(), is("Hello Spring"));
		
		ac.close();
	}
}
