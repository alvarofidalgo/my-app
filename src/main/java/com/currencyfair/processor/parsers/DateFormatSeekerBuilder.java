package com.currencyfair.processor.parsers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class DateFormatSeekerBuilder {
	
	private List<DateFormatInformation> _dateFormats = new ArrayList<DateFormatInformation>();
	
	public DateFormatSeekerBuilder add(String regularExpresion, String formater,Locale local){
		_dateFormats.add(new DateFormatInformation(regularExpresion,formater,local));
		return this;
	}
	
	public DateFormaterSeeker build(){
		return new DateFormaterSeeker(_dateFormats);
	}

}
