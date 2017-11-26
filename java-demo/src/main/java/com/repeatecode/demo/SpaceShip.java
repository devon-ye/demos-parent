package com.repeatecode.demo;
/**
*Describetion:
*@author  Devonmusa
*@version
*2017年2月10日 下午9:20:14
*
*/
public class SpaceShip extends SpaceShipControls {
	
	private String name;
	
	public SpaceShip(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public static void main(String[] args) {
		SpaceShip  spaceShip = new SpaceShip("NSEA PROTECTOR");
		spaceShip.back(3);
	}
}
