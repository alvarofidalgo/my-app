package com.currencyfair.processor.constants;

public final class RegexConstants {
	
	private  static final String REGEX_00_31 ="(0[1-9]|1[0-9]|2[0-9]|3[0-1])";
	private  static final String REGEX_00_59 ="(0[0-9]|1[0-9]|2[0-9]|3[0-9]|4[0-9]|5[0-9])";
	private  static final String REGEX_00_99="[0-9][0-9]";
	private  static final String REGEX_00_23="(0[0-9]|1[0-9]|2[0-3])";
	private  static final String REGEX_MONTHS_EN ="(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DIC)";
	private  static final String REGEX_MONTHS_ES ="(ENE|FEB|MAR|ABR|MAY|JUN|JUL|AGO|SEP|OCT|NOV|DIC)";
	
	public static final String REGEX_DATE_PLACE_EN =REGEX_00_31+"-"+
					           REGEX_MONTHS_EN+"-"+
					           REGEX_00_99+" "+
					           REGEX_00_23+":"+
					           REGEX_00_59+":"+
					           REGEX_00_59;
	
	public static final String REGEX_DATE_PLACE_ES =REGEX_00_31+"-"+
			                   REGEX_MONTHS_ES+"-"+
					           REGEX_00_99+" "+
					           REGEX_00_23+":"+
					           REGEX_00_59+":"+
					           REGEX_00_59;
}
