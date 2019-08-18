package org.devon.generics.demo;

/*
*@author  Devonmusa
*@version
*2017年1月21日 下午3:02:02
*
*/
public class TwoTuple<A, B> {
	public A first;
	public B second;

	public TwoTuple(A first, B second) {
		super();
		this.first = first;
		this.second = second;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TwoTuple [first=");
		builder.append(first);
		builder.append(", second=");
		builder.append(second);
		builder.append("]");
		return builder.toString();
	}

}
