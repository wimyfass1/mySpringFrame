package book30.ch10.domain;

public class ConsolePrinter implements Printer {
	@Override
	public void print(String message) {
		System.out.println(message);

	}
}