package com.currencyfair.processor.validators;

import static com.currencyfair.processor.validators.ValidatorConstants.EMPTY_DOUBLE_FIELD_VALUE;

import com.currencyfair.entitys.TransactionData;

public class AmountBuyValidator implements TransactionValidator{

	
	public boolean isNotValid(TransactionData transaction) {

		return EMPTY_DOUBLE_FIELD_VALUE.doubleValue()== transaction.getAmountBuy().doubleValue();
	}

}
