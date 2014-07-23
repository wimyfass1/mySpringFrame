package book30.ch10._2._1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import book30.ch10.domain.Hello;
import book30.ch10.domain.Printer;
import book30.ch10.domain.StringPrinter;

//List 10-34, Page 814
@Configuration
public class HelloConfig {
	@Bean
	public Hello hello1() {
		Hello hello = new Hello();
		hello.setName("Spring");
		hello.setPrinter(printer());
		return hello;
	}
	
	@Bean
	public Hello hello2() {
		Hello hello = new Hello();
		hello.setName("Spring2");
		hello.setPrinter(printer());
		return hello;
	}
	
	@Bean
	public Printer printer() {
		return new StringPrinter();
	}
}
