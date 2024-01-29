package com.ruby.leetcode.utils;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer val){
        this.val = val;
    }

    public TreeNode(Integer val, TreeNode left , TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
