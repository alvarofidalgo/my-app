package com.currencyfair.processor.configurers;

import com.currencyfair.processor.constants.ErrorConstants;
import com.currencyfair.processor.errors.ErrorCalculator;
import com.currencyfair.processor.errors.ErrorCalculatorFactory;
import com.currencyfair.processor.validators.AmountBuyValidator;
import com.currencyfair.processor.validators.AmountSellValidator;
import com.currencyfair.processor.validators.CurrencyFromValidator;
import com.currencyfair.processor.validators.CurrencyToValidator;
import com.currencyfair.processor.validators.OriginCountryValidator;
import com.currencyfair.processor.validators.RateValidator;
import com.currencyfair.processor.validators.TimePlaceDateFormatValidator;
import com.currencyfair.processor.validators.TimePlacedValidator;
import com.currencyfair.processor.validators.UserIdValidator;

public class ErrorCalculatorConfigurer {
	
	public ErrorCalculator defaultCalculator(){
		;
		return new ErrorCalculatorFactory()
                   .addCalculatorWithValidator(new UserIdValidator(), ErrorConstants.ERROR_USER_ID_EMPTY)
                    .addCalculatorWithValidator(new CurrencyFromValidator(), ErrorConstants.ERROR_CURRENCY_FROM_IS_EMPTY)
                    .addCalculatorWithValidator(new CurrencyToValidator(), ErrorConstants.ERROR_CURRENCY_TO_IS_EMPTY)
                    .addCalculatorWithValidator(new AmountSellValidator(), ErrorConstants.ERROR_AMOUNT_SELL_IS_EMPTY)
                    .addCalculatorWithValidator(new AmountBuyValidator(), ErrorConstants.ERROR_AMOUNT_BUY_IS_EMPTY)
                    .addCalculatorWithValidator(new RateValidator(), ErrorConstants.ERROR_RATE_IS_EMPTY)
                    .addCalculatorWithValidator(new TimePlacedValidator(), ErrorConstants.ERROR_TIMEPLACED_IS_EMPTY)
                    .addCalculatorWithValidator(new OriginCountryValidator(), ErrorConstants.ERROR_ORIGIN_COUNTRY_IS_EMPTY)
                    .addCalculatorWithValidator(new TimePlaceDateFormatValidator(
                    		                                               new DateFormatSeekerConfigurer().defaultConfigurer()), 
                    		                      ErrorConstants.ERROR_DATE_FORMAT)
                    .build();
	}

}
