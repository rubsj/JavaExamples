/**
 * Created by Ruby Jha on 11/18/2018
 */
package com.ruby.algs.stacksAndQueues.assignment;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue
 * that supports adding and removing items from either the front or the back of the data structure.
 * Create a generic data type Deque that implements the following API:
 * Corner cases.  Throw the specified exception for the following corner cases:
 * Throw a java.lang.IllegalArgumentException if the client calls either addFirst() or addLast() with a null argument.
 * Throw a java.util.NoSuchElementException if the client calls either removeFirst() or removeLast when the deque is empty.
 * Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
 * Throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator.
 * <p>
 * Performance requirements.  Your deque implementation must support each deque operation
 * (including construction) in constant worst-case time. A deque containing n items must use
 * at most 48n + 192 bytes of memory and use space proportional to the number of items currently
 * in the deque. Additionally, your iterator implementation
 * must support each operation (including construction) in constant worst-case time.
 */
public class Deque<Item> implements Iterable<Item> {


    private Node first = null;
    private Node last = null;
    private int size = 0;

    // construct an empty deque
    public Deque() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item to be added to dqueue is null");
        }
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            newNode.next = null;
            newNode.previous = null;
            first = newNode;
            last = newNode;

        } else {
            newNode.next = null;
            newNode.previous = first;
            first.next = newNode;
            first = newNode;
        }

        size++;

    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item to be added to dqueue is null");
        }
        Node newNode = new Node();
        newNode.item = item;
        if (isEmpty()) {
            newNode.next = null;
            newNode.previous = null;
            first = newNode;
            last = newNode;
        } else {
            newNode.next = last;
            newNode.previous = null;
            last.previous = newNode;
            last = newNode;
        }
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("the deque is already empty");
        }
        Item item = first.item;
        if (first.previous != null) { //first's previous is null means its the only node in deque / size 1
            Node temp = first.previous;
            temp.next = null;
            first.previous = null; //this one is to set current first to null
            first = temp;

        } else {
            first = null;
            last = null;
        }
        size--;
        return item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("the deque is already empty");
        }
        Item item = last.item;
        if (last.next != null) {     //last's next is null means its the only node in deque / size 1
            Node temp = last.next;
            temp.previous = null;
            last.next = null; //this one is to set current last to null
            last = temp;
        } else {
            first = null;
            last = null;
        }

        size--;
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // unit testing (optional)
    public static void main(String[] args) {
        Deque<String> stringDeque = new Deque<>();
        stringDeque.addFirst("first item");
        stringDeque.addLast("first item in last");
        stringDeque.addFirst("second first item");
        stringDeque.addLast("second last item");
        while (!stringDeque.isEmpty()) {
            stringDeque.removeFirst();
            stringDeque.removeLast();
        }
    }

    private class Node {
        private Item item;
        private Node next;
        private Node previous;
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current;

        public DequeIterator() {
            current = first;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (null == current) {
                throw new NoSuchElementException("the current node in iterator is null");
            }

            Item item = current.item;
            current = current.next;

            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not supported on Iterator");
        }
    }
}

