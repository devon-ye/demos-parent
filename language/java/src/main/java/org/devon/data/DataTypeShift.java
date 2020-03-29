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
		byte[] bytes = new byte[8];
		for (int i = 0; i < 8; i++) {
			bytes[i] = (byte) (longs >>> (56 - (i * 8)));
		}
		return bytes;
	}

	public static void main(String[] args) {
		long temp = 1;
		temp = temp << 8;
		temp = temp << 16;
		temp = temp << 24;
		temp = temp << 32;



	}
	
}
