package org.devon.design.pattern.command;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月5日
*/
public class HelpCommand extends Command {
	private HelpHandler helpHandler;
	
	public HelpCommand() {
		helpHandler = new HelpHandler();
	}
	
	@Override
	public void excute() {
		helpHandler.helper();
	}

}
