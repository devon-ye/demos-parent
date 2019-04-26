package org.devon.date;


import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;


/**
 * Describetion:
 * 
 * @author Devonmusa
 * @version 2017年2月11日 下午1:25:18
 *
 */
public class DateComputedUtils {
	private static final String DATE_FORMAT = "yyyyMMdd";
	private static final int[] comYearMonthOfDays = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] leapYearMonthOfDays = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	/**
	 * @see startDate and endDate format is 19900111
	 * @param startDate
	 * @param endDate
	 * @return
	 * @throws ParseException
	 */

	public static int getDays(String startDate, String endDate) throws ParseException {
		int totalDays = 0;
		Calendar calendar = Calendar.getInstance();
		//DurationFormatUtils.
		
		Date start = DateUtils.parseDate(startDate, DATE_FORMAT);
		calendar.setTime(start);
		int startYear = calendar.get(Calendar.YEAR) + 1900;
		
		Date end =  DateUtils.parseDate(endDate, DATE_FORMAT);
		calendar.setTime(end);	
		int endYear = calendar.get(Calendar.YEAR) + 1900;
		
		if (isLeapYear(startYear)) {
			totalDays = 366 - computeUsedDays(start);
		}
		totalDays = 365 - computeUsedDays(start);
		totalDays = totalDays + computeUsedDays(end);

		for (int midYear = startYear + 1; midYear < endYear; midYear++) {
			if (isLeapYear(midYear)) {
				totalDays += 366;
			} else {
				totalDays += 365;
			}
		}
		System.out.println("from  " + startDate + " to " + endDate + " had " + totalDays + " days");
		return totalDays;
	}

	public static String getWeekDay(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		int weekday = c.get(Calendar.DAY_OF_WEEK);

		return "星期" + weekday;
	}

	private static int computeUsedDays(Date currentDate) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(currentDate);
		int curYearTotalDays = 0;
		int curYear =calendar.get(Calendar.YEAR) + 1900;
		int curMonth = calendar.get(Calendar.MONTH);
		curYearTotalDays =  calendar.get(Calendar.DAY_OF_MONTH) - 1;

		if (isLeapYear(curYear)) {
			for (int i = 0; i < curMonth; i++) {
				curYearTotalDays += leapYearMonthOfDays[i];
			}
		} else {
			for (int i = 0; i < curMonth; i++) {
				curYearTotalDays += comYearMonthOfDays[i];
			}
		}
		return curYearTotalDays;
	}

	private static boolean isLeapYear(int year) {
		boolean result = false;
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			result = true;
		}
		return result;
	}
}