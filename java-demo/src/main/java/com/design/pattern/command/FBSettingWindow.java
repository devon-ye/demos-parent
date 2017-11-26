package com.design.pattern.command;

import java.util.ArrayList;
import java.util.List;

/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月5日
*/
public class FBSettingWindow {
	private String title;
	List<FunctionButton>  functionButtons = new   ArrayList<FunctionButton>();
	
	public FBSettingWindow(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void  addFunctionButton(FunctionButton fb) {
		 this.functionButtons.add(fb);
	}
	
	public void removeFunctionButton(FunctionButton fb) {
		this.functionButtons.remove(fb);
	}	
	public void display() {
	
		System.out.println("窗口显示");
		System.out.println("命令键显示:");
		for(FunctionButton fb:functionButtons) {
			System.out.println(fb + "\t");
		}
	}
}
