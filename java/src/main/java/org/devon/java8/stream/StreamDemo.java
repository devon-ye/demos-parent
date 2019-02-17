package org.devon.java8.stream
;

import java.util.Arrays;
import java.util.stream.Stream;

/**
*
*@author Devonmusa
*@date   2017年8月12日
*/
public class StreamDemo {
	
	public Object[] streamToArray(Stream stream) {
		return stream.toArray();
	}
	
	public Stream arrayToStream(Integer[] array) {
		Stream<Integer> toStream = Arrays.stream(array);
		return toStream;
	}
	
	public void test() {
		Stream<String> fruitStream = Stream.of("apple", "banana", "pear", "kiwi", "orange");

		fruitStream.filter(s -> s.contains("a"))
		           .map(String::toUpperCase)
		           .sorted()
		           .forEach(System.out::println);
	}
	public static void main(String[] args) {
		StreamDemo streamDemo = new StreamDemo();
		streamDemo.test();
	}
	
	

}
