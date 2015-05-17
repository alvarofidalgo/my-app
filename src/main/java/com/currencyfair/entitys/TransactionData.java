package com.currencyfair.entitys;

import static com.currencyfair.processor.validators.ValidatorConstants.EMPTY_DOUBLE_FIELD_VALUE;
import static com.currencyfair.processor.validators.ValidatorConstants.EMPTY_STRING_FIELD_VALUE;

public class TransactionData {
	
	
	private String _userId=EMPTY_STRING_FIELD_VALUE; 
	private String _currencyFrom=EMPTY_STRING_FIELD_VALUE; 
	private String _currencyTo=EMPTY_STRING_FIELD_VALUE; 
	private Double _amountSell=EMPTY_DOUBLE_FIELD_VALUE; 
	private Double _amountBuy=EMPTY_DOUBLE_FIELD_VALUE;
	private Double _rate=EMPTY_DOUBLE_FIELD_VALUE;
	private String _timePlaced=EMPTY_STRING_FIELD_VALUE;
	private String _originatingCountry=EMPTY_STRING_FIELD_VALUE;
	
	  
	public String getUserId() {
		return _userId;
	}
	
	public void setUserId(String userId) {
		_userId = userId;
	}
	
	public String getCurrencyFrom() {
		return _currencyFrom;
	}
	
	public void setCurrencyFrom(String currencyFrom) {
		_currencyFrom = currencyFrom;
	}
	
	public String getCurrencyTo() {
		return _currencyTo;
	}
	
	public void setCurrencyTo(String currencyTo) {
		_currencyTo = currencyTo;
	}
	
	public Double getAmountSell() {
		return _amountSell;
	}
	
	public void setAmountSell(Double amountSell) {
		if (amountSell!=null)
		  _amountSell = amountSell;
	}
	
	public Double getAmountBuy() {
		return _amountBuy;
	}
	
	public void setAmountBuy(Double amountBuy) {
		if (amountBuy!=null)
		   _amountBuy = amountBuy;
	}
	
	public Double getRate() {

		return _rate;
	}
	
	public void setRate(Double rate) {
		if (rate!=null)
		   _rate = rate;
	}
	
	public String getTimePlaced() {
		return _timePlaced;
	}
	
	public void setTimePlaced(String timePlaced) {
		_timePlaced = timePlaced;
	}
	
	public String getOriginatingCountry() {
		return _originatingCountry;
	}
	
	public void setOriginatingCountry(String originatingCountry) {
		_originatingCountry = originatingCountry;
	}
}
