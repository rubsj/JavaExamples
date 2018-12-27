/**
 * Created by Ruby Jha on 11/29/2018
 */
package com.ruby.algs.elementarySort.sortAlgo;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class MergeSortImproved {
    final int CUTOFF = 7;
    
    private static boolean isLess(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    public void sort(Comparable[] items){
        Comparable[] aux = items.clone();
        sort(aux , items , 0 , items.length-1);

    }

    public void sort(Comparable[] src , Comparable[] dst , int low , int high){
      //if(low>=high) return;
        if (high <= low + CUTOFF) {
            insertionSort(dst, low, high);
            return;
        }
      
        int mid = low + (high -low)/2;
        sort(dst ,src ,  low , mid);
        sort(dst ,src ,    mid+1 , high);
        if (!isLess(src[mid+1], src[mid])) {
            System.arraycopy(src, low, dst, low, high - low + 1);
            return;
        }
        merge(src , dst, low , mid , high);
    }

    @SuppressWarnings("Duplicates")
    private static void merge(Comparable[] src ,Comparable[] dest ,  int low , int mid, int high){
        int i = low;
        int j = mid+1;
        for(int k = low ; k<= high; k++){
            if(i>mid){
                dest[k]=src[j++];
            }else if(j>high){
                dest[k]= src[i++];
            }else if(isLess(src[i], src[j] )){
                dest[k]= src[i++];
            }else{
                dest[k]= src[j++];
            }
        }

    }

    private static void insertionSort(Comparable[] items, int low, int high) {
        for (int i = low; i <= high; i++)
            for (int j = i; j > low && isLess(items[j], items[j-1]); j--)
                swap(items, j, j-1);
    }

    private static void swap(Object[] items , int i , int j){
        Object temp = items[i];
        items[i]=items[j];
        items[j]=temp;
    }



    public static void main(String[] args) {
        MergeSortImproved mergeSort = new MergeSortImproved();
        String[] a = StdIn.readAllStrings();
        mergeSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }
}

