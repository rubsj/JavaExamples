package com.ruby.leetcode.utils;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNodeToString {
    public static String treeNodeToString(TreeNode node) {
        if (node == null) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode curr = queue.removeFirst();
                result.append(curr.val);
                result.append(", ");
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return "[" + result.toString().substring(0, result.length() - 2) + "]";
    }
}
