package com.generics;


import com.bean.demo.A;
import com.generics.demo.ThreeTuple;
import com.generics.demo.TwoTuple;
import org.junit.Test;

/*
*@author  Devonmusa
*@version
*2017年1月21日 下午3:51:01
*
*/
public class TupleTest {
	
	static TwoTuple<String,Integer> f() {
		return  new TwoTuple<>("hi", 47);
	}
	
	static ThreeTuple<A,String,Integer> g() {
		return new ThreeTuple<A,String,Integer>(new A(),"hello",89);
	}

	@Test
	public void test() {
		TwoTuple<String, Integer> ttfs = f();
	}
	

}
