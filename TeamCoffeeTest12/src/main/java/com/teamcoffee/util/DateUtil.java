package com.teamcoffee.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
	public static final String PRIMARY_DATE_FORMAT = "yyyy-MM-dd";
	
	public static String getNowDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-");
		Calendar cal = Calendar.getInstance();
		String nowDate = sdf.format(cal.getTime());
		nowDate += cal.get(Calendar.DATE);
		
		return nowDate;
	}
	
	public static String getFirstDate(String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Calendar cal = Calendar.getInstance();
		String firstDate = sdf.format(cal.getTime());
		firstDate += "01";
		
		return firstDate;
	}
	
	//오늘 날짜
	public static String getNowDate(String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		Calendar cal = Calendar.getInstance();
		String nowDate = sdf.format(cal.getTime());
		
		return nowDate;
	}
	
	//날짜 + 시간
	public static String getNowDateTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");
		Calendar cal = Calendar.getInstance();
		String nowDate = sdf.format(cal.getTime());
		
		return nowDate;
	}
	
}
