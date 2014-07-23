package book30.ch10._2._1.domain;

import org.springframework.stereotype.Component;

import book30.ch10.domain.Printer;

@Component
//@Component("annotatedHello") <-- 위와 동일
public class AnnotatedHello {
	private String name;
	private Printer printer;

	public void setMessage(String name) {
		this.name = name;
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
	
	public Printer getPrinter() {
		return this.printer;
	}
}
