package org.devon.data.structures.linked;

import org.devon.algorithms.leetcode.ListNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author devon.ye
 * @datetime 2020/3/6 12:12 下午
 * @since
 */
public class ListUtils {


	public static List<Integer> removeElementsByArrayValue(List<Integer> list, int[] valueIndex) {

		if (list == null || list.isEmpty() || valueIndex == null || valueIndex.length == 0) {
			return list;
		}

		int length = list.size();

		for (int i = 0; i < valueIndex.length; i++) {
			int index = valueIndex[i];
			if (index > 0 && index < length) {
				list.remove(index);
			}
		}

		return list;
	}


	public static Tree strToCompleteBinaryTree(String str) {
		if (str == null) {
			return null;
		}
		char[] ch = str.toCharArray();

		Queue<Tree> queue = new LinkedBlockingQueue<>();
		Tree result = null;
		int length = ch.length;

		for (int i = 0; i < length; i++) {
			Tree parent = queue.poll();
			Tree child1 = new Tree(ch[i]);
			if (parent == null) {
				result = child1;
				queue.add(child1);
				continue;
			} else {
				parent.left = child1;
				queue.add(child1);
			}

			++i;
			if (i >= length) {
				return result;
			}

			Tree child2 = new Tree(ch[i]);
			parent.right = child2;
			queue.add(child2);
		}
		return result;
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


	public static void main(String[] args) {
		Tree result = ListUtils.strToCompleteBinaryTree("ab");
	}


	static class Tree<E> {
		E data;
		Tree left;
		Tree right;

		public Tree(E data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return "Tree{" +
					"data=" + data +
					", left=" + left +
					", right=" + right +
					'}';
		}
	}


}
