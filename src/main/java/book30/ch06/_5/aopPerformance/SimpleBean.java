package book30.ch06._5.aopPerformance;

public class SimpleBean implements ISimpleBean {
	private long dummy = 0;

	@Override
	public void advisedMethod() {
		dummy = System.currentTimeMillis();
	}

	@Override
	public void unadvisedMethod() {
		dummy = System.currentTimeMillis();
	}
}
