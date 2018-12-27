package com.ruby.algs.elementarySort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.NoSuchElementException;

/**
 * created by Ruby Jha on 12/12/2018
 * <p>
 * Shuffling a linked list.
 * Given a singly-linked list containing n items, rearrange the items uniformly at random.
 * Your algorithm should consume a logarithmic (or constant) amount of extra memory and run in time proportional to nlogn in the worst case.
 * <p>
 * refer- https://stackoverflow.com/questions/12167630/algorithm-for-shuffling-a-linked-list-in-n-log-n-time/12168162#12168162
 * https://stackoverflow.com/questions/26704201/shuffling-a-singly-linked-list-using-up-to-log-n-extra-memory-and-n-log-n-time
 */
public class ShuffleLinkedList {
    private static class Node {
        Object item;
        Node next;
    }

    private class LinkedList {
        private Node first;
        private int size = 0;

        public boolean isEmpty() {
            return first == null;
        }

        public LinkedList() {
            first = null;
            size = 0;
        }

        public void push(Object item) {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            size++;

        }

        public Object pop() {
            if (isEmpty()) throw new NoSuchElementException("LinkedList underflow");
            Object item = first.item;        // save item to return
            first = first.next;            // delete first node
            size--;
            return item;                   // return the saved item
        }

        public int size() {
            return size;
        }

        public Object peek() {
            if (isEmpty()) throw new NoSuchElementException("LinkedList underflow");
            return first.item;
        }
    }

    public void shuffle(LinkedList shuffleLinkedList) {
        if (shuffleLinkedList.size() == 1) return;
        LinkedList left = new LinkedList();
        LinkedList right = new LinkedList();

        //to devide list into two segments toss a coin and push to left first if random val=1 else to right first and the very moment push to the next list too
        while (!shuffleLinkedList.isEmpty()) {
           if(StdRandom.uniform(2)>0){
               left.push(shuffleLinkedList.pop());
               if (! shuffleLinkedList.isEmpty()){
                   right.push(shuffleLinkedList.pop());
               }
           }else{
               right.push(shuffleLinkedList.pop());
               if (! shuffleLinkedList.isEmpty()){
                   left.push(shuffleLinkedList.pop());
               }
           }

        }
        //this while works too but too add more randomness in result used above while
  /*      while (! shuffleLinkedList.isEmpty())
        {
            left.push(shuffleLinkedList.pop());
            if (! shuffleLinkedList.isEmpty()) right.push(shuffleLinkedList.pop());
        }*/

        shuffle(left);
        shuffle(right);
        merge(shuffleLinkedList, left, right);

    }

    public void merge(LinkedList finalList, LinkedList leftList, LinkedList rightList) {

        while (leftList.size() != 0 && rightList.size() != 0) {
            int chance = StdRandom.uniform(2);  // push from left or right depending on random probability of choice
            if (chance > 0) {
                finalList.push(leftList.pop());
            } else {
                finalList.push(rightList.pop());
            }
        }

        if (!leftList.isEmpty()) {
            while (!leftList.isEmpty()) {
                finalList.push(leftList.pop());
            }
        }
        if (!rightList.isEmpty()) {
            while (!rightList.isEmpty()) {
                finalList.push(rightList.pop());
            }
        }
    }


    public static void main(String[] args) {
        ShuffleLinkedList shuffleLinkedList = new ShuffleLinkedList();
        LinkedList linkedList = shuffleLinkedList.new LinkedList();

        String[] a = StdIn.readAllStrings();
        for (int k = 0; k < 200; k++) {

            for (int i = 0; i < a.length; i++) {
                linkedList.push(a[i]);
            }
            shuffleLinkedList.shuffle(linkedList);
            int loop = linkedList.size();
            for (int j = 0; j < loop; j++) {
                StdOut.print(linkedList.pop() + " ");
            }
            StdOut.println();

        }


    }
}


            /*    Node currentNode  = buildNodeList;
            while(currentNode.next!=null){
                currentNode = currentNode.next;

            }
            Node buildOnNode =  shuffleLinkedList.new Node(a[i]);
            currentNode.next=buildOnNode;*/
