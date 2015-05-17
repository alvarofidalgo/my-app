package com.currencyfair.processor;

import java.util.List;
import com.currencyfair.entitys.TransactionData;
import com.currencyfair.gateways.Context;
import com.currencyfair.gateways.TransactionGateway;
import com.currencyfair.model.ResumeTransaction;


public final class TransactionService implements Service {
	
	private BeforeProcess _beforeProcess;
	private AfterProcess _afterProcess;
	private TransactionGateway _gateway = Context.transactionGateway;
	
	public TransactionService(BeforeProcess beforeProcess,AfterProcess afterProcess) {
		_afterProcess = afterProcess;
		_beforeProcess = beforeProcess;
	}

	public List<ResumeTransaction> process(TransactionData transaction) {
	    if (_beforeProcess.processTransaction(transaction).isEmpty())
		      _gateway.save(transaction);
		return _afterProcess.transform(_gateway.getTransactionsBy(transaction.getUserId()));
	}
}
