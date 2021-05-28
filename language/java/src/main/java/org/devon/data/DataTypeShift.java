package org.devon.data;

public class DataTypeShift {

	public long bytes2Long(byte[] bytes) {
		long result = 0;
		long temp = 0;
		for (int i = 0; i < 8; i++) {
			result <<= 8;
			temp = bytes[i] & 0xff;
			result |= temp;
		}
		return result;
	}

	public byte[] long2Bytes(long longs) {
		Byte
		byte[] bytes = new byte[8];
		for (int i = 0; i < 8; i++) {
			bytes[i] = (byte) (longs >>> (56 - (i * 8)));
		}
		return bytes;
	}

	public static final int tableSizeFor(int cap) {
		int n = cap - 1;
		n |= n >>> 1;
		n |= n >>> 2;
		n |= n >>> 4;
		n |= n >>> 8;
		n |= n >>> 16;
		return (n < 0) ? 1 : (n >= Integer.MAX_VALUE) ? Integer.MAX_VALUE : n + 1;
	}

	public static void main(String[] args) {
		long temp = 1;
		int size = DataTypeShift.tableSizeFor(8);
		temp = temp << 8;
		temp = temp << 16;
		temp = temp << 24;
		temp = temp << 32;
	}

}
