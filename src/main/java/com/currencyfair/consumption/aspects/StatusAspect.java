package com.currencyfair.consumption.aspects;

import java.net.HttpURLConnection;


import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;

import com.currencyfair.entitys.TransactionData;
import com.currencyfair.processor.BeforeProcess;

@Aspect
public class StatusAspect {

	@Autowired private HttpServletResponse responseInScopeFilter;
	@Autowired private BeforeProcess errorProcess;
	
	@Around(value="execution(* com.currencyfair.consumption.controllers.*.saveTransactionAndReturnResume(..))")
	public Object changeStatus(ProceedingJoinPoint proceddJoinPointCut) throws Throwable {
		
		TransactionData trasanctionData =(TransactionData)proceddJoinPointCut.getArgs()[0];
		if (!errorProcess.processTransaction(trasanctionData).isEmpty())
			responseInScopeFilter.setStatus(HttpURLConnection.HTTP_NOT_MODIFIED);
		return  proceddJoinPointCut.proceed();
	}
	
}
