package book30.ch10._2._1.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import book30.ch10._2._1.domain.AnnotatedHello;

// List 10-31, Page 811
@Configuration
public class AnnotatedHelloConfig {
	
	@Bean
	public AnnotatedHello annotatedHello() {
		return new AnnotatedHello();
	}
}