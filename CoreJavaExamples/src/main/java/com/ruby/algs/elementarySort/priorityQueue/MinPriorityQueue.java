package com.ruby.algs.elementarySort.priorityQueue;

import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * *  The class represents a priority queue of generic keys.
 * *  It supports the usual <em>insert</em> and <em>delete-the-minimum</em>
 * *  operations, along with methods for peeking at the minimum key,
 * *  testing if the priority queue is empty, and iterating through
 * *  the keys.
 *
 * <p>
 * *  This implementation uses a binary heap.
 * *  The <em>insert</em> and <em>delete-the-minimum</em> operations take
 * *  logarithmic amortized time.
 * *  The <em>min</em>, <em>size</em>, and <em>is-empty</em> operations take constant time.
 * *  Construction takes time proportional to the specified capacity or the number of
 * *  items used to initialize the data structure.
 * *  <p>
 */
@SuppressWarnings("Duplicates")
public class MinPriorityQueue<T> implements Iterable<T> {
    public T[] getPq() {
        return pq;
    }

    private T[] pq;
    private int n;
    private Comparator<T> comparator;

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new HeapIterator();
    }

    private class HeapIterator implements Iterator<T> {
        private MinPriorityQueue<T> copy;

        public HeapIterator() {
            if (comparator == null) {
                copy = new MinPriorityQueue<>(size());
            } else {
                copy = new MinPriorityQueue<>(size(), comparator);
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
            return copy.deleteMin();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public MinPriorityQueue() {
        this(1);
    }

    public MinPriorityQueue(int capacity) {
        pq = (T[]) new Object[capacity + 1];
        n = 0;
    }

    public MinPriorityQueue(Comparator<T> comparator) {
        this(1, comparator);

    }

    public MinPriorityQueue(int capacity, Comparator<T> comparator) {
        this.comparator = comparator;
        pq = (T[]) new Object[capacity + 1];
        n = 0;
    }

    public MinPriorityQueue(T[] items) {
       n = items.length;
       pq = (T[])new Object[items.length+1];
        for (int i = 0; i < items.length; i++) {
            pq[i + 1] = items[i];
        }
        for(int k=n/2; k>=1;k--){
            sink(k);
        }
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n==0;
    }

    public T min(){
        if (isEmpty()) throw new NoSuchElementException("Max oriented priority queue underflow");
        return pq[1];
    }

    public void add(T item) {
        if(n==pq.length-1){
            resize(2*pq.length);
        }
        pq[++n]=item;
        swim(n);
    }

    public T deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("Max oriented priority queue underflow");
       T min = pq[1];
       swap(1 , n--);
       sink(1);
       pq[n+1]=null;
       if(n>0 && (n==(pq.length-1)/4)){
           resize(pq.length/2);
       }
        return min;
    }

    //methods to check if balanced maxHeap // is pq[1..N] a max heap?
    public boolean isMinHeap(){
        return isMinHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a max heap?
    private boolean isMinHeap(int k){
        if(k>n) return true;  //if all childs have passed truthy test k will reach beyond max size and thats when its true for sure
        int left = 2*k;
        int right = 2*k+1;
        if(left <=n && greater(k ,left)) return false;
        if(right <=n && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right); //when each subnode is true the heap is true
    }


    // if v <w
    private boolean greater(int i, int j) {
       if(comparator==null){
           return ((Comparable<T>)pq[i]).compareTo(pq[j])>0;
       }else{
           return comparator.compare(pq[i], pq[j]) >0;
       }
    }

    private void swap(int i, int j) {
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private void sink(int k){
        while(2*k <=n){
            int j = 2*k;
            if(j<n && greater(j , j+1)) j++;
            if(!greater(k , j)) break;
            swap(k ,j);
            k=j;
        }
    }

    private void swim(int k){
        while(k>1 && greater(k/2 , k)){
            swap(k, k/2);
            k=k/2;
        }
    }

    private void resize(int capacity) {
        T[] temp = (T[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{4, 6, 7, 2, 1, 9, 11, 23, 33, 44, 55};
        MinPriorityQueue<Integer> minPQ = new MinPriorityQueue<>();
        for (int i = 0; i < data.length; i++) {
            minPQ.add(data[i]);
        }
        Object[] temp = minPQ.getPq();
        for (int i = 0; i <=minPQ.size() ; i++) {
            System.out.println(temp[i]);
        }

        Iterator<Integer> itr = minPQ.iterator();
        while(itr.hasNext()){
            Integer next = itr.next();
            System.out.println(next);
        }

    }


}
