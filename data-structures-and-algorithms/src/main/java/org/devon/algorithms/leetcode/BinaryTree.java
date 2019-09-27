package org.devon.algorithms.leetcode;

import org.devon.data.structures.tree.TreeNode;

/**
 * @author Devonmusa
 * @date 2019/9/25 8:35
 * @since
 */
public class BinaryTree {

    /**
     * 一个二叉树得镜像 转化为两棵树去解
     * 如果同时满足下面的条件，两个树互为镜像：
     * 它们的两个根结点具有相同的值。
     * 每个树的右子树都与另一个树的左子树镜像对称。
     * @param root
     * @return
     */
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.value == t2.value)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

}
