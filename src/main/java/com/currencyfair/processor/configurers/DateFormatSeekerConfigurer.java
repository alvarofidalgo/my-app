package com.currencyfair.processor.configurers;

import java.util.Locale;

import com.currencyfair.processor.constants.FormatDateConstants;
import com.currencyfair.processor.constants.RegexConstants;
import com.currencyfair.processor.parsers.DateFormatSeekerBuilder;
import com.currencyfair.processor.parsers.DateFormaterSeeker;

public class DateFormatSeekerConfigurer {

	public DateFormaterSeeker defaultConfigurer(){
		 return new DateFormatSeekerBuilder()
		               .add(RegexConstants.REGEX_DATE_PLACE_EN,FormatDateConstants.STANDARD_FORMAT,Locale.ENGLISH)
				       .add(RegexConstants.REGEX_DATE_PLACE_ES,FormatDateConstants.STANDARD_FORMAT,new Locale("ES"))
				       .build();
	}
}
