package com.currencyfair.processor.parsers;

import java.util.Locale;

public class DateFormatInformation {
	
	private String _regularExpresion;
	private LocaleFormatter _localeFormater ;
	
	public DateFormatInformation(String regularExpresion, String formater,Locale local){
		_regularExpresion = regularExpresion;
		_localeFormater= new LocaleFormatter(formater,local);
	}
	
	public LocaleFormatter getLocaleFormater(){
		return _localeFormater;
	}
	
	public String getRegularExpresion(){
		return _regularExpresion;
	}

}
