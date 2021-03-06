package org.devon.data.structures.tree;


public class ArrayBinaryTree<Key extends Comparable<Key>,Value> implements BinaryTree<Key,Value> {

    private Object[] data;
    private transient int count;

    private static final int DEFAULT_DEEP = 10;


    public ArrayBinaryTree() {
        this(DEFAULT_DEEP);
    }

    public ArrayBinaryTree(int deep) {
        int capacity = (int) Math.pow(2, deep);
        data = new Object[capacity];
    }


    @Override
    public int size() {
        return count;
    }

    @Override
    public int size(TreeNode node) {
        return 0;
    }

    @Override
    public Value get(Key key) {
        return null;
    }

    @Override
    public void put(Key key, Value value) {
          TreeNode node = new TreeNode(key,value,count+1);
        for (int i = 0; i < data.length; i++) {
          TreeNode oldNode =  (TreeNode)data[i];
           int res = node.key.compareTo(oldNode.key);
            if(res>0){

            }else if(res<0){

            }else {

            }
        }
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
    }

    @Override
    public TreeNode min(TreeNode node) {
        return null;
    }

    @Override
    public TreeNode max(TreeNode node) {
        return null;
    }

    @Override
    public void preOrderTraversal(TreeNode root) {

    }

    @Override
    public void inOrderTraversal(TreeNode root) {

    }

    @Override
    public void postOrderTraversal(TreeNode root) {

    }

    @Override
    public void levelOrderTraversal(TreeNode root) {

    }

    @Override
    public int maxDepth(TreeNode root) {
        return 0;
    }

    @Override
    public int minDepth(TreeNode root) {
        return 0;
    }

    @Override
    public boolean isSymmetric(TreeNode root) {
        return false;
    }

    @Override
    public boolean isMirror(TreeNode node1, TreeNode node2) {
        return false;
    }

    @Override
    public Integer rangeSumBST(TreeNode root, Integer L, Integer R) {
        return null;
    }

    public TreeNode bstToGst(TreeNode root) {
        bstToGstUpdate(root,0);
        return root;
    }

    private int bstToGstUpdate(TreeNode node,int val){
        if(node == null){
            return val;
        }
        int right = bstToGstUpdate(node.right,val);
        node.value = right+ (int)node.value;
        return bstToGstUpdate(node.left,(int)node.value);
    }



}
