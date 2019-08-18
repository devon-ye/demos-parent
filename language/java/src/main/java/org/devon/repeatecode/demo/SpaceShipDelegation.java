package org.devon.repeatecode.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
*
*@author  Devonmusa
*@date 2017年2月10日 
*
*/
public class SpaceShipDelegation {
	private static final Logger logger = LoggerFactory.getLogger(SpaceShipDelegation.class);
	@SuppressWarnings("unused")
	private  String name;
	private SpaceShipControls controls = new SpaceShipControls();
	
	public SpaceShipDelegation(String name) {
		this.name = name;
	}
	
	public void back (int velocity) {
		controls.back(velocity);
	}
	
	public void down (int velocity) {
		controls.down(velocity);
	}
	
	public void left(int velocity) {
		controls.left(velocity);
	}
	
	public void right(int velocity)
	{
		controls.right(velocity);
	}
	
	public void forward(int velocity) {
		controls.forward(velocity);
	}
	
	public void up(int velocity) {
		controls.up(velocity);
	}
	
	public void  turboBoost() {
		controls.turboBoost();
	}
	public static void main(String[] args) {
		SpaceShipDelegation delegation = new SpaceShipDelegation("NSME P");
		delegation.forward(100);
		logger.info("start");
	}

}
