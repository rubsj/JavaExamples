package com.ruby.algs.elementarySort.priorityQueue;

import edu.princeton.cs.algs4.StdOut;

/**
 * Heap sorting of array follows principle of balanced heap and similar structure as priorityQueues
 */
@SuppressWarnings("Duplicates")
public class HeapSort {

    private boolean less(Comparable[] items, int i, int j) {
        if (items[i - 1] == items[j - 1]) return false; // optimization when reference equals
        return items[i - 1].compareTo(items[j - 1]) < 0;
    }


    private void swap(Comparable[] items, int i, int j) {
        Comparable temp = items[i - 1];
        items[i - 1] = items[j - 1];
        items[j - 1] = temp;
    }

    // print array to standard output
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }

    private void sink(Comparable[] items, int sinkIndex, int lastIndex) {
        while (2 * sinkIndex <= lastIndex) {
            int j = 2 * sinkIndex;
            if (j < lastIndex && less(items, j, j + 1)) j++;
            if (!less(items, sinkIndex, j)) break;
            swap(items, j, sinkIndex);
            sinkIndex = j;
        }
    }

    public void sort(Comparable[] items) {
        int n = items.length;
        for (int i = n / 2; i >= 1; i--) {
            sink(items, i, n);
        }
        while (n > 1) {
            swap(items, 1, n--);
            sink(items, 1, n);
        }
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        String[] input = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        HeapSort.show(input);
        System.out.println();
        heapSort.sort(input);
        HeapSort.show(input);
    }
}
