package org.devon.data.structures.stack;

import org.devon.algorithms.leetcode.ListNode;
import org.devon.data.structures.tree.TreeNode;

import java.util.Iterator;
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


	public boolean isSubTree(TreeNode parent, TreeNode child) {
		if (parent == null && child == null) {
			return true;
		} else if (parent != null && child != null && parent.value == child.value) {
			boolean left = isSubTree(parent.left, child.left);
			boolean right = isSubTree(parent.right, child.right);
			if (left == true && right == true) {
				return true;
			} else {
				return false;
			}
		} else {
			boolean result = isSubTree(parent.left, child);
			if (result) {
				return true;
			}
			result = isSubTree(parent.right, child);
			if (result) {
				return true;
			}
			return false;
		}
	}

	public ListNode reverse(ListNode head) {
		if (head == null) return null;

		ListNode dummy = new ListNode(0);
		ListNode current = null;
		while (head != null) {
			current = head;
			current.next = dummy.next;
			head = head.next;
			dummy.next = current;
		}

		return dummy.next;
	}
}
