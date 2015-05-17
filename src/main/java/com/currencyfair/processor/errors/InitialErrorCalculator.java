package com.currencyfair.processor.errors;


import java.util.ArrayList;
import java.util.List;

import com.currencyfair.entitys.TransactionData;

public class InitialErrorCalculator implements ErrorCalculator {

	
	public List<String> calculateError(TransactionData transaction) {
	
		return new ArrayList<String>();
	}

}
