package com.currencyfair.doubles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.currencyfair.entitys.TransactionData;
import com.currencyfair.gateways.TransactionGateway;

public class TransactionDataGatewayDouble implements TransactionGateway {
	
	private Map<String,List <TransactionData> > _dataTrasactions = new HashMap<String,List <TransactionData>>();
	
	public void save(TransactionData transactionData){
		String userId = transactionData.getUserId();
		createListInIdUserIfNotExist(userId);
		List <TransactionData> transactionsByUserId = _dataTrasactions.get(userId);
		transactionsByUserId.add(transactionData);
	}
	
	private void createListInIdUserIfNotExist(String userId){
	
		if (_dataTrasactions.get(userId)==null)
			_dataTrasactions.put(userId, new ArrayList<TransactionData>());
	}
	
	public List <TransactionData> getTransactionsBy(String userId){
		List <TransactionData> transactionsByUserId = _dataTrasactions.get(userId);
		List <TransactionData> cloneTransactionsDataByUserId = new ArrayList<TransactionData>();
		for (int index=0;
				   transactionsByUserId!=null&&index<transactionsByUserId.size();
				                                                           index++){
			cloneTransactionsDataByUserId.add(cloneTransaction(transactionsByUserId.get(index)));
		}
		return cloneTransactionsDataByUserId;
	}
	
	private TransactionData cloneTransaction(TransactionData transaction){
		TransactionData transactionData = new TransactionData();
		transactionData.setUserId(transaction.getUserId()) ;
		transactionData.setCurrencyFrom(transaction.getCurrencyFrom());
		transactionData.setCurrencyTo(transaction.getCurrencyTo());
		transactionData.setAmountSell(transaction.getAmountSell());
		transactionData.setAmountBuy(transaction.getAmountBuy());
		transactionData.setRate(transaction.getRate());
		transactionData.setTimePlaced(transaction.getTimePlaced());
		transactionData.setOriginatingCountry(transaction.getOriginatingCountry());
		return transactionData;
	}

}
