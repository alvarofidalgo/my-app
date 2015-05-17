package com.currencyfair.processor;

import java.util.List;

import com.currencyfair.entitys.TransactionData;

public interface BeforeProcess {

	List<String> processTransaction(TransactionData transactionData);

}