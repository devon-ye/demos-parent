package org.devon.design.pattern.chain.responsibility;
/**
*@Describetion
*@author  Devonmusa
*@date 2017年3月2日
*/
public class HandlerFactory {
	
	public static Handler createHandler() {
		Handler sales = new Sales();
		Handler teamLeader = new TeamLeader();
		Handler maneger = new Manager();
		Handler ceo = new Ceo();
		sales.setSuccesor(teamLeader);
		teamLeader.setSuccesor(maneger);
		maneger.setSuccesor(ceo);
		return sales;
	} 
	
}
