package com.currencyfair.processor.errors;

import java.util.List;

import com.currencyfair.entitys.TransactionData;

public interface ErrorCalculator {
	
	public List<String> calculateError(TransactionData transaction);

}
