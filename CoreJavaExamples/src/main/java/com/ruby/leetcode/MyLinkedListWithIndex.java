package com.ruby.leetcode;

/**
 * Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
 * A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
 * If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.
 *
 * Implement the MyLinkedList class:
 *
 * MyLinkedList() Initializes the MyLinkedList object.
 * int get(int index) Get the value of the indexth node in the linked list. If the index is invalid, return -1.
 * void addAtHead(int val) Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
 * void addAtTail(int val) Append a node of value val as the last element of the linked list.
 * void addAtIndex(int index, int val) Add a node of value val before the indexth node in the linked list. If index equals the length of the linked list, the node will be appended to the end of the linked list. If index is greater than the length, the node will not be inserted.
 * void deleteAtIndex(int index) Delete the indexth node in the linked list, if the index is valid.
 *
 *
 * Example 1:
 *
 * Input
 * ["MyLinkedList", "addAtHead", "addAtTail", "addAtIndex", "get", "deleteAtIndex", "get"]
 * [[], [1], [3], [1, 2], [1], [1], [1]]
 * Output
 * [null, null, null, null, 2, null, 3]
 *
 * Explanation
 * MyLinkedList myLinkedList = new MyLinkedList();
 * myLinkedList.addAtHead(1);
 * myLinkedList.addAtTail(3);
 * myLinkedList.addAtIndex(1, 2);    // linked list becomes 1->2->3
 * myLinkedList.get(1);              // return 2
 * myLinkedList.deleteAtIndex(1);    // now the linked list is 1->3
 * myLinkedList.get(1);              // return 3
 *
 *
 * Constraints:
 *
 * 0 <= index, val <= 1000
 * Please do not use the built-in LinkedList library.
 * At most 2000 calls will be made to get, addAtHead, addAtTail, addAtIndex and deleteAtIndex.
 */
// solution with index saved with each node
public class MyLinkedListWithIndex {
    MyLinkedListWithIndexNode head;
    MyLinkedListWithIndexNode tail;
    public MyLinkedListWithIndex() {
        head = new MyLinkedListWithIndexNode(-1, -1);
        tail = new MyLinkedListWithIndexNode(-2, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int index) {
        MyLinkedListWithIndexNode curr = findCurrNode(index);
        return curr.val;
    }

    public void addAtHead(int val) {
        MyLinkedListWithIndexNode newNode = new MyLinkedListWithIndexNode(0, val);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        // update the index of all the next elements
        updateIndex(newNode.next, true);
    }

    public void addAtTail(int val) {
        MyLinkedListWithIndexNode newNode = new MyLinkedListWithIndexNode(tail.prev.index + 1, val);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;

    }

    public void addAtIndex(int index, int val) {
        MyLinkedListWithIndexNode curr = findCurrNode(index);
        if(curr.index == tail.index && index != tail.prev.index +1){
            return ;
        }
        MyLinkedListWithIndexNode newNode = new MyLinkedListWithIndexNode(index , val);
        newNode.next = curr;
        newNode.prev = curr.prev;
        curr.prev.next = newNode;
        curr.prev = newNode;
        updateIndex(curr, true);
    }

    public void deleteAtIndex(int index) {
        MyLinkedListWithIndexNode curr = findCurrNode(index);
        if(curr == tail){
            return ;
        }
        curr.next.prev = curr.prev;
        curr.prev.next = curr.next;
        updateIndex(curr.next , false);
    }

    private MyLinkedListWithIndexNode findCurrNode(int index){
        MyLinkedListWithIndexNode curr = head;
        int i = head.index;
        while(index != i && i != tail.index){
            i = curr.next.index;
            curr = curr.next;
        }

        return curr;
    }

    private void updateIndex(MyLinkedListWithIndexNode node, boolean increment){
        MyLinkedListWithIndexNode curr = node;
        while(curr.index != tail.index){
            curr.index= increment ? curr.index +1 : curr.index -1;
            curr = curr.next;
        }
    }

    public void print(){
        MyLinkedListWithIndexNode curr = head.next;
        while(curr != tail){
            System.out.print(curr.val + " ->");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        MyLinkedListWithIndex myLinkedListWithIndex = new MyLinkedListWithIndex();
        myLinkedListWithIndex.addAtHead(1);
        myLinkedListWithIndex.print();

        myLinkedListWithIndex.addAtTail(3);
        myLinkedListWithIndex.print();

        myLinkedListWithIndex.addAtIndex(1, 2);    // linked list becomes 1->2->3
        myLinkedListWithIndex.print();

        int getVal =  myLinkedListWithIndex.get(1);              // return 2
        System.out.printf("getVal 1 : %d%n", getVal);

        myLinkedListWithIndex.deleteAtIndex(1);
        myLinkedListWithIndex.print();

        getVal = myLinkedListWithIndex.get(1);              // return 3
        System.out.printf("getVal 1 : %d%n", getVal);

    }
}

class MyLinkedListWithIndexNode {
    int val;
    int index;
    MyLinkedListWithIndexNode next;
    MyLinkedListWithIndexNode prev;

    public MyLinkedListWithIndexNode(int index, int val){
        this.val = val;
        this.index = index;
        this.next = null;
        this.prev = null;
    }

}


