package com.currencyfair.consumption.configurers;

import org.springframework.context.annotation.Configuration;
import com.currencyfair.gateways.Context;
import com.currencyfair.persist.TransactionDataGateway;

@Configuration
public class GatewaysConfig {
  
	 public GatewaysConfig(){
		  Context.transactionGateway = new TransactionDataGateway();
	 }
}
