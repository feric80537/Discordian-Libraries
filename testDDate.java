package com.wilsonrowe.ddate;

import com.wilsonrowe.ddate.DDate;

public class testDDate {
	public static void main(String[] args) {
		DDate today = new DDate(2011, 9, 12);
		String outLine = "Today is " + DDate.DAY_NAME[today.getWday()]
				+ ", the " + today.getDay() + " day of ";
		outLine += DDate.SEASON_NAME[today.getSeason()] + " in the YOLD "
				+ today.getYear();
		System.out.println(outLine);
		today.setgDay(13); // Go to tomorrow
		outLine = "Today is " + DDate.DAY_NAME[today.getWday()] + ", the "
				+ today.getDay() + " day of ";
		outLine += DDate.SEASON_NAME[today.getSeason()] + " in the YOLD "
				+ today.getYear();
		System.out.println(outLine);
		//
		//
		DDate e = new DDate();
		outLine = "Today is " + DDate.DAY_NAME[e.getWday()] + ", the "
				+ e.getDay() + " day of ";
		outLine += DDate.SEASON_NAME[e.getSeason()] + " in the YOLD "
				+ e.getYear();
		System.out.println("Eric's BD:" + outLine);
	}
}

