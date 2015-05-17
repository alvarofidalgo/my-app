package com.currencyfair.processor.parsers;

import java.util.Locale;

public class LocaleFormatter {
	
	private String _formatter;
	private Locale _locale;
	
	public LocaleFormatter (String formatter,Locale locale){
		_formatter = formatter;
		_locale = locale;
	}
	
	public String getFormater(){
		return _formatter;
	}
	
	public Locale getLocale(){
		return _locale;
	}

}
