package org.devonmusa.util.uuid;

import java.util.UUID;

/**
 *
 * @author Devonmusa
 * @date 2017年6月17日
 */
public class GlobalsUniqueIdentifiers {

	public static String getUUID(String prefix) {
		return prefix + UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	public static String getUUID() {
		return  UUID.randomUUID().toString();
	}
	
}
