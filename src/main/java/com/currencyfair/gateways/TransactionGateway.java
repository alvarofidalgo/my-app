package com.currencyfair.gateways;

import java.util.List;

import com.currencyfair.entitys.TransactionData;

public interface TransactionGateway {
	
	public abstract void save(TransactionData transactionData);
	public abstract List <TransactionData> getTransactionsBy(String idUser);
	
}