package com.throwable.error;

import java.util.Random;



/*
*@author  Devonmusa
*@version
*2017年1月18日 上午12:11:54
*
*/
public class CanChangeConst {

	public static void main(String[] args) {
	//PrintUtil.print("Const  could change:" + Const.RAND_CONST);
	}

}
// BUG EXAMPLE

interface Const {
	int RAND_CONST = new Random().nextInt();
}
