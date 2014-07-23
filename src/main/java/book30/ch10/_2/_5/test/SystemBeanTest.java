package book30.ch10._2._5.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import book30.ch10._2._5.domain.SystemBean;

public class SystemBeanTest {
	@Test
	public void genericApplicationContext() {
		ApplicationContext applicationContext = new GenericXmlApplicationContext("book30/ch10/_2/_5/genericApplicationContext.xml");
				
		SystemBean sBean = applicationContext.getBean("systemBean", SystemBean.class);
		
		assertThat(sBean.specialJobWithContext(), is("Hello Spring"));
		assertThat(sBean.specialJobWithBeanFactory(), is("Hello Spring"));
		assertThat(sBean.getApplicationId(), is(applicationContext.getId()));
		assertThat(sBean.specialJobWithResoureLoader(), is("book30.ch10._2._5.domain.SystemBean.java"));
		assertThat(sBean.specialJobWittSystemProperty(), is("Mac OS X"));
		
		DataSource dataSource1 = applicationContext.getBean("dataSource1", DataSource.class);
		DataSource dataSource2 = applicationContext.getBean("dataSource2", DataSource.class);
		DataSource dataSource3 = applicationContext.getBean("dataSource3", DataSource.class);
		
		assertThat(dataSource1, is(notNullValue()));
		assertThat(dataSource2, is(notNullValue()));
		assertThat(dataSource3, is(notNullValue()));		
	}
}
