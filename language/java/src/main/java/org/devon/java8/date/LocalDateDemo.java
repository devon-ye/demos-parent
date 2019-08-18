package org.devon.java8.date;

import java.sql.Timestamp;
import java.time.*;


/**
*
*@author Devonmusa
*@date   2017年7月28日
*/
public class LocalDateDemo {
	
	public LocalDate getLocalDate() {
		LocalDate  localDate = LocalDate.now();
		localDate.getMonth();
	LocalTime localTime=	LocalTime.parse("17:30:01");
		System.out.printf(localTime.toString());
		LocalDateTime localDateTime = LocalDateTime.of(localDate,localTime);
		Long longs =Timestamp.valueOf(localDateTime).getTime();
		System.out.printf("localDateTime:"+localDateTime);
		ZonedDateTime.now();
		Instant instant1 =localDateTime.toInstant(ZoneOffset.UTC);
		System.out.printf("instant1:"+instant1.toString());
		return localDate;
	}

	public static void main(String[] args) {
		LocalDateDemo dateDemo = new LocalDateDemo();
		dateDemo.getLocalDate();
	}

}
