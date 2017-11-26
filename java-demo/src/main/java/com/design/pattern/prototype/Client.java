package com.design.pattern.prototype;

import java.util.Date;

/**
*Describetion:
*@author  Devonmusa
*@version
*2017年2月21日 下午10:52:55
*
*/
public class Client{
	
	public static void main(String[] args) {
		WeeklyLog weeklyLog = new WeeklyLog();
		weeklyLog.setName("zhangsan");
		weeklyLog.setDate(new Date()+"");
		weeklyLog.setContent("今天不加班");
		WeeklyLog  weekly;
		weekly = weeklyLog.clone();
		weekly.setContent("没工资");
		weekly.setDate(new Date()+"");
		weekly.setName("李四");
	}

}
