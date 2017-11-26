package com.generics.demo;

/*
*@author  Devonmusa
*@version
*2017年1月21日 下午3:05:53
*
*/
public class ThreeTuple<A, B, C> extends TwoTuple<A, B> {
	public final C c;

	public ThreeTuple(A first, B second, C c) {
		super(first, second);
		this.c = c;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ThreeTuple [c=");
		builder.append(c);
		builder.append("]");
		return builder.toString();
	}

}
