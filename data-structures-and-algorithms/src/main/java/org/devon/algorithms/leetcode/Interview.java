package org.devon.algorithms.leetcode;

/**
 * @author devon.ye
 * @datetime 2020/2/29 5:55 下午
 * @since
 */
public class Interview {

	private static final char COMMA = ',';
	private static final char LEFT_BRACE = '(';
	private static final char RIGHT_BRACE = ')';

	public static ParenthesesValid.Node toBinaryTree(String string) {
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
	private static ParenthesesValid.Node parseStrTransformBinaryTree(String string, ParenthesesValid.Node node, int nodeType) {
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

	private static ParenthesesValid.Node buildNode(ParenthesesValid.Node node, int nodeType, String value) {
		if (nodeType == 1) {
			node.setLeft(new ParenthesesValid.Node(value));
			node = node.left;
		} else if (nodeType == 2) {
			node.setRight(new ParenthesesValid.Node(value));
			node = node.right;
		} else {
			node = new ParenthesesValid.Node(value);
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
		ParenthesesValid.Node left;
		ParenthesesValid.Node right;

		public Node(E value) {
			this.value = value;
		}

		public void setLeft(ParenthesesValid.Node left) {
			this.left = left;
		}

		public void setRight(ParenthesesValid.Node right) {
			this.right = right;
		}
	}
}
