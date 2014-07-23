package book30.ch10._3._1.prototypeScopeUsage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.inject.Inject;
import javax.inject.Provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import book30.ch10._3._1.prototypeScopeUsage.domain.ServiceRequest2;
import book30.ch10._3._1.prototypeScopeUsage.service.ServiceRequestService2;

//List 10-91
@Component("serviceRequestController4")
public class ServiceRequestController4 {
	@Autowired
	private ServiceRequestService2 serviceRequestService2;
	
	@Inject 
	Provider<ServiceRequest2> serviceRequestProvider;
	
	public void serviceRequestFormSubmit6(HttpServletRequest request) {
		ServiceRequest2 serviceRequest2 = this.serviceRequestProvider.get();
		serviceRequest2.setCustomerByCostomerNo(request.getParameter("customerNo"));
		serviceRequest2.setProductNo(request.getParameter("productNo"));
		serviceRequest2.setDescription(request.getParameter("description"));
		
		this.serviceRequestService2.addNewServiceRequest(serviceRequest2);
	}
}