package com.ruby.leetcode.tree;

import com.ruby.leetcode.utils.StringToTreeNode;
import com.ruby.leetcode.utils.TreeNode;

import java.util.*;

/**
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,3,2]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class BSTInorderTraversal {

    public List<Integer> inorderTraversalItr(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            list.add(node.val);
            curr = node.right;
        }
        return list;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        return  inorder(root , list);
    }

    private List<Integer>  inorder(TreeNode root, List<Integer> list){
        if(root == null){
            return list;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode case1 = StringToTreeNode.stringToTreeNode("[1,2,3]");
        TreeNode case2 = StringToTreeNode.stringToTreeNode("[]");
        TreeNode case3 = StringToTreeNode.stringToTreeNode("[1]");
        BSTInorderTraversal bst = new BSTInorderTraversal();
        List<Integer> result = bst.inorderTraversal(case1);
        System.out.printf("for case 1 the output is %s%n" , result.toString());

        result = bst.inorderTraversal(case2);
        System.out.printf("for case 2 the output is %s%n" , result.toString());

        result = bst.inorderTraversal(case3);
        System.out.printf("for case 3 the output is %s%n" , result.toString());

        result = bst.inorderTraversalItr(case1);
        System.out.printf("for case 1 the output is %s%n" , result.toString());

        result = bst.inorderTraversalItr(case2);
        System.out.printf("for case 2 the output is %s%n" , result.toString());

        result = bst.inorderTraversalItr(case3);
        System.out.printf("for case 3 the output is %s%n" , result.toString());
    }
}
