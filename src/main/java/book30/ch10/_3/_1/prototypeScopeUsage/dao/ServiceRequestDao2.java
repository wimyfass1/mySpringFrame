package book30.ch10._3._1.prototypeScopeUsage.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import book30.ch10._3._1.prototypeScopeUsage.domain.ServiceRequest2;

@Component("serviceRequestDao2")
public class ServiceRequestDao2 {
	Map<String, ServiceRequest2> serviceRequestMap;
	
	public ServiceRequestDao2() {
		this.serviceRequestMap = new HashMap<String, ServiceRequest2>();
	}
	
	public void add(ServiceRequest2 serviceRequest2) {
		this.serviceRequestMap.put(serviceRequest2.getCustomer().getCustomerNo(), serviceRequest2);
	}
	
	public ServiceRequest2 get(String customerNo) {
		return this.serviceRequestMap.get(customerNo);
	}
}