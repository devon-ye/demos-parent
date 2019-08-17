package org.devon.generics;


import org.devon.clazz.abstrct.Base;
import org.devon.generics.demo.ThreeTuple;
import org.devon.generics.demo.TwoTuple;
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
	
	static ThreeTuple<Base,String,Integer> g() {
		return new ThreeTuple<Base,String,Integer>(new Base(),"hello",89);
	}

	@Test
	public void test() {
		TwoTuple<String, Integer> ttfs = f();
	}
	

}
