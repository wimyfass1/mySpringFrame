package book30.ch10._3._1.prototypeScopeUsage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import book30.ch10._3._1.prototypeScopeUsage.dao.CustomerDao;
import book30.ch10._3._1.prototypeScopeUsage.dao.ServiceRequestDao2;
import book30.ch10._3._1.prototypeScopeUsage.domain.ServiceRequest2;

//List 10-73, 10-81
@Component("serviceRequestService2")
public class ServiceRequestService2 {
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private ServiceRequestDao2 serviceRequestDao2;
	
	@Autowired
	private EmailService emailService;
		
	public void addNewServiceRequest(ServiceRequest2 serviceRequest2) {
		//Customer customer = this.customerDao.findCustomerByNo(serviceRequest.getCustomerNo());
		this.serviceRequestDao2.add(serviceRequest2);
		serviceRequest2.notifyServiceRequestRegistration();
	}
}
