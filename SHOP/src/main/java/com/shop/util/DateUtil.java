package com.shop.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	public static final String PRIMARY_DATE_FORMAT = "yyyy-MM-dd";
	public static final String PRIMARY_DATE_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
	
	//현재 날짜를 문자열로 가져오기
	public static String getNowDateToString() {
		Calendar cal = Calendar.getInstance();
		//현재 날짜 및 시간
		Date date = cal.getTime();//20210331164850
		
		//날짜의 포캣(형식)을 지정하는 클래스
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String nowDate = format.format(date);//2021-03-31
		
		return nowDate;
	}
	
	//현재 날짜를 문자열로 가져오기(포맷지정가능)
	public static String getNowDateToString(String dateFormat) {
		Calendar cal = Calendar.getInstance();
		//현재 날짜 및 시간
		Date date = cal.getTime();//20210331164850
		
		//날짜의 포캣(형식)을 지정하는 클래스
		SimpleDateFormat format = new SimpleDateFormat(dateFormat);
		String nowDate = format.format(date);//2021-03-31
		
		return nowDate;
	}
	
	//현재 날짜및 시간을 문자열로 가져오기
	public static String getNowDateTimeToString() {
		Calendar cal = Calendar.getInstance();
		//현재 날짜 및 시간
		Date date = cal.getTime();//20210331164850
		
		//날짜의 포캣(형식)을 지정하는 클래스
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowDate = format.format(date);//2021-03-31
		
		return nowDate;
	}
	
	//현재 날짜 및 시간을 문자열로 가져오기(포맷지정가능)
	public static String getNowDateTimeToString(String dateForamt) {
		Calendar cal = Calendar.getInstance();
		//현재 날짜 및 시간
		Date date = cal.getTime();//20210331164850
		
		//날짜의 포캣(형식)을 지정하는 클래스
		SimpleDateFormat format = new SimpleDateFormat(dateForamt);
		String nowDate = format.format(date);//2021-03-31
		
		return nowDate;
	}
	
	//현재 달의 1일을 문자열로 리턴하는 메소드
	public static String getNowDateFirstDayToString() {
		Calendar cal = Calendar.getInstance();
		//현재 날짜 및 시간
		Date date = cal.getTime();//20210331164850
		
		//날짜의 포캣(형식)을 지정하는 클래스
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");
		String nowDate = format.format(date);//2021-03
		nowDate = nowDate + "-01";
		
		return nowDate;
	}

	
}













