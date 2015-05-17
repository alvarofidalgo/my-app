package com.currencyfair.consumption;

import org.apache.http.HttpStatus;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.when;
import static com.jayway.restassured.RestAssured.given;


import  com.currencyfair.consumption.Application;
import com.currencyfair.utilTest.RequestBodyStub;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;

public class ApplicationTest {
	
	private Gson _gson ;
	private RequestBodyStub _stub;

	
	@Before public void setUp(){
		_stub =new RequestBodyStub();
    	_gson = new GsonBuilder().create();
    	RestAssured.port=8080;
    	Application.main(new String[]{});
	}
	
     
    @After public void shutDown(){
    	Application.stop();
    }
	 
	@Test public void whenStartServerAndRequestIsCorrect(){
    	
		 String json =_gson.toJson(_stub);	
		 given().contentType(ContentType.JSON)
		               .body(json)
		                  .when()
		                     .post("/transactions/insertTransaction")
		                         .then()
		                            .statusCode(HttpStatus.SC_OK);		
	}
	
	@Test public void whenStartServerAndRequestIsNoCorrect(){
		_stub.userId ="";
		 String json =_gson.toJson(_stub);	
		 given().contentType(ContentType.JSON)
		               .body(json)
		                  .when()
		                     .post("/transactions/insertTransaction")
		                         .then()
		                            .statusCode(HttpStatus.SC_NOT_MODIFIED);
		                           
	}
	
	@Test public void whenStartServerAndReceivedFirstPetition(){
		when().get("/index")
		   .then().statusCode(HttpStatus.SC_OK);		
	}

}
