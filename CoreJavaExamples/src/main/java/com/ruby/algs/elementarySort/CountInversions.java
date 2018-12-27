package com.ruby.algs.elementarySort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Ruby Jha on 12/14/2018
 *
 * Counting inversions.
 * An inversion in an array a[] is a pair of entries a[i] and a[j] such that i < j but a[i] > a[j].
 * Given an array, design a linearithmic algorithm to count the number of inversions.
 *
 */
public class CountInversions {
    //use merge sort bottom up appraoch to count the inversion
    public int getInversionCount(int[] a){
       int count =0;
       int arraySize = a.length;
       int[] aux = new int[arraySize];
       int[] b = a.clone();
       for(int subArrLen=1; subArrLen<arraySize; subArrLen=subArrLen*2){
         for(int low=0; low< arraySize-subArrLen; low = low + subArrLen*2){
             int high= Math.min(low+subArrLen*2-1 , arraySize-1);
             int mid = low+subArrLen-1;
             count += merge(a , aux , low , mid , high);
         }
       }

       return count;
    }
    @SuppressWarnings("Duplicates")
    private int merge(int[] dest, int[] src, int low, int mid, int high) {
        int count = 0;
        for (int m = low; m <= high; m++) {
            src[m] = dest[m];
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
                /**
                 * the number of positions that it moves is that many inversions it passed because array is getting sorted while counting it
                 * which is the relative length of the left side of the array minus the index of the current element in the left side
                 * because that is the number of elements which the element in the right side of the array had to skip over (# of inversions) to become sorted
                 */
                count = count + (mid - i + 1);

            } else {

                dest[k] = src[i++];

            }
        }
      return count;
    }

    private static boolean isLess(int v, int w) {
        return v - w < 0;
    }


    private int bruteForceCount(int[] a) {
        int inversions = 0;
        int arraySize = a.length;
        for (int i = 0; i < arraySize; i++){
            for (int j = i + 1; j < arraySize; j++){
                if (a[j] < a[i]) {
                    inversions++;
                }
            }

        }

        return inversions;
    }

    public static void main(String[] args) {
        CountInversions countInversions = new CountInversions();
        int[] a = StdIn.readAllInts();
        int bruteForceCount = countInversions.bruteForceCount(a);
        int inversions = countInversions.getInversionCount(a);
        for (int i = 0; i < a.length; i++) {
            StdOut.print(a[i] + " ");
        }
        StdOut.println();
        StdOut.println("brute count of inversion is  :" + bruteForceCount);
        StdOut.println("count of inversion is  :" + inversions);

    }
}
