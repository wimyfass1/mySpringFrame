package book30.ch06._3._4.learning;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class FactoryBeanTest {
	@Autowired
	ApplicationContext context;
	
	@Test
	public void getMessageFromFactoryBean() {
		Message message = (Message)context.getBean("message");
		assertThat(message, isA(Message.class));
		assertThat(message.getText(), is("Factory Bean"));
	}
	
	@Test
	public void getMessageFromFactory() {
		MessageFactoryBean factory = (MessageFactoryBean)context.getBean("&message");
		assertThat(factory, isA(MessageFactoryBean.class));
	}
}