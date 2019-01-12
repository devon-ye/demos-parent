package org.devon.algorithm.demo.data.structure;

import java.security.Key;

/**
 * @author devonmusa
 * @since
 */
public class RedBlackTree {

    private static final boolean RED = true;

    private class Node<T> {
        /**
         * 键
         */
        private Key key;
        /**
         * 关联的值
         */
        private T value;
        /**
         * 左右子树
         */
        private Node left, right;
        /**
         * 子树节点总数
         */
        private int N;
        /**
         * 父节点指向他的链接的颜色
         */
        private boolean color;

        public Node(Key key, T value, int n, boolean color) {
            this.key = key;
            this.value = value;
            N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.color = h.color;
        h.color = RED;
        x.N  = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N  = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private int  size(Node h){
        return  0;
    }
}
