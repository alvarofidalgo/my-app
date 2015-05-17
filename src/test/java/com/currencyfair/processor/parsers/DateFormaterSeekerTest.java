package com.currencyfair.processor.parsers;

import static org.junit.Assert.*;
import static com.currencyfair.processor.parsers.ParserConstants.BAD_DATE_FORMAT;

import org.junit.Before;
import org.junit.Test;

import com.currencyfair.processor.configurers.DateFormatSeekerConfigurer;
import com.currencyfair.processor.constants.FormatDateConstants;
import com.currencyfair.processor.parsers.DateFormaterSeeker;

public class DateFormaterSeekerTest {
	
	private DateFormaterSeeker _seeker;
	
	@Before public void setUp(){		
		_seeker  = new DateFormatSeekerConfigurer().defaultConfigurer();
	}
		
	@Test public void whenSeekAnExistPattern(){		
		String dateString="01-JAN-09 00:00:59";
		assertEquals(_seeker.matchPatter(dateString).getFormater(),FormatDateConstants.STANDARD_FORMAT);
	}
	
	@Test public void whenSeekAnNotExistPeternResultShouldBeEmptyFormatter(){
		String dateString="NOT_DATE";
		assertEquals(_seeker.matchPatter(dateString).getFormater(),BAD_DATE_FORMAT);
	}
	
	
	

}
