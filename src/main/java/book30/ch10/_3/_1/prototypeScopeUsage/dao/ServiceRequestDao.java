package book30.ch10._3._1.prototypeScopeUsage.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import book30.ch10._3._1.prototypeScopeUsage.domain.Customer;
import book30.ch10._3._1.prototypeScopeUsage.domain.ServiceRequest;

@Component("serviceRequestDao")
public class ServiceRequestDao {
	Map<String, ServiceRequest> serviceRequestMap;
	
	public ServiceRequestDao() {
		this.serviceRequestMap = new HashMap<String, ServiceRequest>();
	}
	
	public void add(ServiceRequest serviceRequest, Customer customer) {
		this.serviceRequestMap.put(customer.getCustomerNo(), serviceRequest);
	}
	
	public ServiceRequest get(String customerNo) {
		return this.serviceRequestMap.get(customerNo);
	}
}