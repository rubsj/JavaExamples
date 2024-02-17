package com.ruby.leetcode.tree;

import com.ruby.leetcode.utils.StringToTreeNode;
import com.ruby.leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */
public class BTLevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        while(!queue.isEmpty()){
            int levelLength = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i=0; i< levelLength; i++){
                TreeNode node = queue.removeFirst();
                levelList.add(node.val);
                if(node.left != null ){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
            list.add(levelList);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode case1 = StringToTreeNode.leetcodeStringToBinaryTree("[3,9,20,null,null,15,7]");
        TreeNode case2 = StringToTreeNode.leetcodeStringToBinaryTree("[1]");
        TreeNode case3 = StringToTreeNode.leetcodeStringToBinaryTree("[]");
        BTLevelOrder traversal = new BTLevelOrder();
        List<List<Integer>> result = traversal.levelOrder(case1);
        System.out.printf("The result for case1 is %s%n" , result.toString());

        result = traversal.levelOrder(case2);
        System.out.printf("The result for case1 is %s%n" , result.toString());

        result = traversal.levelOrder(case3);
        System.out.printf("The result for case1 is %s%n" , result.toString());

    }
}
