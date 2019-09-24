package org.devon.algorithms.leetcode;

import org.devon.data.structures.tree.TreeNode;

/**
 * @author Devonmusa
 * @date 2019/9/19 8:12
 * @since
 */
public class BinarySearchTree {


    public static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            if (root.value > L) {
                return root.value + rangeSumBST(root.left, L, R);
            } else if (root.value == R) {
                return root.value;
            }
        }
        if (root.right != null) {
            if (root.value < R) {
                return root.value + rangeSumBST(root.right, L, R);
            } else if (root.value == R) {
                return root.value;
            }
        }
        if (root.value > L && root.value < R) {
            return root.value;
        }
        return 0;
    }

    /***
     * <p>URL:https://leetcode-cn.com/problems/maximum-depth-of-binary-tree</p>
     * <P> method: recursion</P>
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
        }
    }


}
