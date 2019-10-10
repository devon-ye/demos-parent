package org.devon.algorithms.recursion;

import org.devon.data.structures.tree.TreeNode;

public class BinarySearchTreeRecursion {
     int result = 0;
    public int rangeSum(TreeNode root,int min,int max){
        return recursionSum(root,min,max,result);
    }

    private int recursionSum(TreeNode node,int min,int max,int result){
        if(node == null){
            return result;
        }

        if(min <= node.value && node.value <= max){
            result += node.value;
        }

        if(min < node.value){
             recursionSum(node.left,min,max,result);
        }

        if(node.value < max){
           recursionSum(node.right,min,max,result);
        }

        return result;
    }
}
