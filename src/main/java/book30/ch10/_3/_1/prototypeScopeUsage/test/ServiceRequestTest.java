package book30.ch10._3._1.prototypeScopeUsage.test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;

import book30.ch10._3._1.prototypeScopeUsage.controller.ServiceRequestController;
import book30.ch10._3._1.prototypeScopeUsage.controller.ServiceRequestController2;
import book30.ch10._3._1.prototypeScopeUsage.controller.ServiceRequestController3;
import book30.ch10._3._1.prototypeScopeUsage.controller.ServiceRequestController4;
import book30.ch10._3._1.prototypeScopeUsage.dao.ServiceRequestDao;
import book30.ch10._3._1.prototypeScopeUsage.dao.ServiceRequestDao2;
import book30.ch10._3._1.prototypeScopeUsage.domain.Customer;
import book30.ch10._3._1.prototypeScopeUsage.domain.ServiceRequest;
import book30.ch10._3._1.prototypeScopeUsage.domain.ServiceRequest2;
import book30.ch10._3._1.prototypeScopeUsage.service.CustomerService;

public class ServiceRequestTest {
	private ApplicationContext context;
	
	@Before
	public void setUp() {
		context = new GenericXmlApplicationContext("book30/ch10/_3/_1/prototypeScopeUsage/applicationContext.xml");
		
		CustomerService customerService = context.getBean("customerService", CustomerService.class);
		
		Customer customer1 = new Customer("1", "101", "Michael Kim", "010-1111-2222", "michael.kim@gmail.com");
		Customer customer2 = new Customer("2", "102", "Lena Han", "010-2222-3333", "lena.han@gmail.com");
		Customer customer3 = new Customer("3", "103", "Robin Lee", "010-3333-4444", "robin.lee@gmail.com");
		
		customerService.add(customer1);
		customerService.add(customer2);
		customerService.add(customer3);		
	}
	
	@Test
	public void serviceRequestTest() {	
		ServiceRequestController serviceRequestController = context.getBean("serviceRequestController", ServiceRequestController.class);
		assertThat(serviceRequestController, is(not(nullValue())));
		
		MockHttpServletRequest req = new MockHttpServletRequest();
		req.setParameter("customerNo", "101");
		req.setParameter("productNo", "s400");
		req.setParameter("description", "Cann't turn on my Samsung TV");
		serviceRequestController.serviceRequestFormSubmit(req);
		
		ServiceRequestDao serviceRequestDao = context.getBean("serviceRequestDao", ServiceRequestDao.class);
		ServiceRequest serviceRequest = serviceRequestDao.get("101");
		assertThat(serviceRequest.getCustomerNo(), is("101"));
	}
	
	@Test
	public void serviceRequestTest2() {	
		ServiceRequestController2 serviceRequestController2 = context.getBean("serviceRequestController2", ServiceRequestController2.class);
		assertThat(serviceRequestController2, is(not(nullValue())));
		
		MockHttpServletRequest req = new MockHttpServletRequest();
		req.setParameter("customerNo", "102");
		req.setParameter("productNo", "g400");
		req.setParameter("description", "Cann't turn on my LG TV");
		serviceRequestController2.serviceRequestFormSubmit2(req);
		
		ServiceRequestDao2 serviceRequestDao2 = context.getBean("serviceRequestDao2", ServiceRequestDao2.class);	
		ServiceRequest2 serviceRequest2 = serviceRequestDao2.get("102");
		assertThat(serviceRequest2.getCustomer().getCustomerNo(), is("102"));
	}
	
	@Test
	public void serviceRequestTest3() {	
		ServiceRequestController2 serviceRequestController2 = context.getBean("serviceRequestController2", ServiceRequestController2.class);
		assertThat(serviceRequestController2, is(not(nullValue())));
		
		MockHttpServletRequest req = new MockHttpServletRequest();
		req.setParameter("customerNo", "102");
		req.setParameter("productNo", "g400");
		req.setParameter("description", "Cann't turn on my LG TV");
		serviceRequestController2.serviceRequestFormSubmit3(req);
		
		ServiceRequestDao2 serviceRequestDao2 = context.getBean("serviceRequestDao2", ServiceRequestDao2.class);	
		ServiceRequest2 serviceRequest2 = serviceRequestDao2.get("102");
		assertThat(serviceRequest2.getCustomer().getCustomerNo(), is("102"));
	}
	
	@Test
	public void serviceRequestTest4() {	
		ServiceRequestController2 serviceRequestController2 = context.getBean("serviceRequestController2", ServiceRequestController2.class);
		assertThat(serviceRequestController2, is(not(nullValue())));
		
		MockHttpServletRequest req = new MockHttpServletRequest();
		req.setParameter("customerNo", "102");
		req.setParameter("productNo", "g400");
		req.setParameter("description", "Cann't turn on my LG TV");
		serviceRequestController2.serviceRequestFormSubmit4(req);
		
		ServiceRequestDao2 serviceRequestDao2 = context.getBean("serviceRequestDao2", ServiceRequestDao2.class);	
		ServiceRequest2 serviceRequest2 = serviceRequestDao2.get("102");
		assertThat(serviceRequest2.getCustomer().getCustomerNo(), is("102"));
	}
	
	@Test
	public void serviceRequestTest5() {	
		ServiceRequestController3 serviceRequestController3 = context.getBean("serviceRequestController3", ServiceRequestController3.class);
		assertThat(serviceRequestController3, is(not(nullValue())));
		
		MockHttpServletRequest req = new MockHttpServletRequest();
		req.setParameter("customerNo", "102");
		req.setParameter("productNo", "g400");
		req.setParameter("description", "Cann't turn on my LG TV");
		serviceRequestController3.serviceRequestFormSubmit5(req);
		
		ServiceRequestDao2 serviceRequestDao2 = context.getBean("serviceRequestDao2", ServiceRequestDao2.class);	
		ServiceRequest2 serviceRequest2 = serviceRequestDao2.get("102");
		assertThat(serviceRequest2.getCustomer().getCustomerNo(), is("102"));
	}
	
	@Test
	public void serviceRequestTest6() {	
		ServiceRequestController4 serviceRequestController4 = context.getBean("serviceRequestController4", ServiceRequestController4.class);
		assertThat(serviceRequestController4, is(not(nullValue())));
		
		MockHttpServletRequest req = new MockHttpServletRequest();
		req.setParameter("customerNo", "102");
		req.setParameter("productNo", "g400");
		req.setParameter("description", "Cann't turn on my LG TV");
		serviceRequestController4.serviceRequestFormSubmit6(req);
		
		ServiceRequestDao2 serviceRequestDao2 = context.getBean("serviceRequestDao2", ServiceRequestDao2.class);	
		ServiceRequest2 serviceRequest2 = serviceRequestDao2.get("102");
		assertThat(serviceRequest2.getCustomer().getCustomerNo(), is("102"));
	}
}