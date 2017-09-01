package com.ruby.datastructure;

/**
 * Created by rjha on 12/30/2016.
 */
public class LinkedListExample {
    public static void main(String[] args) {
        LinkedNode node1 = new LinkedNode();
        node1.data=1;
        LinkedNode node2 = new LinkedNode();
        node2.data=2;
        LinkedNode node3 = new LinkedNode();
        node3.data = 3;
        LinkedNode node4 = new LinkedNode();
        LinkedNode node5 = new LinkedNode();
        node1.next=node2;
        node2.next=node3;
        node3.next=null;

        LinkedListExample test = new LinkedListExample();
        test.Print(node4);
        test.Print(node1);


    }


    void Print(LinkedNode head) {
        if(head!=null){
            System.out.println(head.data);
        }

        if (head.next != null) {
            Print(head.next);
        }
    }
}

class LinkedNode {
    int data;
    LinkedNode next;
}


