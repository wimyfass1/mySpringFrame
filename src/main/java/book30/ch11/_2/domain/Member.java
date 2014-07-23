package book30.ch11._2.domain;

import java.io.Serializable;

public class Member implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 289429621233953323L;
	int id;
	String number;
	String name;
	int point;

	public Member() {
		
	}
	
	public Member(String number, String name, int point) {
		super();
		this.number = number;
		this.name = name;
		this.point = point;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
}
