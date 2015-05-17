package com.currencyfair.processor;

import java.util.List;

import com.currencyfair.entitys.TransactionData;
import com.currencyfair.model.ResumeTransaction;

public interface Service {

	List<ResumeTransaction>  process(TransactionData transaction);

}