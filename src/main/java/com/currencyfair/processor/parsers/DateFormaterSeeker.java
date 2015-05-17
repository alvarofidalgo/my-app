package com.currencyfair.processor.parsers;

import java.util.List;
import java.util.Locale;

import static com.currencyfair.processor.parsers.ParserConstants.BAD_DATE_FORMAT;

public class DateFormaterSeeker {
		
	private List<DateFormatInformation> _dateFormats ;
	
	public DateFormaterSeeker(List<DateFormatInformation> dateFormats){
		_dateFormats = dateFormats;
	}

	public LocaleFormatter matchPatter(String dateString) {
		LocaleFormatter localeFormater = new LocaleFormatter(BAD_DATE_FORMAT,Locale.ROOT);
        for (DateFormatInformation dateFormatInformation :_dateFormats){
        	if (dateString.matches(dateFormatInformation.getRegularExpresion()))
        		localeFormater = dateFormatInformation.getLocaleFormater();
        }
		return localeFormater;
	}

}
