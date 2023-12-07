package com.ruby.neetcode.datastructures;

public class DoublyLinkedList {
    DoublyLinkedListNode head;
    DoublyLinkedListNode tail;

    public DoublyLinkedList(){
        // Init the list with 'dummy' head and tail nodes which makes
        // edge cases for insert & remove easier.
        head = new DoublyLinkedListNode(-1);
        tail = new DoublyLinkedListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    public void insertFront(int val){
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(val);
        newNode.prev = head;
        newNode.next = head.next;

        head.next.prev = newNode;
        head.next = newNode;
    }

    public void insertEnd(int val){
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(val);
        newNode.next = tail;
        newNode.prev = tail.prev;

        tail.prev.next = newNode;
        tail.prev = newNode;
    }

    // Remove first node after dummy head (assume it exists)
    public void removeFront(){
        head.next.next.prev = head;
        head.next = head.next.next;
    }

    // Remove last node before dummy tail (assume it exists)
    public void removeEnd(){
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }

    public void print(){
        DoublyLinkedListNode curr = head.next;
        while(curr != tail){
            System.out.print(curr.val + " ->");
            curr = curr.next;
        }
        System.out.println();
    }
}
