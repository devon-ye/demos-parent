package org.devon.data.structures.tree;


public class ArrayBinaryTree<Key extends Comparable<Key>,Value> implements BinaryTree<Key,Value> {

    private Object[] data;

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
        return 0;
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
    public Value get(TreeNode node, Key key) {
        return null;
    }

    @Override
    public TreeNode put(TreeNode node, Key key, Value value) {
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
}
