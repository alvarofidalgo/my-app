package com.currencyfair.processor.validators;

import com.currencyfair.entitys.TransactionData;

import static com.currencyfair.processor.validators.ValidatorConstants.EMPTY_DOUBLE_FIELD_VALUE;

public class RateValidator implements TransactionValidator {

	
	public boolean isNotValid(TransactionData transaction) {

		return EMPTY_DOUBLE_FIELD_VALUE.doubleValue() == transaction.getRate().doubleValue();
	}

}
