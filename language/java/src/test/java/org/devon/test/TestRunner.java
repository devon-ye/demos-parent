package org.devon.test;


import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Devonmusa
 * @date 2017年5月21日
 */
public class TestRunner {
	private static final Logger log = LoggerFactory.getLogger(JunitBeforeAndBeforeClassDifferent.class);

	@Test
	public void test() {
		
		Result results = JUnitCore.runClasses(JunitBeforeAndBeforeClassDifferent.class);
		
		for (Failure failure : results.getFailures()) {
			log.info("test result:" + failure);
		}
		
		results.wasSuccessful();
	}

}
