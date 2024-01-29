package com.ruby.leetcode;

import com.ruby.leetcode.utils.StringToTreeNode;
import com.ruby.leetcode.utils.TreeNode;
import com.ruby.leetcode.utils.TreeNodeToString;

/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,7], key = 0
 * Output: [5,3,6,2,4,null,7]
 * Explanation: The tree does not contain a node with value = 0.
 * Example 3:
 *
 * Input: root = [], key = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -105 <= Node.val <= 105
 * Each node has a unique value.
 * root is a valid binary search tree.
 * -105 <= key <= 105
 */
public class DeleteFromBST {
    public TreeNode deleteNodeItr(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        TreeNode curr = root;
        TreeNode parent = null;
        while(curr != null && curr.val != key){
            parent =curr;
            if(key > curr.val){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
        // when deleting the root node
        if(parent == null){
            return delete(curr);
        }
        // when node to delete is left child
        if(parent.left == curr){
            parent.left = delete(curr);
        }else{
            parent.right = delete(curr);
        }
        // return root once delete is done
        return root;
    }

    private  TreeNode delete(TreeNode nodeToDelete){
        // when there is no node to delete
        if(nodeToDelete == null){
            return  null;
        }

        // when node to delete has no right child return left child
        if(nodeToDelete.right == null){
            return nodeToDelete.left;
        }
        // when node to delete has no left child return right child
        // these two cases together will cover when node has no child
        if(nodeToDelete.left == null){
            return nodeToDelete.right;
        }
        // when node to delete has both the child
        // find the left most child on the right side and that will be the node that will replace the node to delete
        TreeNode successor = nodeToDelete.right;
        TreeNode parentOfSuccessor = null;
        while(successor.left != null){
            parentOfSuccessor = successor;
            successor = successor.left;
        }
        // the left of the successor will be the left of node to delete
        successor.left = nodeToDelete.left;
        //if the sucessor is the right child of node to delete then its all set
        // otherwise right of successor should point to right of node to delete
        // and if the sucessor has any right child that should be assigned as left child of parent of successor
        if(successor != nodeToDelete.right){
            parentOfSuccessor.left = successor.right;
            successor.right = nodeToDelete.right;
        }
        return successor;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        if(key > root.val){
            root.right = deleteNode(root.right , key);
        }else if(key < root.val){
            root.left = deleteNode(root.left , key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }else{
                TreeNode minNode = findMinNode(root.right);
                root.val = minNode.val;
                root.right = deleteNode(root.right , minNode.val);
            }
        }
        return root;
    }

    private TreeNode findMinNode(TreeNode node){
        TreeNode curr = node;
        while(curr != null && curr.left != null){
            curr = curr.left;
        }

        return curr;
    }

    public static void main(String[] args) {
        DeleteFromBST bst = new DeleteFromBST();
        TreeNode case1 = StringToTreeNode.stringToTreeNode("[5,3,6,2,4,7]");
        TreeNode case11 = StringToTreeNode.stringToTreeNode("[5,3,6,2,4,7]");
        TreeNode case2 = StringToTreeNode.stringToTreeNode("[50,30,70,40,60,80]");


        System.out.printf("The root is %s%n ", TreeNodeToString.treeNodeToString(case1));
        TreeNode result = bst.deleteNode(case1 , 3);
        System.out.printf("The updated root is %s%n ", TreeNodeToString.treeNodeToString(result));

        System.out.printf("The root is %s%n ", TreeNodeToString.treeNodeToString(case1));
        result = bst.deleteNode(case1 , 0);
        System.out.printf("The updated root is %s%n ", TreeNodeToString.treeNodeToString(result));

        System.out.printf("The root is %s%n ", TreeNodeToString.treeNodeToString(case11));
        result = bst.deleteNodeItr(case11 , 3);
        System.out.printf("The updated root is %s%n ", TreeNodeToString.treeNodeToString(result));

        System.out.printf("The root is %s%n ", TreeNodeToString.treeNodeToString(case11));
        result = bst.deleteNodeItr(case11 , 0);
        System.out.printf("The updated root is %s%n ", TreeNodeToString.treeNodeToString(result));

        System.out.printf("The root is %s%n ", TreeNodeToString.treeNodeToString(case2));
        result = bst.deleteNodeItr(case2 , 50);
        System.out.printf("The updated root is %s%n ", TreeNodeToString.treeNodeToString(result));
    }


}
