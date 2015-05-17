package com.currencyfair.consumption.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.currencyfair.entitys.TransactionData;
import com.currencyfair.model.ResumeTransaction;
import com.currencyfair.processor.BeforeProcess;
import com.currencyfair.processor.Service;


@RestController
public class TransactionController {
	
	@Autowired private Service transactionService;
	@Autowired  private BeforeProcess errorProcess;
	
	@RequestMapping(value="/transactions/insertTransaction",
			        method=RequestMethod.POST,
			        produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
			        consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}
			       )	
	public @ResponseBody List<ResumeTransaction> saveTransactionAndReturnResume(@RequestBody TransactionData transactionData){
		return transactionService.process(transactionData);
	}
	
	@RequestMapping(value="/transactions/errors")
	public @ResponseBody List<String> getErrorsInTransactionData(@ModelAttribute("TransactionData") TransactionData transactionData){

		return errorProcess.processTransaction(transactionData);
	}
	

}
