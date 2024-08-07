package org.bitcprac.boot04.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtil {
	//sql날짜 => 문자열날짜
	public static String convertDateToString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	//문자열날짜 => sql날짜
	public static Date convertStringToDate(String dateString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date utilDate = sdf.parse(dateString);
		return new Date(utilDate.getTime());
	}

	public static String getCurrentMonthStartDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate today = LocalDate.now();
		return today.withDayOfMonth(1).format(dtf);
	}

	public static String getCurrentMonthDate(){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate today = LocalDate.now();
		return today.format(dtf);
	}
}
