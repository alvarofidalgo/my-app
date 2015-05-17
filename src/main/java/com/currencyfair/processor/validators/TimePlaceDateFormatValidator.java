package com.currencyfair.processor.validators;

import com.currencyfair.entitys.TransactionData;
import com.currencyfair.processor.parsers.DateFormaterSeeker;
import com.currencyfair.processor.parsers.LocaleFormatter;

import static com.currencyfair.processor.parsers.ParserConstants.BAD_DATE_FORMAT;

public class TimePlaceDateFormatValidator implements TransactionValidator {
	
	private DateFormaterSeeker _dateFormatSeeker;

	public TimePlaceDateFormatValidator(DateFormaterSeeker dateFormatSeeker){
		_dateFormatSeeker = dateFormatSeeker;
	}
	
	public boolean isNotValid(TransactionData transaction) { 
		LocaleFormatter localeFormatter = 
				                  _dateFormatSeeker.matchPatter(
				                		                  transaction.getTimePlaced());
        return BAD_DATE_FORMAT.equals(localeFormatter.getFormater());
		
	}

}
