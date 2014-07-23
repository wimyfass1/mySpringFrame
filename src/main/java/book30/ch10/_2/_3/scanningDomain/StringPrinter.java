package book30.ch10._2._3.scanningDomain;

import org.springframework.stereotype.Component;

@Component("printer")
public class StringPrinter implements Printer {
	private StringBuffer buffer = new StringBuffer();

	@Override
	public void print(String message) {
		this.buffer.append(message);
	}

	public String toString() {
		return this.buffer.toString();
	}
}
