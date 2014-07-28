package book30.ch11.domain;

import java.io.Serializable;

public class Member implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 289429621233953323L;
	int id;
	String number;
	String name;
	int point;
	Contact contact;

	public Member() {
		
	}
	
	public Member(String number, String name, int point) {
		super();
		this.number = number;
		this.name = name;
		this.point = point;
	}
	
	public Member(String number, String name, int point, Contact contact) {
		super();
		this.number = number;
		this.name = name;
		this.point = point;
		this.contact = contact;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
		if (contact != null)
			contact.setUserId(id);
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}
}
