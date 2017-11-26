package com.enums.demo;


/*
*@author  Devonmusa
*@version
*2017年1月16日 下午9:22:14
*
*/

public enum OzWitch {
	WEST(" WEST IS"), NORTH("NORTH"), EAST("IS THIS  EAST?"), SOUTH(" GOOD BY INTERFACE ,MISSNG");

	private String description;

	OzWitch(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public static void main(String[] args) {
		for (OzWitch witch : OzWitch.values()) {

//			PrintUtil.printObj(witch + ":" + witch.getDescription());
		}
	}
}
