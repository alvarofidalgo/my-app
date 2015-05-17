package com.currencyfair.processor;

import static org.junit.Assert.*;
import static com.currencyfair.utilTest.TransactionDataCreators.createCorrectTransction;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.currencyfair.doubles.TransactionDataGatewayDouble;
import com.currencyfair.entitys.TransactionData;
import com.currencyfair.gateways.Context;
import com.currencyfair.model.ResumeTransaction;
import com.currencyfair.processor.configurers.DateFormatSeekerConfigurer;
import com.currencyfair.processor.parsers.StringToCalendar;


public final class TransactionServiceTest {
		
	private Service _service;
	private String _userId ="firstId";
	
	@Before public void setUp(){

		Context.transactionGateway = new TransactionDataGatewayDouble();
		Context.transactionGateway.save(createCorrectTransction(_userId));
		BeforeProcess beforeProcess = new ErrorsProcess();
		AfterProcess afterProcess = new ResumeTransactionsProcess(new StringToCalendar(
                                                                       new DateFormatSeekerConfigurer().defaultConfigurer()));
		_service = new TransactionService(beforeProcess,afterProcess);
	}
	
	
	@Test public void whenNoCallProcessor(){
		assertEquals(Context.transactionGateway.getTransactionsBy(_userId).size(),1);
	}
		
	@Test public void whenAllDataTransactionFieldsFilled(){	
		List<ResumeTransaction> transactions = _service.process(createCorrectTransction(_userId));
		assertEquals(Context.transactionGateway.getTransactionsBy(_userId).size(),2);
		assertEquals(transactions.size(),2);
	}
	
	@Test public void whenAllDataTransactionFieldsNotFilled(){
		List<ResumeTransaction> transactions = _service.process(new TransactionData());
		assertEquals(Context.transactionGateway.getTransactionsBy(_userId).size(),1);
		assertEquals(transactions.size(),0);
	}
}
