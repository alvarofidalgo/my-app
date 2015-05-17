package com.currencyfair.processor.errors;

import java.util.ArrayList;
import java.util.List;

import com.currencyfair.entitys.TransactionData;
import com.currencyfair.processor.validators.TransactionValidator;

public class CalculatorWithValidator implements ErrorCalculator{
	
	private TransactionValidator _validator;
	private String _error;
	
	public CalculatorWithValidator(TransactionValidator validator,String error){
		_validator = validator;
		_error = error;	
	}
	
	public List<String> calculateError(TransactionData transaction){
		List<String> errors = new ArrayList<String>();
		if (_validator.isNotValid(transaction))
			errors.add(_error);
		return errors;
	}

}
