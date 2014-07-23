package book30.ch10._3._1.prototypeScopeUsage.domain;

import org.springframework.stereotype.Component;

@Component("customer")
public class Customer {
	String id;
	String customerNo;
	String name;
	String phone;
	String email;
	
	public Customer() {
		
	}
	
	public Customer(String id, String customerNo, String name, String phone, String email) {
		super();
		this.id = id;
		this.customerNo = customerNo;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomerNo() {
		return customerNo;
	}
	public void setCustomerNo(String customerNo) {
		this.customerNo = customerNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
