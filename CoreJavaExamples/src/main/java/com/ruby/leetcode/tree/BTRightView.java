package com.ruby.leetcode.tree;

import com.ruby.leetcode.utils.StringToTreeNode;
import com.ruby.leetcode.utils.TreeNode;

import java.util.*;

public class BTRightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        while(!queue.isEmpty()){
            int levelLength = queue.size();
            for(int i=0; i<levelLength; i++){
                TreeNode node = queue.removeFirst();
                if(i== levelLength-1){
                    result.add(node.val);
                }
                if(node.left != null ){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode case1 = StringToTreeNode.leetcodeStringToBinaryTree("[1,2,3,null,5,null,4]");
        TreeNode case2 = StringToTreeNode.leetcodeStringToBinaryTree("[1,null,3]");
        TreeNode case3 = StringToTreeNode.leetcodeStringToBinaryTree("[]");
        TreeNode case4 = StringToTreeNode.leetcodeStringToBinaryTree("[1,2]");
        TreeNode case5 = StringToTreeNode.leetcodeStringToBinaryTree("[1,2,3,4]");
        BTRightView rightView = new BTRightView();
        List<Integer> result = rightView.rightSideView(case1);
        System.out.printf("The right view is %s%n" , result.toString());

        result = rightView.rightSideView(case2);
        System.out.printf("The right view is %s%n" , result.toString());

        result = rightView.rightSideView(case3);
        System.out.printf("The right view is %s%n" , result.toString());

        result = rightView.rightSideView(case4);
        System.out.printf("The right view is %s%n" , result.toString());

        result = rightView.rightSideView(case5);
        System.out.printf("The right view is %s%n" , result.toString());
    }
}
