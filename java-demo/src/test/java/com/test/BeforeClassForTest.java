package com.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
*
*@author Devonmusa
*@date   2017年5月20日
*/
public class BeforeClassForTest {
	private Logger log = LoggerFactory.getLogger(JunitBeforeAndBeforeClassDifferent.class);
	
	public BeforeClassForTest() {
		log.info("this is BeforeClassForTest constructure");
	}
	
	
}
