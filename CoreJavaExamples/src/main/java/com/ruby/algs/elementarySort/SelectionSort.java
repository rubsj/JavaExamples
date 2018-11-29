/**
 * created by Ruby Jha on 11/27/2018
 */
package com.ruby.algs.elementarySort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class SelectionSort {
    private static void swap(Object[] items , int i , int j){
       Object temp = items[i];
       items[i]=items[j];
       items[j]=temp;
    }

    private boolean isLess(Comparable a , Comparable b){
        return a.compareTo(b) <0;
    }

    private boolean isSorted(Comparable[] items , int lo, int hi){
        for(int i=lo+1; i<=hi ; i++){
            if(isLess(items[i] , items[i-1])){
                return false;
            }
        }

        return true;
    }

    public void sort(Comparable[] items){
        int arraySize= items.length;
        for (int i = 0; i < arraySize ; i++) {
           int min = i;
           for(int j =i+1 ; j < arraySize; j++){
               if(isLess(items[j] , items[min])){
                   min=j;
               }
           }
           swap(items , i , min);
        }
    }

    public static void main(String[] args) {
        SelectionSort selectionSort = new SelectionSort();
        String[] a = StdIn.readAllStrings();
        selectionSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }

}

