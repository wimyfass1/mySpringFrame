package book30.ch10._1._1.bean;

public class ConsolePrinter implements Printer {
	@Override
	public void print(String message) {
		System.out.println(message);

	}
}