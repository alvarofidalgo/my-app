package com.currencyfair.processor.validators;

import com.currencyfair.entitys.TransactionData;

public interface TransactionValidator {
	
	
	public boolean isNotValid(TransactionData transaction);

}
