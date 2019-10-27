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
     Key key;
    /**
     * value
     */
     Value value;
    /**
     * left node reference
     */
     TreeNode left;
    /**
     * right node reference
     */
     TreeNode right;
    /**
     * current node of root, sub tree node count
     */
     int count;

    public TreeNode(Key key, Value value, int count) {
        this.key = key;
        this.value = value;
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
