package com.currencyfair.processor.errors;

import java.util.ArrayList;
import java.util.List;

import com.currencyfair.processor.validators.TransactionValidator;

public class ErrorCalculatorFactory {
	
	private List<ErrorCalculator> _calculators = new ArrayList<ErrorCalculator>();
		
	public ErrorCalculator build(){
		ErrorCalculator errorCalculator = new InitialErrorCalculator();
		for (int index=0;index<_calculators.size();index++){
			errorCalculator = new ComplexErrorCalculator(errorCalculator, _calculators.get(index));
		}
		return errorCalculator;
	}
	
	public ErrorCalculatorFactory addCalculatorWithValidator(TransactionValidator validator,String error){
		_calculators.add(new CalculatorWithValidator(validator, error));
		return this;
	}

}
