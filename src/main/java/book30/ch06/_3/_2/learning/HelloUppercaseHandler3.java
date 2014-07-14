package book30.ch06._3._2.learning;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HelloUppercaseHandler3 implements InvocationHandler {
	Object target;
	
	public HelloUppercaseHandler3(Object target) {
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object ret = (String)method.invoke(target, args);
		if (ret instanceof String && method.getName().startsWith("sayH")) {
			return ((String)ret).toUpperCase();
		} else {
			return ret;
		}
	}
}