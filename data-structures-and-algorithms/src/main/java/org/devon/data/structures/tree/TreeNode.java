package org.devon.data.structures.tree;

import org.devon.algorithms.leetcode.BinarySearchTree;

/**
 * @author Devonmusa
 * @date 2019/9/19 8:47
 * @since
 */
public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int value;


    public TreeNode(TreeNode left, TreeNode right, int value) {
        this.left = left;
        this.right = right;
        this.value = value;
    }
}
