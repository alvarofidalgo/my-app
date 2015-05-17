package com.currencyfair.consumption.controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.currencyfair.consumption.configurers.AspectsConfig;
import com.currencyfair.consumption.configurers.RestServiceConfig;
import com.currencyfair.consumption.configurers.ServiceConfig;
import com.currencyfair.doubles.TransactionDataGatewayDouble;
import com.currencyfair.gateways.Context;
import com.currencyfair.processor.constants.ErrorConstants;
import com.currencyfair.utilTest.RequestBodyStub;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestServiceConfig.class,ServiceConfig.class ,AspectsConfig.class})
@WebAppConfiguration
public class TransactionControllerTest {
	
	private MockMvc _mockMvc;
	private RequestBodyStub _stub;
	private Gson _gson ;
	
    @Autowired private WebApplicationContext aplicationContext; 
   
    @Before public void setUp(){
    	Context.transactionGateway = new TransactionDataGatewayDouble();
    	_mockMvc = MockMvcBuilders.webAppContextSetup(this.aplicationContext).build();
    	_stub =new RequestBodyStub();
    	_gson = new GsonBuilder().create();
    }
	
	@Test public void whenNoExisErrorInPostMessageThenInsertTransacctionAndBuildResumeTransaction() throws Exception{
        String json =_gson.toJson(_stub);		

        _mockMvc.perform(post("/transactions/insertTransaction")
				        .contentType(MediaType.APPLICATION_JSON)
				        .content(json))
				  .andExpect(status().isOk())
                  .andExpect(jsonPath("$", hasSize(1)))
                  .andExpect(jsonPath("$[0]['currencyFrom']",is("anyCurrency"))) 
                  .andExpect(jsonPath("$[0]['currencyTo']",is("anyCurrency"))) 
                  .andExpect(jsonPath("$[0]['otherFormatDate']",is("24-10:27:44"))); 
	}
	

	@Test public void whenExistErrorsInPostMessageThenNoInsertTransactionAndBuildErrorsInMessage() throws Exception{
		_stub.userId="";
        String json =_gson.toJson(_stub);		
        _mockMvc.perform(post("/transactions/insertTransaction")
				        .contentType(MediaType.APPLICATION_JSON)
				        .content(json))

				  .andExpect(status().isNotModified());            
	}
	
	@Test public void whenExistErrorsIntransactionDataTheCanRecovery() throws Exception{
		_stub.userId="";
		 _mockMvc.perform(get("/transactions/errors")
			        .param("userId", "")
			        .param("currencyFrom", "anyCurrency")
			        .param("currencyTo", "anyCurrency")
			        .param("amountSell", "1.0")
			        .param("amountBuy", "1.0")
			        .param("rate", "1.0")
			        .param("timePlaced", "24-JAN-15 10:27:44")
			        .param("originatingCountry", "valid"))
			        .andExpect(jsonPath("$", hasSize(1)))
			        .andExpect(jsonPath("$[0]",is(ErrorConstants.ERROR_USER_ID_EMPTY)));
	}
	
	@Test public void whenNoExistErrorsIntransactionErrorsWasEmpty() throws Exception{
		_stub.userId="";
		 _mockMvc.perform(get("/transactions/errors")
			        .param("userId", "anyUser")
			        .param("currencyFrom", "anyCurrency")
			        .param("currencyTo", "anyCurrency")
			        .param("amountSell", "1.0")
			        .param("amountBuy", "1.0")
			        .param("rate", "1.0")
			        .param("timePlaced", "24-JAN-15 10:27:44")
			        .param("originatingCountry", "valid"))
			        .andExpect(jsonPath("$", hasSize(0)));
			        
	}
}