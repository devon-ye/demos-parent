package com.basic.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*
*@author Devonmusa
*@date   2017年5月14日
*/
public class FinalAndStaticFinaldifference {
	private static final Logger LOG = LoggerFactory.getLogger(FinalAndStaticFinaldifference.class);
	public FinalAndStaticFinaldifference() {
		
	}


	private static int x = 100;// 2


	public static void main(String args[]) {// 3

        Test test= null;
        test.hello();

        Throwable throwable = new Throwable();
        Error error = new Error();
		FinalAndStaticFinaldifference hsl = new FinalAndStaticFinaldifference();// 4
		hsl.x++;// 5
		FinalAndStaticFinaldifference hs2 = new FinalAndStaticFinaldifference();// 6
		hs2.x++;// 7
		hsl = new FinalAndStaticFinaldifference();// 8
		hsl.x++;// 9
		FinalAndStaticFinaldifference.x--;// 10
		System.out.println(" x=" + x);// 11
	}



}
class Test {
    public static void hello() {
        System.out.println("hello");
    }
}

