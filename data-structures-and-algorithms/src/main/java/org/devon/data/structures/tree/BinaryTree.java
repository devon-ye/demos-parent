package org.devon.data.structures.tree;


/**
 * @author Devonmusa
 * @date 2019/8/24 2:59
 * @since
 */
public interface BinaryTree<Key, Value> {


    int size();

    int size(TreeNode node);

    Value get(Key key);

    void put(Key key, Value value);

    Key min();

    Key max();

    TreeNode min(TreeNode node);

    TreeNode max(TreeNode node);

    void preOrderTraversal(TreeNode root);

    void inOrderTraversal(TreeNode root);

    void postOrderTraversal(TreeNode root);

    void levelOrderTraversal(TreeNode root);

     int maxDepth(TreeNode root);

     int minDepth(TreeNode root);

     boolean isSymmetric(TreeNode root);

     boolean isMirror(TreeNode node1,TreeNode node2);

    Integer rangeSumBST(TreeNode root, Integer L, Integer R);


}
