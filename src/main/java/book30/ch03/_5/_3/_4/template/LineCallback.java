package book30.ch03._5._3._4.template;

public interface LineCallback<T> {
	T doSomethingWithLine(String line, T value);
}
