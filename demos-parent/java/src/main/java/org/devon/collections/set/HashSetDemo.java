package org.devon.collections.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
	private static Iterator<String> iterator;

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("d");
		set.add("c");
		set.add("c");
		set.add("    ");
		set.add("e");
		set.add("f");
		// String s[] = { "d", "e", "f" };
		// set.addAll(set);
		iterator = set.iterator();
		for (String e : set) {
			System.out.print(e + "   ");

		}
		System.out.print(set.size());
		System.out.println();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + "  ");

		}
		System.out.println();
		System.out.print(set + " ");
		System.out.println("ssss" + set.size());
	}

}
