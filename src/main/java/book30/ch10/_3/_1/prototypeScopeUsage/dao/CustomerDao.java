package book30.ch10._3._1.prototypeScopeUsage.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import book30.ch10._3._1.prototypeScopeUsage.domain.Customer;

@Component("customerDao")
public class CustomerDao {
	Map<String, Customer> customerMap;
	
	public CustomerDao() {
		this.customerMap = new HashMap<String, Customer>();
	}
	
	public void add(Customer customer) {
		this.customerMap.put(customer.getCustomerNo(), customer);
	}
	
	public Customer findCustomerByNo(String customerNo) {
		return this.customerMap.get(customerNo);
	}
}