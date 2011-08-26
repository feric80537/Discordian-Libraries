package com.wilsonrowe.ddate;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DDate {
	public static String[] SEASON_NAME =  {"error","Chaos","Discord","Confusion","Bureaucracy","The Aftermath"};
	public static String[] SEASON_ABB = {"er","Ch","Dd","Gr","St","Ta"};
	public static String[] DAY_NAME = {"St. Tib's Day","Sweeetmorn","Boomtime","Pungenday","Prickle-Prickle","Setting Orange"};
	private static String[][] HOLYDAY = {{"Mungoday","Chaoflux"},{"Mojoday","Discoflux"},{"Syaday","Confuflux"},{"Zaraday","Bureflux"},{"Maladay","Afflux"}};
	private int DAYS_PER_SEASON = 73;
	private int DAYS_PER_WEEK = 5;
	private int SEASONS_PER_YEAR = 5;
	private boolean recalculate;
	private int gDay;
	private int gMonth;
	private int gYday; // day of the year 1-366
	private String holyDay;
	private int gYear;
	// Discordian dates
	private int dDay;
	private int dSeason;
	private int dYear;
	private int dWday; // Day of week
	public boolean isLeap(int y){
		return(y % 4 == 0 && (y % 100 != 0 || y % 400 == 0));
	}
	
	public String getHolyDay(){
		if(recalculate) calculateDates();
		return holyDay;
	}
	public int getSeason(){
		if(recalculate) calculateDates();
		return this.dSeason;
	}
	public int getDay(){
		if(recalculate) calculateDates();
		return dDay;
	}
	public int getYear(){
		if(recalculate) calculateDates();
		return dYear;
	}
	public int getWday(){
		if(recalculate) calculateDates();
		return dWday;
	}
	public void setgYear(int year){
		gYear = year;
		recalculate = true;
	}
	
	public void setgDay(int dayG){
		gDay = dayG;
		recalculate = true;
	}
	public void setMonth(int monthG){
		gMonth = monthG;
		recalculate = true;
	}
	private void calculateDates(){
		// Leap Year Calculations
		GregorianCalendar gCal = new GregorianCalendar();
	gCal.set(gYear, gMonth - 1, gDay);
		gYday = gCal.get(Calendar.DAY_OF_YEAR);
		System.out.println("gDay:" + gDay + " gMonth: " + gMonth + " gYear" + gYear + " gYday: " + gYday);
		if(isLeap(gYear)){
			if(gYday >= 61){
				gYday = gYday - 1;
			} else if(gYday == 60){
				holyDay = "St. Tib's Day";
			}
		}
		dSeason = (gYday / DAYS_PER_SEASON) + 1;
		
		dDay = gYday % DAYS_PER_SEASON;
		System.out.println("day: " + dDay + " gYday: " + gYday	);
		dYear = 1166 + gYear;
		if(dDay == 0){
			dDay = DAYS_PER_SEASON;
			dSeason = dSeason - 1;
		}
		dWday = gYday % DAYS_PER_WEEK;
		if(dWday == 0){
			dWday = DAYS_PER_WEEK;
		}
		// Calculate Holy days
		if (dDay == 5){
			
			holyDay = HOLYDAY[dSeason][0];
		} else if(dDay == 50){
			holyDay = HOLYDAY[dSeason][1];
		} else {
			holyDay = null;
		}
	}
	
	}

