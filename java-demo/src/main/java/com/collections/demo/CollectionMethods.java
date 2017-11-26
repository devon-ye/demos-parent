package com.collections.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Describetion:
 * 
 * @author Devonmusa
 * @version 2017年2月10日 下午8:41:00
 *
 */
public class CollectionMethods {
    
	private static final Logger log = LoggerFactory.getLogger(CollectionMethods.class);
	
	public static void main(String[] args) {

		testCollectionMethods();
	}

	public static void testCollectionMethods() {
		Collection<String> c = new ArrayList<String>();
		c.add("s");
		c.add("sad");
		log.info(c + "");
//		Object[] array = c.toArray();
//		String[] strings = c.toArray(new String[0]);
		log.info(" Collections.max(c) = " + Collections.max(c));
		log.info( ",Collections.min(c) = " + Collections.min(c));

	}

}
