package com.currencyfair.processor.errors;

import java.util.List;

import com.currencyfair.entitys.TransactionData;

public class  ComplexErrorCalculator implements ErrorCalculator{

	private ErrorCalculator _firstErrorCalculator,_secondErrorCalculator;

	public ComplexErrorCalculator(ErrorCalculator firstErrorCalculator,ErrorCalculator secondErrorCalculator){
		_firstErrorCalculator = firstErrorCalculator;
		_secondErrorCalculator = secondErrorCalculator;
	}
	
	public List<String> calculateError(TransactionData transaction) {
		
		List<String> errors = _firstErrorCalculator.calculateError(transaction);
		errors.addAll(_secondErrorCalculator.calculateError(transaction));
		return errors;
	}
	
}