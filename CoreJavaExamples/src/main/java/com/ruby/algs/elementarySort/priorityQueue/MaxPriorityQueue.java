package com.ruby.algs.elementarySort.priorityQueue;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * The class represents a priority queue of generic keys.
 * It supports the usual <em>insert</em> and <em>delete-the-maximum</em>
 * operations, along with methods for peeking at the maximum key,
 * testing if the priority queue is empty, and iterating through
 * the keys.
 * <p>
 * This implementation uses a binary heap.
 * The <em>insert</em> and <em>delete-the-maximum</em> operations take
 * logarithmic amortized time.
 * The <em>max</em>, <em>size</em>, and <em>is-empty</em> operations take constant time.
 * Construction takes time proportional to the specified capacity or the number of
 * items used to initialize the data structure.
 * <p>
 */
@SuppressWarnings("Duplicates")
public class MaxPriorityQueue<T> implements Iterable<T> {
    public T[] getPq() {
        return pq;
    }

    private T[] pq; //stores items at indices 1 to n
    private int n; // number of items on queue;
    private Comparator<T> comparator; //optional comparator;

    //all private utility functions

    // sink function moves the item down from top branch till the bottom most node
    private void sink(int k) {
        while (2 * k <= n) { //since sink moves down it can go to max size of array ..which should be 2k or 2k+1 for balanced binary tree
            int j = 2 * k; //for an item at k the child will be 2k and 2k+1
            if (j < n && less(j, j + 1)) j++; //check if child at 2k is smaller than 2k+1 , use 2k+1

            if (!less(k, j)) break; //if child is not smaller than parent break out of loop

            swap(k, j); //if child is smaller swap it with parent
            k = j; //after swapping this child node becomes parent and we need to iterate for it

        }

    }

    private void swim(int k) {

        while (k > 1 && less(k / 2, k)) { //move up till topmost root while the parent is smaller than child

            swap(k, k / 2); //parent resides at k/2 integer division
            k = k / 2;
        }

    }

    private boolean less(int i, int j) {
        if (comparator == null) {

            return ((Comparable<T>) pq[i]).compareTo(pq[j]) < 0;
        } else {

            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    private void swap(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }


    // possible initializations

    public MaxPriorityQueue(int initialCapacity) {
        pq = (T[]) new Object[initialCapacity + 1];
        n = 0;
    }

    public MaxPriorityQueue() {
        this(1);
    }

    public MaxPriorityQueue(int initialCapacity, Comparator<T> comparator) {
        this.comparator = comparator;
        pq = (T[]) new Object[initialCapacity + 1];
        n = 0;
    }


    public MaxPriorityQueue(Comparator<T> comparator) {
        this(1, comparator);
    }

    public MaxPriorityQueue(T[] items) {
        n = items.length;
        pq = (T[]) new Object[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            pq[i + 1] = items[i];
        }
        for (int k = n / 2; k >= 1; k--) { //all the parents would lie only in first half of array so
            sink(k);  //start index of for loop should ne n/2 and perform sink operation on that
        }
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public T max() {
        if (isEmpty()) throw new NoSuchElementException("Max oriented priority queue underflow");
        return pq[1];
    }

    public void add(T item) {
        //resize if queue almost full
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        //add item and percolate to maintain variant
        pq[++n] = item;
        swim(n);
    }

    public T deleteMax() {
        if (isEmpty()) throw new NoSuchElementException("Max oriented priority queue underflow");
        T max = pq[1];
        swap(1, n--);
        sink(1);
        pq[n + 1] = null; //to avoid data loitering and help GC
        if (n > 0 && (n == (pq.length - 1) / 4)) {
            resize(pq.length / 2);
        }

        return max;
    }

    //methods to check if balanced maxHeap // is pq[1..N] a max heap?
    public boolean isMaxHeap() {
        return isMaxHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a max heap?
    private boolean isMaxHeap(int k) {
        if (k > n)
            return true;  //if all childs have passed truthy test k will reach beyond max size and thats when its true for sure
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left <= n && less(k, left)) return false;
        if (right <= n && less(k, right)) return false;
        return isMaxHeap(left) && isMaxHeap(right); //when each subnode is true the heap is true
    }

    public Iterator<T> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<T> {
        private MaxPriorityQueue<T> copy;

        //add all items to copy of heap
        public HeapIterator() {
            if (comparator == null) {
                copy = new MaxPriorityQueue<>(size());
            } else {
                copy = new MaxPriorityQueue<>(size(), comparator);
            }

            for (int i = 1; i <= size(); i++) {
                copy.add(pq[i]);
            }
        }

        @Override
        public boolean hasNext() {
            return !copy.isEmpty();
        }

        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return copy.deleteMax();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
/*        MaxPriorityQueue<String> pq = new MaxPriorityQueue<>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) pq.add(item);
            else if (!pq.isEmpty()) StdOut.print(pq.deleteMax() + " ");
        }
        StdOut.println("(" + pq.size() + " left on pq)");*/
        Integer[] data = new Integer[]{4, 6, 7, 2, 1, 9, 11, 23, 33, 44, 55};
        MaxPriorityQueue<Integer> minPQ = new MaxPriorityQueue<>();
        for (int i = 0; i < data.length; i++) {
            minPQ.add(data[i]);
        }

        Iterator<Integer> itr = minPQ.iterator();
        while (itr.hasNext()) {
            Integer next = itr.next();
            System.out.println(next);
        }
    }


}
