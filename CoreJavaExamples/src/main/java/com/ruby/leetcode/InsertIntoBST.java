package com.ruby.leetcode;

import com.ruby.leetcode.utils.StringToTreeNode;
import com.ruby.leetcode.utils.TreeNode;
import com.ruby.leetcode.utils.TreeNodeToString;

/**
 * You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.
 *
 * Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3], val = 5
 * Output: [4,2,7,1,3,5]
 * Explanation: Another accepted tree is:
 *
 * Example 2:
 *
 * Input: root = [40,20,60,10,30,50,70], val = 25
 * Output: [40,20,60,10,30,50,70,null,null,25]
 * Example 3:
 *
 * Input: root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 * Output: [4,2,7,1,3,5]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree will be in the range [0, 104].
 * -108 <= Node.val <= 108
 * All the values Node.val are unique.
 * -108 <= val <= 108
 * It's guaranteed that val does not exist in the original BST.
 */
public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null){
            return  new TreeNode(val);
        }
        if(val > root.val){
            root.right = insertIntoBST(root.right , val);
        }else if(val < root.val){
            root.left = insertIntoBST(root.left , val);
        }
        return root;
    }

    public TreeNode insertIntoBSTIterative(TreeNode root, int val){
        if(root == null){
            return new TreeNode(val);
        }
        TreeNode curr = root;
        while(true){
            if(val > curr.val){
                if(curr.right != null){
                    curr = curr.right;
                }else{
                    curr.right =  new TreeNode(val);
                    break;
                }
            }else{
                if(curr.left != null){
                    curr = curr.left;
                }else{
                    curr.left = new TreeNode(val);
                    break;
                }
            }
        }

        return root;
    }

    public static void main(String[] args) {
        InsertIntoBST bst = new InsertIntoBST();
        TreeNode case1 = StringToTreeNode.stringToTreeNode("[4,2,7,1,3]");
        TreeNode case2 = StringToTreeNode.stringToTreeNode("[40,20,60,10,30,50,70]");
        TreeNode case11 = StringToTreeNode.stringToTreeNode("[4,2,7,1,3]");
        TreeNode case22 = StringToTreeNode.stringToTreeNode("[40,20,60,10,30,50,70]");


        TreeNode result = bst.insertIntoBST(case1 , 5);
        System.out.printf("The updated root is %s%n ", TreeNodeToString.treeNodeToString(result)); // [4,2,7,1,3,5]

        result = bst.insertIntoBST(case2 , 25);
        System.out.printf("The updated root is %s%n ", TreeNodeToString.treeNodeToString(result)); //[40,20,60,10,30,50,70,25]

        result = bst.insertIntoBSTIterative(case11 , 5);
        System.out.printf("The updated root is %s%n ", TreeNodeToString.treeNodeToString(result)); // [4,2,7,1,3,5]

        result = bst.insertIntoBSTIterative(case22 , 25);
        System.out.printf("The updated root is %s%n ", TreeNodeToString.treeNodeToString(result)); //[40,20,60,10,30,50,70,25]

    }
}
