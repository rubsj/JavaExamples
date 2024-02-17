package com.ruby.leetcode.search;

import com.ruby.leetcode.utils.StringToTreeNode;
import com.ruby.leetcode.utils.TreeNode;
import com.ruby.leetcode.utils.TreeNodeToString;

/**
 * You are given the root of a binary search tree (BST) and an integer val.
 *
 * Find the node in the BST that the node's value equals val and return the subtree rooted with that node. If such a node does not exist, return null.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3], val = 2
 * Output: [2,1,3]
 * Example 2:
 *
 *
 * Input: root = [4,2,7,1,3], val = 5
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 5000].
 * 1 <= Node.val <= 107
 * root is a binary search tree.
 * 1 <= val <= 107
 */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(val > root.val){
            return searchBST(root.right, val);
        }else if(val < root.val){
            return searchBST(root.left , val);
        }else{
            return root;
        }
    }

    public TreeNode searchBSTItr(TreeNode root, int val){
        TreeNode curr = root;
        while(curr != null){
            if(curr.val == val){
                return curr;
            }else {
                curr =  val > curr.val ? curr.right : curr.left;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        SearchBST bst = new SearchBST();
        TreeNode case1 = StringToTreeNode.stringToTreeNode("[4,2,7,1,3]");
        TreeNode result = bst.searchBST(case1 , 2);
        System.out.printf("treenode found is %s%n " , TreeNodeToString.treeNodeToString(result));

        result = bst.searchBST(case1 , 5);
        System.out.printf("treenode found is %s%n " , TreeNodeToString.treeNodeToString(result));

        result = bst.searchBSTItr(case1 , 2);
        System.out.printf("treenode found is %s%n " , TreeNodeToString.treeNodeToString(result));

        result = bst.searchBSTItr(case1 , 5);
        System.out.printf("treenode found is %s%n " , TreeNodeToString.treeNodeToString(result));

    }
}
