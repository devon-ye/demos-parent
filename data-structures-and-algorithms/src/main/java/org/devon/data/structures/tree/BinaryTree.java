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


    Value get(TreeNode node, Key key);

    TreeNode put(TreeNode node, Key key, Value value);

    TreeNode min(TreeNode node);

    TreeNode max(TreeNode node);

    void preOrderTraversal(TreeNode root);

    void inOrderTraversal(TreeNode root);

    void postOrderTraversal(TreeNode root);

    void levelOrderTraversal(TreeNode root);


}
