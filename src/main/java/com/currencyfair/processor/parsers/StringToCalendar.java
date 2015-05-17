package com.currencyfair.processor.parsers;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.currencyfair.processor.constants.ErrorConstants;

public class StringToCalendar {
		
	private DateFormaterSeeker _dateFormatSeeker;
	
	public StringToCalendar(DateFormaterSeeker dateFormatSeeker){
		_dateFormatSeeker = dateFormatSeeker;
	}
	
	public Calendar parse(String stringDate) {
		return createCalendarWithFormaterAndDate(_dateFormatSeeker.matchPatter(stringDate),
				                                 stringDate );
	}
	
	private Calendar createCalendarWithFormaterAndDate(LocaleFormatter localeFormater,String stringDate) {
		try{
			DateFormat format =  new SimpleDateFormat( localeFormater.getFormater(),localeFormater.getLocale()); 
			Calendar   calendar = new GregorianCalendar();
			calendar.setTime( format.parse( stringDate.toLowerCase()) );
			return calendar;
		}catch(ParseException e){
			System.out.println(ErrorConstants.ERROR_DATA_FORMAT_NOT_MAPPED+stringDate);
			throw new RuntimeException(e);
		}
	}

}
