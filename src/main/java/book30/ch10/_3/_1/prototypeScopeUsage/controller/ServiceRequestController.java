package book30.ch10._3._1.prototypeScopeUsage.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import book30.ch10._3._1.prototypeScopeUsage.domain.ServiceRequest;
import book30.ch10._3._1.prototypeScopeUsage.service.ServiceRequestService;

//List 10-72
@Component("serviceRequestController")
public class ServiceRequestController {
	@Autowired
	private ServiceRequestService serviceRequestService;
	
	public void serviceRequestFormSubmit(HttpServletRequest request) {
		ServiceRequest serviceRequest = new ServiceRequest();
		serviceRequest.setCustomerNo(request.getParameter("customerNo"));
		serviceRequest.setProductNo(request.getParameter("productNo"));
		serviceRequest.setDescription(request.getParameter("description"));
		
		this.serviceRequestService.addNewServiceRequest(serviceRequest);
	}
}