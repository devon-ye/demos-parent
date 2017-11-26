package com.algorithm.compute;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Devonmusa
 * @date 2017年6月4日
 */
public class SumDigPow {
	
	
	 public static List<Long> sumDigPow(long a, long b) {
	        List<Long> result = new ArrayList<>();
	        for (long i = a; i <= b; i++)
	            if(isEureka(i))
	                result.add(i);
	        return result;
	    }

	    private static boolean isEureka(long n) {
	        long tmp = n;
	        long sum = 0;
	        int power = length(n);
	        while (tmp > 0) {
	            sum += (long) Math.pow(tmp % 10, power);
	            tmp /= 10;
	            power--;
	        } 
	        return sum == n;    
	    }

	    private static int length(long n) {
	        int length = 0;
	        while (n > 0) {
	            n /= 10;
	            length++;
	        }
	        return length;
	    }
	
	
	public static List<Long> sumDigPowMy(long a, long b) {
		List<Long> sumDigPows = new ArrayList<Long>();
		if (a > b) {
			return sumDigPows;
		}
		while (a < b) {
			boolean isDigPow = isDigPow(a);
			if (isDigPow) {
				sumDigPows.add(a);
			}
			a++;
		}
		return sumDigPows;

	}

	private static boolean isDigPow(Long num) {

		String numStr = String.valueOf(num);
		char[] charsNumber = numStr.toCharArray();

		int i = 0;
		long digPowResult = 0;
		int charLength = charsNumber.length;
		while (i < charLength) {
			String str = String.valueOf(charsNumber[i]);
			int baseNum = Integer.parseInt(str);
			int tempResult = baseNum;
			for (int j = 0; j < i; j++) {
				tempResult = tempResult * baseNum;
			}
			digPowResult += tempResult;
			i++;
		}
		return digPowResult == num;
	}
	
	


}
