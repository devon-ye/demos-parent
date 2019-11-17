package org.devon.distributed.consistent.hashing;

import java.nio.charset.Charset;

/**
 * @author dewen.ye
 * @datetime 2019/11/17 11:23 PM
 * @since
 */
public class MD5HashFunction implements HashFunction {
	/**
	 * Default charset of UTF-8
	 */
	private static final Charset UTF8 = Charset.forName("UTF-8");

	/**
	 * Instantiates a new MD5 hash function.
	 */
	public MD5HashFunction() {
	}

	/**
	 * @see HashFunction#hash(Object)
	 */
	@Override
	public int hash(Object s) {
		byte[] hash = MessageDigests.md5().digest(s.toString().getBytes(UTF8));

		// HACK just take the first 4 digits and make it an integer.
		// apparently this is what other algorithms use to turn it into an int
		// value.

		int h0 = (hash[0] & 0xFF);
		int h1 = (hash[1] & 0xFF) << 8;
		int h2 = (hash[2] & 0xFF) << 16;
		int h3 = (hash[3] & 0xFF) << 24;

		return h0 + h1 + h2 + h3;
	}
}
