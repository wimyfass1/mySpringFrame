package book30.ch10._3._1.prototypeScopeUsage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import book30.ch10._3._1.prototypeScopeUsage.domain.ServiceRequest2;
import book30.ch10._3._1.prototypeScopeUsage.service.ServiceRequestService2;

//List 10-89
public abstract class ServiceRequestController3 {
	@Autowired
	private ServiceRequestService2 serviceRequestService2;

	abstract public ServiceRequest2 getServiceRequest2();
	
	public void serviceRequestFormSubmit5(HttpServletRequest request) {
		ServiceRequest2 serviceRequest2 = this.getServiceRequest2();
		serviceRequest2.setCustomerByCostomerNo(request.getParameter("customerNo"));
		serviceRequest2.setProductNo(request.getParameter("productNo"));
		serviceRequest2.setDescription(request.getParameter("description"));
		
		this.serviceRequestService2.addNewServiceRequest(serviceRequest2);
	}
}