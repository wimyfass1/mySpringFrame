package book30.ch06._5._2.service;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.util.PatternMatchUtils;

public class NameMatchClassMethodPointcut extends NameMatchMethodPointcut {
	private static final long serialVersionUID = 1709435503159078839L;

	public void setMappedClassName(String mappedClassName) {
		this.setClassFilter(new SimpleClassFilter(mappedClassName));
	}
	
	static class SimpleClassFilter implements ClassFilter {
		String mappedClassName;
		
		private SimpleClassFilter(String mappedClassName) {
			this.mappedClassName = mappedClassName;
		}
		
		@Override
		public boolean matches(Class<?> clazz) {
			return PatternMatchUtils.simpleMatch(this.mappedClassName, clazz.getSimpleName());
		}
	}
}