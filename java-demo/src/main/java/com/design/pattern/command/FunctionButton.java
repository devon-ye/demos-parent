package com.design.pattern.command;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月5日
*/
public class FunctionButton {
	private String functionName;
	private Command command;
	
	public FunctionButton(String functionName) {
		this.functionName = functionName;
	}

	public String getFunctionName() {
		return functionName;
	}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	public void onClick() {
		command.excute();
	}
	
}
