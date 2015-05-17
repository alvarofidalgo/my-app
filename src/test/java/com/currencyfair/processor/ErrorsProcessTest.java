package com.currencyfair.processor;

import static org.junit.Assert.*;
import static com.currencyfair.utilTest.TransactionDataCreators.createCorrectTransction;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.currencyfair.doubles.TransactionDataGatewayDouble;
import com.currencyfair.entitys.TransactionData;
import com.currencyfair.gateways.Context;
import com.currencyfair.processor.constants.ErrorConstants;

public class ErrorsProcessTest {
	
	private BeforeProcess _process;

	@Before public void setUp(){
		_process =new ErrorsProcess();
		Context.transactionGateway = new TransactionDataGatewayDouble();
	}
	
	@Test public void whenAllFieldsArefilled(){
		List<String> errors = _process.processTransaction(createCorrectTransction("anyUser"));
		assertEquals(errors.size(),0);
	}
		
	@Test public void whenNoFilledAnyField(){
		
		
		List<String> errors = _process.processTransaction(new TransactionData());
		assertEquals(errors.size(),9);
		assertEquals(errors.get(0),ErrorConstants.ERROR_USER_ID_EMPTY);	
		assertEquals(errors.get(1),ErrorConstants.ERROR_CURRENCY_FROM_IS_EMPTY);
		assertEquals(errors.get(2),ErrorConstants.ERROR_CURRENCY_TO_IS_EMPTY);
		assertEquals(errors.get(3),ErrorConstants.ERROR_AMOUNT_SELL_IS_EMPTY);
		assertEquals(errors.get(4),ErrorConstants.ERROR_AMOUNT_BUY_IS_EMPTY);
		assertEquals(errors.get(5),ErrorConstants.ERROR_RATE_IS_EMPTY);
		assertEquals(errors.get(6),ErrorConstants.ERROR_TIMEPLACED_IS_EMPTY);
		assertEquals(errors.get(7),ErrorConstants.ERROR_ORIGIN_COUNTRY_IS_EMPTY);
		assertEquals(errors.get(8),ErrorConstants.ERROR_DATE_FORMAT);
	}
	


}
