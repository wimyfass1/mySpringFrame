package book30.ch10._2._5.domain;

import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import book30.ch10.domain.Hello;

public class SystemBean {
	@Autowired
	ApplicationContext context;
	
	@Autowired
	BeanFactory beanFactory;
	
	@Autowired
	ResourceLoader resourceLoader;
	
	@Autowired
	Properties systemProperties;
	
	@Value("#{systemProperties['os.name']}")
	String osName;
	
	public String specialJobWithContext() {
		System.out.println(this.context.getStartupDate());
		System.out.println(this.context.getApplicationName());
		System.out.println(this.context.getDisplayName());
		System.out.println(this.context.getId());
		Hello hello = this.context.getBean("hello", Hello.class);
		return hello.sayHello();
	}
	
	public String getApplicationId() {
		return this.context.getId();
	}
	
	public String specialJobWithBeanFactory() {
		Hello hello = this.beanFactory.getBean("hello", Hello.class);
		System.out.println(this.beanFactory.isSingleton("hello"));
		return hello.sayHello();
	}
	
	public String specialJobWithResoureLoader() {
		Resource resource = this.resourceLoader.getResource("classpath:book30.ch10._2._5.domain.SystemBean.java");
		return resource.getFilename();
	}
	
	public String specialJobWittSystemProperty() {
		systemProperties.list(System.out);
		return osName;
	}
}
