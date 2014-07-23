package book30.ch10._3._1.prototypeScopeUsage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import book30.ch10._3._1.prototypeScopeUsage.domain.ServiceRequest2;
import book30.ch10._3._1.prototypeScopeUsage.domain.ServiceRequest2Factory;
import book30.ch10._3._1.prototypeScopeUsage.service.ServiceRequestService2;

import javax.annotation.Resource;

//List 10-72, 10-79
@Component("serviceRequestController2")
public class ServiceRequestController2 {
	@Autowired
	private ServiceRequestService2 serviceRequestService2;
	
	@Autowired
	private ApplicationContext context;
		
	public void serviceRequestFormSubmit2(HttpServletRequest request) {
		//ServiceRequest2 serviceRequest2 = new ServiceRequest2() <-- customerDao를 DI할 수 없음
		ServiceRequest2 serviceRequest2 = this.context.getBean("serviceRequest2", ServiceRequest2.class);
		serviceRequest2.setCustomerByCostomerNo(request.getParameter("customerNo"));
		serviceRequest2.setProductNo(request.getParameter("productNo"));
		serviceRequest2.setDescription(request.getParameter("description"));
		
		this.serviceRequestService2.addNewServiceRequest(serviceRequest2);
	}
	
	
	//List 10-84
	@Resource(name="serviceRequestFactory")
	private ObjectFactory<ServiceRequest2> serviceRequest2Factory;
	
	public void serviceRequestFormSubmit3(HttpServletRequest request) {
		ServiceRequest2 serviceRequest2 = this.serviceRequest2Factory.getObject();
		serviceRequest2.setCustomerByCostomerNo(request.getParameter("customerNo"));
		serviceRequest2.setProductNo(request.getParameter("productNo"));
		serviceRequest2.setDescription(request.getParameter("description"));
		
		this.serviceRequestService2.addNewServiceRequest(serviceRequest2);
	}
	
	//List 10-88
	@Autowired
	private ServiceRequest2Factory serviceRequest2Factory2;
	
	public void serviceRequestFormSubmit4(HttpServletRequest request) {
		ServiceRequest2 serviceRequest2 = this.serviceRequest2Factory2.getServiceRequet2();
		serviceRequest2.setCustomerByCostomerNo(request.getParameter("customerNo"));
		serviceRequest2.setProductNo(request.getParameter("productNo"));
		serviceRequest2.setDescription(request.getParameter("description"));
		
		this.serviceRequestService2.addNewServiceRequest(serviceRequest2);
	}
}