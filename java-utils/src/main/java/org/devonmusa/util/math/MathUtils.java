package org.devonmusa.util.math;
/*
*@author  Devonmusa
*@version
*2017年1月18日 上午12:27:21
*
*/
public class MathUtils {
	
	private MathUtils() {
		throw new Error("MathUtils class is forbiden instance!");
	}
	
	public static double calCircleArea(double r) {
		return Math.PI * r * r;
	}
	
	public static double calBallArea(double r) {
		return 4 * Math.PI * r * r;
	}

}
