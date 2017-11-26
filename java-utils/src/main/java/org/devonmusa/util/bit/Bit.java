//package org.devonmusa.util.bit;
//
//import java.lang.annotation.Native;
//
//public class Bit extends Number implements Comparable<Bit>{
//	public static  bit ;
//	
//
//	
//	public static final int MAX_VALUE = 1;
//	
//	public static final int MIN_VALUE = 0;
//	
//
//	@SuppressWarnings("unchecked")
//	public static final Class<Bit>   TYPE = (Class<Bit>) Class.getPrimitiveClass("bit");
//	
//	 public static String toString(bit b){
//			
//	}
//	public static final int SIZE = 1;
//	public Bit(bit value){
//		
//	}
//	
//	public static void setBit(){
//		
//	}
//	
//	public static Bit getBit() {
//		
//	}
//	
//
//	@Override
//	public int intValue() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public long longValue() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public float floatValue() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public double doubleValue() {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int compareTo(Bit o) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//    public static bit parseBit(String s, int radix) throws NumberFormatException{
//    	int	i = Integer.parseInt(s,redix);
//    	if(i < MIN_VALUE || i >MAX_VALUE)
//    		throws new NumberFormatException("Value out of range. Value:\"" + s + "\" Radix:" + radix);
//    	
//    	return (bit)i;
//    }
//    
//    public static byte parseBit(String s) throws NumberFormatException {
//        return parseBit(s, 10);
//    }
//    
//    private final bit = value;
//    
//    public boolean equals(Object obj) {
//        if (obj instanceof Bit) {
//            return value == ((Bit)obj).byteValue();
//        }
//        return false;
//    }
//}
