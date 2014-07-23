package book30.ch10._2._3.domain;

import book30.ch10.domain.Printer;
import javax.annotation.Resource;

public class ResourceHello {
	private String name;
	private Printer printer;
	
	public ResourceHello() {
	}

	public ResourceHello(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
	}

	public String sayHello() {
		return "Hello " + name;
	}
	
	public void print() {
		this.printer.print(this.sayHello());
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Resource(name="printer")
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public Printer getPrinter() {
		return printer;
	}
}
