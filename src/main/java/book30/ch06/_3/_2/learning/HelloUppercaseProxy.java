package book30.ch06._3._2.learning;

public class HelloUppercaseProxy implements Hello {
	Hello hello;
	
	public HelloUppercaseProxy(Hello hello) {
		this.hello = hello;
	}

	@Override
	public String sayHello(String name) {
		return this.hello.sayHello(name).toUpperCase();
	}

	@Override
	public String sayHi(String name) {
		return this.hello.sayHi(name).toUpperCase();	
	}

	@Override
	public String sayThankYou(String name) {
		return this.hello.sayThankYou(name).toUpperCase();
	}
}