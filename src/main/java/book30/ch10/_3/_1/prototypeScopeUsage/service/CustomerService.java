package book30.ch10._3._1.prototypeScopeUsage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import book30.ch10._3._1.prototypeScopeUsage.dao.CustomerDao;
import book30.ch10._3._1.prototypeScopeUsage.domain.Customer;

@Component("customerService")
public class CustomerService {
	@Autowired
	private CustomerDao customerDao;
	
	public void add(Customer customer) {
		this.customerDao.add(customer);
	}
	
	public Customer findCustomerByNo(String customerNo) {
		return this.customerDao.findCustomerByNo(customerNo);
	}
}