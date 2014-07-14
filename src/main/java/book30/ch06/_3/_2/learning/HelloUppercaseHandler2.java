package book30.ch06._3._2.learning;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloUppercaseHandler2 implements InvocationHandler {
	Object target;
	
	public HelloUppercaseHandler2(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object ret = (String)method.invoke(target, args);
		if (ret instanceof String) {
			return ((String)ret).toUpperCase();
		} else {
			return ret;
		}
	}
}