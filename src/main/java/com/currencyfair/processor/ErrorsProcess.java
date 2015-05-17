package com.currencyfair.processor;

import java.util.List;

import com.currencyfair.entitys.TransactionData;
import com.currencyfair.processor.configurers.ErrorCalculatorConfigurer;


public class ErrorsProcess implements BeforeProcess {
	

	public List<String> processTransaction(TransactionData transactionData) {        
		return new ErrorCalculatorConfigurer().defaultCalculator().calculateError(transactionData);
	}
	
}
