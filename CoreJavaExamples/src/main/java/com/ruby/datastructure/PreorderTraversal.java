package com.ruby.datastructure;


/**
 * Created by rjha on 12/29/2016.
 */
public class PreorderTraversal {
    public static void main(String[] args) {
           Node root = new Node();
           root.data=3;
        Node root1 = new Node();
        root1.data=1;
        Node root2 = new Node();
        root2.data=4;
        Node root3 = new Node();
        root3.data = 6;
        Node root4 = new Node();
        root4.data=2;
        Node root5 = new Node();
        root5.data =5;
        root.left=root5;
        root.right=root4;
        root5.left=root1;
        root5.right=root2;
        root4.left=root3;

        new PreorderTraversal().preOrder(root);

    }
    void preOrder(Node root) {
        System.out.print(root.data + " ");

        if (root.left != null) {
            preOrder(root.left);
        }

        if (root.right != null) {
            preOrder(root.right);
        }

    }
}

class Node {
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    int data;
    Node left;
    Node right;
}
