package org.devon.algorithms.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class ParenthesesValid {
	private Map<Character, Character> mapping = new HashMap<>();

	public ParenthesesValid() {
		mapping.put(']', '[');
		mapping.put(')', '(');
		mapping.put('}', '{');
	}

	public boolean isValid(String s) {


		Stack<Character> stack = new Stack<Character>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (this.mapping.containsKey(c)) {
				char topElement = stack.empty() ? '#' : stack.pop();

				if (topElement != this.mapping.get(c)) {
					return false;
				}

			} else {
				stack.push(c);
			}
		}

		return stack.isEmpty();

	}


	public static List<String> generateParenthesis(int n) {
		List<String> ans = new ArrayList();
		backtrack(ans, "", 0, 0, n);
		return ans;
	}

	public static void backtrack(List<String> ans, String cur, int open, int close, int max) {
		if (cur.length() == max * 2) {
			ans.add(cur);
			return;
		}

		if (open < max)
			backtrack(ans, cur + "(", open + 1, close, max);
		if (close < open)
			backtrack(ans, cur + ")", open, close + 1, max);
	}

	private static final char COMMA = ',';
	private static final char LEFT_BRACE = '(';
	private static final char RIGHT_BRACE = ')';
	private static int nodeIndex = 1;

	public static Node toBinaryTree(String string) {
		if (string == null || string.length() < 1) {
			return null;
		}
		return parseStrTransformBinaryTree(string, null, 0);
	}

	/**
	 * @param string
	 * @param node
	 * @param nodeType 0 :root node  1: left node  2: right node
	 * @return
	 */
	private static Node parseStrTransformBinaryTree(String string, Node node, int nodeType) {
		if (string == null || string.length() < 1) {
			return null;
		}
		int leftIndex = string.indexOf(LEFT_BRACE);
		if (leftIndex > 0) {
			String value = string.substring(0, leftIndex);
			node = buildNode(node, nodeType, value);
			String subStr = string.substring(leftIndex + 1, string.length() - 1);
			int subTreeSplitPosition = lookSplitPosition(subStr);
			if (subTreeSplitPosition > 0) {
				parseStrTransformBinaryTree(subStr.substring(0, subTreeSplitPosition), node, 1);
				parseStrTransformBinaryTree(subStr.substring(subTreeSplitPosition + 1), node, 2);
			}
		} else if (leftIndex < 0 && string.length() > 0) {
			node = buildNode(node, nodeType, string);
		}

		return node;
	}

	private static Node buildNode(Node node, int nodeType, String value) {
		if (nodeType == 1) {
			node.setLeft(new Node(value));
			node = node.left;
		} else if (nodeType == 2) {
			node.setRight(new Node(value));
			node = node.right;
		} else {
			node = new Node(value);
		}
		return node;
	}


	public static int lookSplitPosition(String string) {
		if (string == null || string.length() < 1) {
			return -1;
		}
		int splitPos = 0;
		int len = string.length();
		for (int i = 0; i < len; i++) {
			splitPos = string.indexOf(COMMA, i);
			if (splitPos + 2 == len) {
				break;
			} else if (splitPos + 1 < len && string.charAt(splitPos + 1) == RIGHT_BRACE) {
				i = splitPos + 1;
			} else if (splitPos + 2 < len && string.charAt(splitPos + 2) == LEFT_BRACE) {
				break;
			} else {
				i = splitPos;
			}
		}
		return splitPos;

	}

	static class Node<E> {
		E value;
		Node left;
		Node right;

		public Node(E value) {
			this.value = value;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public void setRight(Node right) {
			this.right = right;
		}
	}


	public static void main(String[] args) {
		//List<String> strings = ParenthesesValid.generateParenthesis(3);
		String str = "A(B(C(,),),E(,),))";

		String str1 = "E(D(A(C,N),B),H)";
		String str6 = "  D(A( C,N), B),H";
		//             E
		//         D       H
		//      A      B
		//
		String str2 = "A";
		String str3 = "A(,)";

		String str4 = "E(D(A(C,N),B),H(K,L(M,N)))";


		//Node tree = ParenthesesValid.toBinaryTree(str);
        Node tree4 = ParenthesesValid.toBinaryTree(str4);

        Node tree1 = ParenthesesValid.toBinaryTree(str1);

		Node tree2 = ParenthesesValid.toBinaryTree(str2);
		Node tree3 = ParenthesesValid.toBinaryTree(str3);
		//System.out.println(tree);


	}
}
