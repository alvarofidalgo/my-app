package com.currencyfair.utilTest;

import org.mockito.Mockito;
import com.currencyfair.entitys.TransactionData;

public class TransactionDataCreators {
	
	private static final Double CORRECT_DOUBLE_FIELD_VALUEDouble = new Double(1.0);
	
	static public TransactionData createCorrectTransction(String idUser){
		TransactionData transactionData = Mockito.mock(TransactionData.class);
		Mockito.when(transactionData.getUserId()).thenReturn(idUser);
		Mockito.when(transactionData.getCurrencyFrom()).thenReturn("anyCurrencyFrom");
		Mockito.when(transactionData.getCurrencyTo()).thenReturn("anyCurrencyTo");
		fillCommonsValues(transactionData);
		return transactionData;
	}
	
	static public TransactionData createCorrectTransction(String idUser,
			                                        String anyCurrentFrom,
                                                    String anyCurrencyTo){
		TransactionData transactionData = Mockito.mock(TransactionData.class);
		Mockito.when(transactionData.getUserId()).thenReturn(idUser);
		Mockito.when(transactionData.getCurrencyFrom()).thenReturn(anyCurrentFrom);
		Mockito.when(transactionData.getCurrencyTo()).thenReturn(anyCurrencyTo);
		fillCommonsValues(transactionData);
		return transactionData;
    }
	
	private static void fillCommonsValues(TransactionData transactionData){
		Mockito.when(transactionData.getAmountSell()).thenReturn(CORRECT_DOUBLE_FIELD_VALUEDouble);
		Mockito.when(transactionData.getAmountBuy()).thenReturn(CORRECT_DOUBLE_FIELD_VALUEDouble);
		Mockito.when(transactionData.getRate()).thenReturn(CORRECT_DOUBLE_FIELD_VALUEDouble);
		Mockito.when(transactionData.getTimePlaced()).thenReturn("24-JAN-15 10:27:44");
		Mockito.when(transactionData.getOriginatingCountry()).thenReturn("anyOrigin");
	}
	
}
