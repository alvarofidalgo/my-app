package com.currencyfair.consumption.configurers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.currencyfair.consumption.aspects.StatusAspect;

@Configuration
public class AspectsConfig {

	@Bean
	public StatusAspect getStatusAspect(){
		return new StatusAspect();
	}
}
