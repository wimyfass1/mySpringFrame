package book30.ch11.domain;

import java.io.Serializable;

public class Contact implements Serializable {
	private static final long serialVersionUID = 289429621233953324L;
	int id;
	int userId;
	String address;
	String phone;

	public Contact() {
		
	}
	
	public Contact(String address, String phone) {
		super();
		this.address = address;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
