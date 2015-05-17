package com.currencyfair.processor.parsers;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Calendar;






import org.junit.Before;
import org.junit.Test;

import com.currencyfair.processor.configurers.DateFormatSeekerConfigurer;
import com.currencyfair.processor.parsers.StringToCalendar;

public class StringToCalendarTest {
	
	private StringToCalendar _parser;
	
	@Before public void setUp(){
		_parser = new StringToCalendar( new DateFormatSeekerConfigurer().defaultConfigurer());
	}
	
	@Test public void insertValidDate() throws ParseException{
 
		Calendar calendar = _parser.parse("24-JAN-15 00:00:59");
		assertEquals(calendar.get(Calendar.DAY_OF_MONTH),24);
		assertEquals(calendar.get(Calendar.MONTH),0);
		assertEquals(calendar.get(Calendar.YEAR),2015);		
	}
	
	@Test public void insertInvalidDate() throws ParseException{
		try{
			_parser.parse("78-0000");
			fail();
		}catch(RuntimeException e){
			
		}
		
	}

}
