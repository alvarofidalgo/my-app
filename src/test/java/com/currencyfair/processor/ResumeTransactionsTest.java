package com.currencyfair.processor;

import static org.junit.Assert.*;
import static com.currencyfair.utilTest.TransactionDataCreators.createCorrectTransction;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.currencyfair.doubles.TransactionDataGatewayDouble;
import com.currencyfair.gateways.Context;
import com.currencyfair.model.ResumeTransaction;
import com.currencyfair.processor.configurers.DateFormatSeekerConfigurer;
import com.currencyfair.processor.parsers.StringToCalendar;

public class ResumeTransactionsTest {
	
	private AfterProcess _process;

	private String _anyCurrencyFrom="anyCurrencyFrom",_anyCurrencyTo="anyCurrencyTo", _anyUserId = "AnyUser";;
	
	@Before public void setUp(){
		
		Context.transactionGateway = new TransactionDataGatewayDouble();
		Context.transactionGateway.save(createCorrectTransction("OtherUser",_anyCurrencyFrom+"1",
				                                               _anyCurrencyTo+"1" ));
		_process =  new ResumeTransactionsProcess(new StringToCalendar(
				                                              new DateFormatSeekerConfigurer().defaultConfigurer()));
	}
	
	
	@Test public void whenNoExistTransactionForIdUser(){
		

		List<ResumeTransaction> resumeTransactions =_process.transform(
				                                              Context.transactionGateway.getTransactionsBy(_anyUserId));
	    assertEquals(resumeTransactions.size(),0);
	}
	
	@Test public void whenExisteTrasactionForIdUser(){
		Context.transactionGateway.save(createCorrectTransction(_anyUserId,_anyCurrencyFrom,_anyCurrencyTo));
		List<ResumeTransaction> resumeTransactions =_process.transform(
                                                        Context.transactionGateway.getTransactionsBy(_anyUserId));
		assertEquals(resumeTransactions.size(),1);
		ResumeTransaction resumeTransction = resumeTransactions.get(0);
		assertEquals(resumeTransction.getCurrencyFrom(),_anyCurrencyFrom);
		assertEquals(resumeTransction.getCurrencyTo(),_anyCurrencyTo);
		assertEquals(resumeTransction.getOtherFormatDate(),"24-10:27:44");
		
	}
}
