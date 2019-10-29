package org.devon.data.structures.tree;


/**
 * @author Devonmusa
 * @date 2019/9/19 8:47
 * @since
 */
public class TreeNode<Key extends Comparable<Key>,Value> {
    /**
     * key
     */
    public Key key;
    /**
     * value
     */
    public Value value;
    /**
     * left node reference
     */
    public TreeNode left;
    /**
     * right node reference
     */
    public TreeNode right;
    /**
     * current node of root, sub tree node count
     */
    public int count;

    public TreeNode(Key key, Value value) {
        this.key = key;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Key key, Value value, int count) {
        this.key = key;
        this.value = value;
        this.count = count;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Node{" +
                "key=" + key +
                ", value=" + value +
                ", left=" + left +
                ", right=" + right +
                ", count=" + count +
                '}';
    }
}
