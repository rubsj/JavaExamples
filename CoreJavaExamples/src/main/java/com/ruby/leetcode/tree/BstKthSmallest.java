package com.ruby.leetcode.tree;

import com.ruby.leetcode.utils.StringToTreeNode;
import com.ruby.leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 */
public class BstKthSmallest {
    public int kthSmallest(TreeNode root, int k) {
        int count = 0;
        int val =-1;
        TreeNode curr = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        while((curr != null || !stack.isEmpty()) && count != k){
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode node = stack.pop();
            count++;
            val = node.val;
            curr = node.right;
        }
        return  val;
    }

    public int kthSmallestRecursive(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list.get(k - 1);
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    public static void main(String[] args) {
        TreeNode case1 = StringToTreeNode.stringToTreeNode("[3,1,4,2]");
        TreeNode case2 = StringToTreeNode.stringToTreeNode("[5,3,6,2,4,1]");
        // TreeNode case3 = StringToTreeNode.stringToTreeNode("[5,3,6,2,4,1]");
        BstKthSmallest smallest = new BstKthSmallest();
        int result = smallest.kthSmallest(case1 , 1);
        System.out.printf("for case1 the 1st smallest number is %d%n", result);
        result = smallest.kthSmallest(case2 , 3);
        System.out.printf("for case2 the 3rd smallest number is %d%n", result);
        result = smallest.kthSmallest(case2 , 4);
        System.out.printf("for case2 the 4th smallest number is %d%n", result);

        result = smallest.kthSmallestRecursive(case1 , 1);
        System.out.printf("for case1 the 1st smallest number is %d%n", result);
        result = smallest.kthSmallestRecursive(case2 , 3);
        System.out.printf("for case2 the 3rd smallest number is %d%n", result);
        result = smallest.kthSmallestRecursive(case2 , 4);
        System.out.printf("for case2 the 4th smallest number is %d%n", result);
    }
}
