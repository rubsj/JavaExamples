package com.ruby.leetcode.utils;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import static com.ruby.leetcode.utils.StringToIntegerArray.leetcodeStringToArray;
import static com.ruby.leetcode.utils.StringToIntegerArray.stringToIntegerArray;

public class StringToTreeNode {

    public static TreeNode leetcodeStringToBinaryTree(String input){
        Integer[] inputVals = leetcodeStringToArray(input);
        if(inputVals.length ==0){
            return null;
        }
        IntegerTreeNode root = new IntegerTreeNode(inputVals[0]);
        Deque<IntegerTreeNode> queue = new LinkedList<>();
        queue.add(root);
        for(int i=1; i< inputVals.length; i++){
            IntegerTreeNode node = queue.peek();
            if(node.left == null){
                node.left = new IntegerTreeNode(inputVals[i]);
                if(inputVals[i] != null ){
                    queue.add(node.left);
                }
            }else if(node.right == null){
                node.right = new IntegerTreeNode(inputVals[i]);
                if(inputVals[i] != null ){
                    queue.add(node.right);
                }
                queue.removeFirst();
            }
        }

        TreeNode transformedRoot = transformTreeNode(root);
        return transformedRoot;
    }

    private static  TreeNode transformTreeNode(IntegerTreeNode node){
            if (node == null || node.val == null) {
                return null;
            }

            TreeNode newNode = new TreeNode(node.val);
            newNode.left = transformTreeNode(node.left);
            newNode.right = transformTreeNode(node.right);
            return newNode;

    }
    public static TreeNode stringToTreeNode(String input){
        int[] inputVals = stringToIntegerArray(input);
        TreeNode root = null;
        for(int val : inputVals){
            root = insert(root , val);
        }
        return root;
    }

    public static TreeNode insert(TreeNode root , int val){
        if(root == null){
            return new TreeNode(val);
        }
        if(val > root.val){
            root.right = insert(root.right, val);
        }else if(val < root.val){
            root.left = insert(root.left, val);
        }
        return root;
    }
}
