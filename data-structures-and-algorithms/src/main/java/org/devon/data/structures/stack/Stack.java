package org.devon.data.structures.stack;

import org.devon.algorithms.leetcode.ListNode;
import org.devon.data.structures.tree.TreeNode;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author dewen.ye
 * @date 2019/1/12 11:31
 */
public class Stack<Item> implements Iterable<Item> {
	private Item item;
	private int size;

	public Stack() {

	}

	public void push(Item item) {

	}

	public Item pop() {
		//TODO
		return item;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}


	@Override
	public Iterator<Item> iterator() {
		return null;
	}

	@Override
	public void forEach(Consumer<? super Item> action) {

	}

	@Override
	public Spliterator<Item> spliterator() {
		return null;
	}


	public int longestValidParentheses(String s) {
		int maxans = 0;
		Deque<Integer> stack = new LinkedList<Integer>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.isEmpty()) {
					stack.push(i);
				} else {
					maxans = Math.max(maxans, i - stack.peek());
				}
			}
		}
		return maxans;
	}


}
