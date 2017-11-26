package com.circulation.demo;

public class ForCirculationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ForCirculationDemo forCirculationDemo = new ForCirculationDemo();
		forCirculationDemo.forCirculation();
	}

	public void forCirculation() {
		for (int k = 0; k < 0; k++) {
			System.out.println("FOR循环  1" + k + "执行中");
		}
		for (int k = 10; k > 0; k--) {
			System.out.println("FOR循环2 " + k + "执行中");
		}
		/**
		 * dead loop
		 */
		/*
		for (int k = 0; k < 10; k--) {
			System.out.println("FOR循环3  " + k + "执行中");
			break;
		}
		*/
		for (int k = 0; k > 0; k++) {
			System.out.println("FOR循环4  " + k + "执行中");
		}


	}

}
