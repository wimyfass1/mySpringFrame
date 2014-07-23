package book30.ch10._3._1.prototypeScopeUsage.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import book30.ch10._3._1.prototypeScopeUsage.dao.CustomerDao;
import book30.ch10._3._1.prototypeScopeUsage.service.EmailService;

//List 10-74, 10-76, 10-78, 10-80
@Component("serviceRequest2")
@Scope("prototype")
public class ServiceRequest2 {
	Customer customer;
	String productNo;
	String description;
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private EmailService emailService;
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getProductNo() {
		return productNo;
	}
	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void setCustomerByCostomerNo(String customerNo) {
		this.customer = this.customerDao.findCustomerByNo(customerNo);
	}
	
	public void notifyServiceRequestRegistration() {
		this.emailService.sendEmail(this.customer.getEmail(), "A/S Request Registered.");
	}
}
