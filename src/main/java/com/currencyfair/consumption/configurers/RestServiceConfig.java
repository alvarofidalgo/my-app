package com.currencyfair.consumption.configurers;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;



@Configuration
@EnableWebMvc
@ComponentScan({ "com.currencyfair.consumption" })
@EnableAutoConfiguration
public class RestServiceConfig {
			
	@Bean public MappingJackson2HttpMessageConverter jacksonMessageConverter(){
        return new MappingJackson2HttpMessageConverter();
    }
	


}
