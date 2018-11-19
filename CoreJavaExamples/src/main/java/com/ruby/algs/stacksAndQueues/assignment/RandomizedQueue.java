/**
 * created by Ruby Jha on 11/18/2018
 */
package com.ruby.algs.stacksAndQueues.assignment;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Iterator.  Each iterator must return the items in uniformly random order.
 * The order of two or more iterators to the same randomized queue must be mutually independent;
 * each iterator must maintain its own random order.
 * <p>
 * Corner cases.  Throw the specified exception for the following corner cases:
 * Throw a java.lang.IllegalArgumentException if the client calls enqueue() with a null argument.
 * Throw a java.util.NoSuchElementException if the client calls either sample() or dequeue() when the randomized queue is empty.
 * Throw a java.util.NoSuchElementException if the client calls the next() method in the iterator when there are no more items to return.
 * Throw a java.lang.UnsupportedOperationException if the client calls the remove() method in the iterator.
 * <p>
 * Performance requirements.
 * Your randomized queue implementation must support each randomized queue operation
 * (besides creating an iterator) in constant amortized time.
 * That is, any sequence of m randomized queue operations (starting from an empty queue) must take
 * at most cm steps in the worst case, for some constant c.
 * A randomized queue containing n items must use at most 48n + 192 bytes of memory.
 * Additionally, your iterator implementation must support operations next() and hasNext()
 * in constant worst-case time; and construction in linear time;
 * you may (and will need to) use a linear amount of extra memory per iterator.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] itemsInQueue;
    private int queueSize;

    // construct an empty randomized queue
    public RandomizedQueue() {
        itemsInQueue = (Item[]) new Object[2];
        queueSize = 0;
    }


    private void resize(int n) {
        Item[] newItems = (Item[]) new Object[n];
        for (int i = 0; i < queueSize; i++) {
            newItems[i] = itemsInQueue[i];
        }

        itemsInQueue = newItems;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return queueSize == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return queueSize;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("item to be added to queue is null");
        }

        if (queueSize == itemsInQueue.length) {
            resize(queueSize * 2);
        }
        itemsInQueue[queueSize] = item;
        queueSize++;

    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("the queue is empty");
        }

        int randomIndex = StdRandom.uniform(queueSize);
        Item item = itemsInQueue[randomIndex];
        if (randomIndex != queueSize - 1) {
            itemsInQueue[randomIndex] = itemsInQueue[queueSize - 1];
        }
        itemsInQueue[queueSize - 1] = null;
        queueSize--;
        if (queueSize > 0 && queueSize == itemsInQueue.length / 4) {
            resize(itemsInQueue.length / 2);
        }
        return item;
    }

    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException("the queue is empty");
        }
        int randomIndex = StdRandom.uniform(queueSize);
        return itemsInQueue[randomIndex];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedIterator();
    }

    // unit testing (optional)
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue();
        rq.enqueue("1a");
        rq.enqueue("2b");
        rq.enqueue("3c");
        rq.enqueue("4d");
        rq.enqueue("5e");

        for (String s : rq) {
            StdOut.println(s);
        }
        StdOut.println();
        String dequed = rq.dequeue();
        StdOut.println("dequed first " + dequed);

        for (String s : rq) {
            StdOut.println(s);
        }
        StdOut.println();
        dequed = rq.dequeue();
        StdOut.println("dequed second " + dequed);

        for (String s : rq) {
            StdOut.println(s);
        }
        StdOut.println();
    }

    private class RandomizedIterator implements Iterator<Item> {
        private int currIndex;
        private int[] index;  //array of indexes which will be randomized on initalization

        public RandomizedIterator() {
            index = new int[queueSize];
            for (int i = 0; i < queueSize; i++) {
                index[i] = i;
            }
            StdRandom.shuffle(index);
            currIndex = queueSize - 1;
        }

        @Override
        public boolean hasNext() {
            return currIndex >= 0;
        }

        @Override
        public Item next() {
            if (currIndex < 0) {
                throw new NoSuchElementException("the current node in iterator is null");
            }

            Item item = (Item) itemsInQueue[index[currIndex]];
            currIndex--;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove is not supported on Iterator");
        }
    }


}
