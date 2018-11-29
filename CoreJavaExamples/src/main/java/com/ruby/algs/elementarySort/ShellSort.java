/**
 * created by Ruby Jha on 11/29/2018
 */
package com.ruby.algs.elementarySort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class ShellSort {
    private static void swap(Object[] items, int i, int j) {
        Object temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private static boolean isLess(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public void sort(Comparable[] items) {
        int arraySize = items.length;
        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < arraySize / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // h-sort the array
            for (int i = h; i < arraySize; i++) {
                for (int j = i; j >= h && isLess(items[j], items[j - h]); j = j - h) {
                    swap(items, j, j - h);
                }
            }
            h = h / 3;
        }

    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        String[] a = StdIn.readAllStrings();
        shellSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }
}

