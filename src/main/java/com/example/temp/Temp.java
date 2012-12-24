package com.example.temp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Temp {
	
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		TimeZone tz = TimeZone.getTimeZone("GMT");
		sdf.setTimeZone(tz);
		String string = "abc";
		System.out.println(string.equals(string));
	}
	
}
