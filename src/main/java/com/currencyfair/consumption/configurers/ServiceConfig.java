package com.currencyfair.consumption.configurers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.currencyfair.processor.AfterProcess;
import com.currencyfair.processor.BeforeProcess;
import com.currencyfair.processor.ErrorsProcess;
import com.currencyfair.processor.ResumeTransactionsProcess;
import com.currencyfair.processor.TransactionService;
import com.currencyfair.processor.configurers.DateFormatSeekerConfigurer;
import com.currencyfair.processor.parsers.StringToCalendar;
import com.currencyfair.processor.Service;

@Configuration
public class ServiceConfig {
	
	
	@Bean Service getTransactionProcess(){
		BeforeProcess beforeProcess = getErrorProcess();
		AfterProcess afterProcess = new ResumeTransactionsProcess(new StringToCalendar(                                                                       new DateFormatSeekerConfigurer().defaultConfigurer()));
		return new TransactionService(beforeProcess,afterProcess);
	}
	
	@Bean BeforeProcess getErrorProcess(){
		return new ErrorsProcess();
	}
}
