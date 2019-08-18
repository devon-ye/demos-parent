package org.devon.date;

import com.google.common.base.Strings;

public class LeapYear {

	public String leapYear(int year){
		String str=null;
		if(year>0&&year<9999){
			if(year%4==0&&year%100!=0||year%400==0){
				str=year+"年是闰年！";
			}else{
				str=year+"年不是闰年！";
			}
		 }else{
			 str="请输入正确的年份！";
		 }
		return str;
	}

}
