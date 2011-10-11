package models;

import java.util.Date;

public class CalendarUtil {

	private static java.util.Calendar cal = java.util.Calendar.getInstance();
	private static Date today;
	private static CalendarUtil util;
	
	private CalendarUtil(){
		today = new Date();
	}
	
	/**
	 * Months are written in <code>int</code>'s from 0 to 11. <br>
	 * Example: June would be <code> 5. </code>
	 * Wrong input is not handled.
	 * 
	 * @param month
	 */
	public static CalendarUtil getInstanceToday(){
		util = new CalendarUtil();
		return util;	
	}
	
	public static int getMonth(){
		return cal.get(cal.MONTH);
	}
	/**
	 * Sets the default time stamp one month ahead.
	 */
	public static void nextMonth(){
		cal.add(cal.MONTH, 1);
	}
	
	/**
	 * Sets the default time stamp one month back.
	 */
	public static void previousMonth(){
		cal.add(cal.MONTH, -1);
	}
	
	public static int getNumberOfDaysOfMonth(){
		return cal.getActualMaximum(cal.DATE);
	}
	
	public static int getFirstSundayInMonth(){
		//TODO
		return 0;
	}
}	