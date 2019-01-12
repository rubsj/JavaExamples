package com.ruby.algs.elementarySort.sortAlgo;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings("Duplicates")
public class QuickSort {
    // if v <w
    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false; // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    public void sort(Comparable[] items) {
        StdRandom.shuffle(items);
        sort(items, 0, items.length - 1);
    }

    public void sort(Comparable[] items, int low, int high) {
        if (high <= low) return;
        int partitionPoint = partition(items, low, high);
        sort(items, low, partitionPoint - 1);
        sort(items, partitionPoint + 1, high);
    }

    private int partition(Comparable[] items, int low, int high) {
        int i = low;
        int j = high+1;
        Comparable v = items[low];
        while (true) {
            // find item on low to swap
            while (less(items[++i], v)) {
                if (i == high) break;
            }
            // find item on high to swap
            while (less(v, items[--j])) {
                /**
                 * in our implementation the test of the J pointer running off the left 
                 * end is redundant. Why is it redundant? 
                 * Well, the partitioning element is sitting there and it'll stop when it hits the
                 * partitioning element.
                 */
                if (j == low) break; // redundant since a[lo] acts as sentinel
            }
            // check if pointers cross
            if (i >= j) break;
            swap(items, i, j);

        }
        // put partitioning item v at a[j]
        swap(items, low, j);
        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    private void swap(Comparable[] items, int i, int j) {
        Comparable temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    // print array to standard output
    public static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }

    public static void main(String[] args) {
        String[] items = StdIn.readAllStrings();
        QuickSort quickSort = new QuickSort();
        quickSort.sort(items);
        quickSort.show(items);
    }
}
