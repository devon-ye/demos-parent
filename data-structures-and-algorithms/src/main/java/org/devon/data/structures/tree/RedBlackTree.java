package org.devon.data.structures.tree;



/**
 * @author devonmusa
 * @since
 */
public class RedBlackTree<Key extends Comparable<Key>,Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private transient Node root;


    private class Node<Key extends Comparable<Key>,Value> {
        /**
         * 键
         */
        private Key key;
        /**
         * 关联的值
         */
        private Value value;
        /**
         * 左右子树
         */
        private int N;
        private Node left, right,p;
        /**
         * 父节点指向他的链接的颜色
         */
        private boolean color;

        public Node(Key key, Value value,int N, boolean color) {
            this.key = key;
            this.value = value;
            this.N = N;
            this.color = color;

        }
    }

    public void put(Key key,Value val){
        root = put(root,key,val);
        root.color = BLACK;
    }

    private Node put(Node node,Key key,Value val){
         if(node == null){
             return new Node(key,val,1,RED);
         }
         int cmp = key.compareTo((Key) node.key);

         if(cmp < 0 ){
             node.left = put(node.left,key,val);
         }else if(cmp > 0){
             node.right = put(node.right,key,val);
         }else {
             node.value = val;
         }
         if(isRed(node.right) && !isRed(node.left)){
             node = rotateLeft(node);
         }

         if(isRed(node.left) && isRed(node.left.left)){
             node =rotateRight(node);
         }

         if(isRed(node.left) && isRed(node.right)){

         }
         return node;
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private int size(Node h) {
        return 0;
    }
}
