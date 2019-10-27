package org.devon.data.structures.tree;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Queue;
import java.util.concurrent.LinkedTransferQueue;

public class LinkTableBinaryTree<Key extends Comparable<Key>,Value> implements BinaryTree<Key,Value> {

    private static final Logger LOG = LoggerFactory.getLogger(LinkTableBinaryTree.class);
    private TreeNode root;

    public int size() {
        return size(root);
    }

    public int size(TreeNode node) {
        if (node == null) {
            return 0;
        } else {
            return node.count;
        }
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Key min() {
        TreeNode minNode = min(root);
        if (minNode == null) {
            return null;
        } else {
            return (Key) minNode.key;
        }
    }

    public Key max() {
        TreeNode maxNode = max(root);
        if (maxNode == null) {
            return null;
        } else {
            return (Key)maxNode.key;
        }
    }


    public Value get(TreeNode node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo((Key)node.key);
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return (Value) node.value;
        }

    }

    public TreeNode put(TreeNode node, Key key, Value value) {
        if (node == null) {
            node = new TreeNode(key, value, 1);
        }

        int cmp = key.compareTo((Key) node.key);

        if (cmp < 0) {
            return put(node.left, key, value);
        } else if (cmp > 0) {
            return put(node.right, key, value);
        } else {
            node.value = value;
        }

        node.count = size(node.left) + size(node.right) + 1;

        return node;

    }

    public TreeNode min(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            return min(node.left);
        }

        if (node.right != null) {
            return min(node.right);
        }

        return node;
    }

    public TreeNode max(TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return max(node.right);
        }

        if (node.left != null) {
            return max(node.left);
        }

        return node;
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        LOG.info("root:" + root);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        LOG.info("root:" + root);
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        LOG.info("root:" + root);
    }

    public void levelOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedTransferQueue<>();
        queue.add(root);
        while (!queue.isEmpty()){
            final TreeNode node =  queue.poll();
            if(node.left!=null){
                queue.add(node.left);
            }

            if(node.right != null){
                queue.add(node.right);
            }

            LOG.info("value:{}",node.value );
        }
    }


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
