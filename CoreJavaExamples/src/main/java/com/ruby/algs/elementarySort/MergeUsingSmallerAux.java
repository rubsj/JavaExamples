package com.ruby.algs.elementarySort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * created by Ruby Jha on 12/14/2018
 *
 * Merging with smaller auxiliary array.
 * Suppose that the subarray a[0] to a[n−1] is sorted and the subarray a[n] to a[2∗n−1] is sorted.
 * How can you merge the two subarrays so that a[0] to a[2∗n−1] is sorted using an auxiliary array of length n (instead of 2n)?
 */
@SuppressWarnings("Duplicates")
public class MergeUsingSmallerAux {


    private static boolean isLess(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }


    public void sort(Comparable[] items) {
        int arraySize = items.length;
        Comparable[] aux = new Comparable[arraySize]; //change it to arraySize
        for(int subArrLen = 1 ; subArrLen< arraySize ; subArrLen = subArrLen*2){  //execute for subarray size 2/4/8/16 etc
            for(int low=0; low< arraySize-subArrLen; low= low+subArrLen*2){ // each subaaray within array
                int high = Math.min(low+subArrLen*2-1, arraySize-1 );
                int mid = low + subArrLen -1;
                merge(  aux , items ,  low , mid , high , subArrLen);
            }
        }

    }


    private static void merge(Comparable[] src, Comparable[] dest, int low, int mid, int high, int subArrLen ){

        for (int k = 0; k < subArrLen; k++) {
            int arrIndx = k+low;
            src[k] = dest[arrIndx];
        }

        int i = low;
        int j = mid + 1;
        int arrayIndexEnd = high-low;
        int auxindex =  0;
        for(int k=0; k<=arrayIndexEnd; k++){
            int arrIndex = k+low;
            if(i>mid){
                dest[arrIndex]=dest[j++];
            }else if(j>high){
                dest[arrIndex]=src[auxindex++];
                i++;
            }else if(isLess(dest[j],src[auxindex] )){
                dest[arrIndex]=dest[j++];
            }else{
                dest[arrIndex]=src[auxindex++];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        MergeUsingSmallerAux mergeSort = new MergeUsingSmallerAux();
        String[] a = StdIn.readAllStrings();
        mergeSort.sort(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
    }

}
