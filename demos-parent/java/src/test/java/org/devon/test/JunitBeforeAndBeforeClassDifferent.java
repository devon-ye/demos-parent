package org.devon.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.core.joran.spi.JoranException;



/**
*
*@author Devonmusa
*@date   2017年5月20日
*/
public class JunitBeforeAndBeforeClassDifferent {
	private Logger log = LoggerFactory.getLogger(JunitBeforeAndBeforeClassDifferent.class);
	private BeforeClassForTest beforeClassForTest;
	
	@Test
	public void testBeforeAndBeforeClassOne(){
		log.info("this is test method,but in before annotion before");
	}
	
	@BeforeClass
	public void beforClass() throws JoranException{
		String logConfigPath = System.getProperty("user.dir") + "/config/logback.xml";
	//	LogConfigLoadUtil.logConfigLoad(logConfigPath);
		beforeClassForTest = new BeforeClassForTest();
		log.info("this is @BeforeClass  annotion ,so it's always execute");
	}
	
	@Test
	public void testBeforeAndBeforeClassTwo(){
		log.info("this is test method,but in before annotion after");
	}
	
	@Before
	public void setUp() {
		log.info("this is only @Before annotion,so it's only test method before excute");
	}
	
	@Test
	public void testBeforeAndBeforeClassThree(){
		log.info("this is test method,but in before annotion after");
	}
	
	@After
	public void tearDown() {
		log.info("this is only @After annotion ,so it's test annotion after");
	}
	
	@Test
	public void testBeforeAndBeforeClassFour(){
		log.info("this is test method,but in after annotion after");
	}
	
	@AfterClass
	public void afterClass() {
		log.info("this is @AfterClass annotion,but in after annotion after");
	}
}
