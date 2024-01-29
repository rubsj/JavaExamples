package com.ruby.leetcode;

import com.ruby.leetcode.utils.TreeNode;
import com.ruby.leetcode.utils.TreeNodeToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        List<Integer> list = Arrays.stream(inorder).boxed().collect(Collectors.toList());

        int mid = list.indexOf(preorder[0]);
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid+1), Arrays.copyOfRange(inorder, 0 , mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid+1 , preorder.length) , Arrays.copyOfRange(inorder , mid+1 , inorder.length));
        return root;
    }

    public static void main(String[] args) {
        BuildTree tree = new BuildTree();
        int[] case1_preorder = new int[]{3,9,20,15,7};
        int[] case1_inorder = new int[]{9,3,15,20,7};
        TreeNode result = tree.buildTree(case1_preorder, case1_inorder);
        System.out.printf("the built tree is %s%n" , TreeNodeToString.treeNodeToString(result));
    }
}
