package com.currencyfair.consumption;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.currencyfair.consumption.configurers.AspectsConfig;
import com.currencyfair.consumption.configurers.RestServiceConfig;
import com.currencyfair.consumption.configurers.GatewaysConfig;
import com.currencyfair.consumption.configurers.ServiceConfig;

@SpringBootApplication
public class Application {
		
	private static ConfigurableApplicationContext context;

	
	public static void main(String[] args) {
		context =SpringApplication.run(new Object[]{Application.class,
    			                          RestServiceConfig.class,
						    			   ServiceConfig.class ,
						                   AspectsConfig.class,
						                   GatewaysConfig.class}, args);
   	
    }
    
    public static void stop(){
    	context.close();
    	context.stop(); 
    }
    
    public static void close(){
    	context.close();
    }
}
