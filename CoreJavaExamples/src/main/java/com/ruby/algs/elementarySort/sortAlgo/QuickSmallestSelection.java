package com.ruby.algs.elementarySort.sortAlgo;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings("Duplicates")
public class QuickSmallestSelection {
    // if v <w
    private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false; // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    private static void swap(Comparable[] items, int i, int j) {
        Comparable temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }

    private static int partition(Comparable[] items, int low, int high){
        int i=low;
        int j= high+1;
        Comparable v = items[low];
        while(true){
          while(less(items[++i],v)){
              if(i==high)break;
          }

          while(less(v , items[--j])){
              if(j==low)break;
          }

          if(i>=j)break;
          swap(items, i, j);
        }
        // put partitioning item v at a[j]
        swap(items, low , j);
        return j;
    }

    //Rearranges the array so that {@code items[k]} contains the kth smallest key;
    public static Comparable select(Comparable[] items, int k){
       if(k<0 || k>=items.length){
          throw new IllegalArgumentException("Index is not in range 0 -" + items.length);
       }
        StdRandom.shuffle(items);
       int low=0 , high=items.length-1;
       while(high>low){
           int i = partition(items , low , high);
           if(i>k) high = i-1;
           else if(i<k) low = i+1;
           else return items[i];
       }

       return items[low];
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        //show smallest elements at any point
        for (int i = 0; i < a.length; i++) {
            String ith = (String) QuickSmallestSelection.select(a, i);
            StdOut.println(ith);
        }
    }
}
