/**
 * Created by Ruby Jha on 11/29/2018
 */
package com.ruby.algs.elementarySort.sortAlgo;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("Duplicates")
public class MergeSortUsingAux {

    private static boolean isLess(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void sort(Comparable[] aux , Comparable[] original , int low , int high){
         if(low >=high) return;
         int mid = low + (high -low)/2;
         sort(aux , original , low , mid);
         sort(aux , original , mid+1 , high);
         merge(aux , original , low , mid , high);
    }

    private static void merge(Comparable[] aux , Comparable[] original , int low , int mid, int high){
        // copy to aux[]
        for (int i = low; i <= high ; i++) {
             aux[i]= original[i];
        }

        int i=low;
        int j= mid+1;

        // merge back to a[]
        for(int k=low ; k<=high; k++){
           if(i>mid){
               original[k]=aux[j++];
           }else if(j>high){
               original[k]=aux[i++];
           }else if(isLess(aux[i] , aux[j])){
               original[k]=aux[i++];
           }else{
               original[k]=aux[j++];
           }
        }

    }


    public void sort(Comparable[] items){
        Comparable[] aux = new Comparable[items.length];
        sort(aux , items , 0 , items.length-1);
 
    }

    public static void main(String[] args) {
        MergeSortUsingAux mergeSort = new MergeSortUsingAux();
        String[] a = StdIn.readAllStrings();
        mergeSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }

}

