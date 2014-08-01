package book30.ch06._5.aopPerformance;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SimpleBeforeAdvice implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("Output in SimpleBeforeAdvice: " + method.getName());
	}
}
