/**
 * Created by Ruby Jha on 12/07/2018
 */
package com.ruby.algs.elementarySort.sortAlgo;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("Duplicates")
public class MergeSortBottomUp {

    private static void merge(Comparable[] src, Comparable[] dest, int low, int mid, int high) {

        // copy to src[] because previous merge has updated the destination
        for (int k = low; k <= high; k++) {
            src[k] = dest[k];
        }
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                dest[k] = src[j++];
            } else if (j > high) {
                dest[k] = src[i++];
            } else if (isLess(src[j], src[i])) {
                dest[k] = src[j++];
            } else {
                dest[k] = src[i++];

            }
        }

    }

    private static boolean isLess(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void sort(Comparable[] items) {
        int arraySize = items.length;
        Comparable[] aux = new Comparable[arraySize];
        for (int subArrLen = 1; subArrLen < arraySize; subArrLen = subArrLen * 2) {  //execute for subarray size 2/4/8/16 etc
            for (int low = 0; low < arraySize - subArrLen; low = low + subArrLen * 2) { // each subaaray within array
                int high = Math.min(low + subArrLen * 2 - 1, arraySize - 1);
                int mid = low + subArrLen - 1;
                merge(aux, items, low, mid, high);
            }
        }

    }


    public static void main(String[] args) {
        MergeSortBottomUp mergeSort = new MergeSortBottomUp();
        String[] a = StdIn.readAllStrings();
        mergeSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }
}

