package com.design.pattern.command;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月5日
*/
public class MinimmizeCommand extends Command {
	private WindowHandler windowdHandler;
	
	public MinimmizeCommand() {
		windowdHandler = new WindowHandler();
	}
	
	@Override
	public void excute() {
		windowdHandler.minimize();
	}

}
