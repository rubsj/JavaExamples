package com.ruby.leetcode.utils;

public class IntegerTreeNode {
    public Integer val;
    public IntegerTreeNode left;
    public IntegerTreeNode right;

    public IntegerTreeNode(Integer val){
        this.val = val;
    }

    public IntegerTreeNode(Integer val, IntegerTreeNode left , IntegerTreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
