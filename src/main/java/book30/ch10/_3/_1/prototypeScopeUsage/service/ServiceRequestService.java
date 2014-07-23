package book30.ch10._3._1.prototypeScopeUsage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import book30.ch10._3._1.prototypeScopeUsage.dao.CustomerDao;
import book30.ch10._3._1.prototypeScopeUsage.dao.ServiceRequestDao;
import book30.ch10._3._1.prototypeScopeUsage.domain.Customer;
import book30.ch10._3._1.prototypeScopeUsage.domain.ServiceRequest;

//List 10-73
@Component("serviceRequestService")
public class ServiceRequestService {
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ServiceRequestDao serviceRequestDao;
	
	@Autowired
	private EmailService emailService;
	
	public void addNewServiceRequest(ServiceRequest serviceRequest) {
		Customer customer = this.customerDao.findCustomerByNo(serviceRequest.getCustomerNo());
		this.serviceRequestDao.add(serviceRequest, customer);
		this.emailService.sendEmail(customer.getEmail(), "A/S Request Registered.");
	}
}
