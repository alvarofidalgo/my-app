package com.currencyfair.processor.validators;

import com.currencyfair.entitys.TransactionData;

import static com.currencyfair.processor.validators.ValidatorConstants.EMPTY_STRING_FIELD_VALUE;

public class UserIdValidator implements TransactionValidator {

	
	public boolean isNotValid(TransactionData transaction) {
		
		return EMPTY_STRING_FIELD_VALUE.equals(transaction.getUserId());
	}

}
