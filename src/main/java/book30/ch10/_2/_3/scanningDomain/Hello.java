package book30.ch10._2._3.scanningDomain;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("hello")
public class Hello {
	private String name;
	private Printer printer;
	
	public Hello() {
	}

	public Hello(String name, Printer printer) {
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
