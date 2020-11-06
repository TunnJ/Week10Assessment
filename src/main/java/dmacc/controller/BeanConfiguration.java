package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.IceCream;

@Configuration
public class BeanConfiguration {
	
	@Bean
	public IceCream icecream() {
		IceCream bean = new IceCream();
		return bean;
	}
}
