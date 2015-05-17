package com.currencyfair.model;

import java.util.Calendar;

public class ResumeTransaction {
		
	
	private String _currencyFrom,_currencyTo;
	private Calendar _date;
	
	public ResumeTransaction(String currencyFrom,
			                 String currencyTo,
			                 Calendar date){
		_currencyFrom = currencyFrom;
		_currencyTo = currencyTo;
		_date = date;
		
		
	}

	public String getOtherFormatDate() {
		return _date.get(Calendar.DAY_OF_MONTH)+"-"+
	           _date.get(Calendar.HOUR)+":"+
			   _date.get(Calendar.MINUTE)+":"+
	           _date.get(Calendar.SECOND);
	}

	public String getCurrencyFrom() {
		return _currencyFrom;
	}

	public String getCurrencyTo() {
		return _currencyTo;
	}
	
	
	

}
