package com.currencyfair.processor;

import java.util.ArrayList;
import java.util.List;

import com.currencyfair.entitys.TransactionData;
import com.currencyfair.model.ResumeTransaction;
import com.currencyfair.processor.parsers.StringToCalendar;

public class ResumeTransactionsProcess implements AfterProcess {
	
	private StringToCalendar _parser ;
	
	public ResumeTransactionsProcess(StringToCalendar parser){
		_parser = parser;
	}
	

	public List<ResumeTransaction>  transform(List<TransactionData> transactions) {
	
		List<ResumeTransaction> resumeTransactions = new ArrayList<ResumeTransaction>();
		for (TransactionData transactionData:transactions)
			resumeTransactions.add(new ResumeTransaction(transactionData.getCurrencyFrom(),
					                                    transactionData.getCurrencyTo(),
					                                    _parser.parse(transactionData.getTimePlaced())));
		return resumeTransactions;
	}

}
