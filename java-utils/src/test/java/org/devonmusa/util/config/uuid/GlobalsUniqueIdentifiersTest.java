package org.devonmusa.util.config.uuid;

import org.devonmusa.util.uuid.GlobalsUniqueIdentifiers;
import org.junit.Test;

/**
*
*@author Devonmusa
*@date   2017年6月17日
*/
public class GlobalsUniqueIdentifiersTest {
	
	@Test
	public void testGetStringUUID() {
		String prefix = "producer-";
		String uuidStr = GlobalsUniqueIdentifiers.getUUID(prefix);
	
		System.out.println(uuidStr);
	}
	
	@Test
	public void testGetUUID() {
		//c1cb906f-6631-41ac-9b30-78a7b7a97b56
		//acf5199e-28f0-48fe-9326-2db5ecc59f57
		//2ff57198-7902-469c-bf6e-2b1bd46b2c32
		String uuidStr = GlobalsUniqueIdentifiers.getUUID();
		System.out.println(uuidStr);
	}
}
