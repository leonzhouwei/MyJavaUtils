package com.example.temp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SdfTest {
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String sdfString = sdf.format(date);
		System.out.println("date is: " + sdfString);
	}
}
