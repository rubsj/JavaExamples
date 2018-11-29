/**
 * created by Ruby Jha on 11/27/2018
 */
package com.ruby.algs.elementarySort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InsertionSort {

    private static void swap(Object[] items , int i , int j){
        Object temp = items[i];
        items[i]=items[j];
        items[j]=temp;
    }

    private boolean isLess(Comparable a , Comparable b){
        return a.compareTo(b) <0;
    }

    public void sort(Comparable[] items){
        int arraySize = items.length;
        for (int i=0 ; i< arraySize ; i++){
            for(int j=i; j>0 && isLess(items[j], items[j-1]); j--){
                swap(items , j , j-1);
            }
        }
    }

    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        String[] a = StdIn.readAllStrings();
        insertionSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }
}

