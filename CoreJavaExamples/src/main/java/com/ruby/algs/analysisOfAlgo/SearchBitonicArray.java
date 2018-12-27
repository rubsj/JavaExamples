package com.ruby.algs.analysisOfAlgo;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Search in a bitonic array. An array is bitonic if it is comprised of an increasing sequence of integers followed
 * immediately by a decreasing sequence of integers.
 * Write a program that, given a bitonic array of n distinct integer values,
 * determines whether a given integer is in the array.
 * <p>
 * Standard version: Use ∼3lgn compares in the worst case.
 * Signing bonus: Use ∼2lgn compares in the worst case
 * (and prove that no algorithm can guarantee to perform fewer than ∼2lgn compares in the worst case).
 */
public class SearchBitonicArray {

    private class SearchBitonicArrayIn3Lgn{
        public int getBitonicPoint(int[] input){
            
          return 0;
        }
    }

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public int getMax(int[] input){
       int low=0;
       int high= input.length;
       while(low<=high){
           int mid = low + (high+low)/2;
           
       }
       return 0;
    }

    private class SearchBitonicArrayUsingBuiltInMethods {
        public boolean findInBitonicArray(int[] input, int valToFind) {
            int inputSize = input.length;

            //assumption/clarification that it increases and then decreases only once
            //find the bitonic point when the switch happens , let that point's index be called b
            // do binary  search in array from 0 - b
            // if not found in first do binary search in b+1 to n in reverse order
            int bitonicPoint = inputSize;
             /*  this is not acceptable as it will take n  pass to find the max
              for (int i = 0; i < inputSize - 1; i++) {
                            if (input[i] > input[i + 1]) {
                                bitonicPoint = i;
                                break;
                            }
                }
              */
            List<Integer> list = IntStream.of(input).boxed().collect(Collectors.toList());
            Integer maxItem = list.stream().max(Comparator.naturalOrder()).orElse(-1);
            bitonicPoint = list.indexOf(maxItem);


            int resultIndex = Arrays.binarySearch(input, 0, bitonicPoint, valToFind);
            if (resultIndex < 0) {
                Arrays.sort(input, bitonicPoint, inputSize);
                resultIndex = Arrays.binarySearch(input, bitonicPoint, inputSize, valToFind);
            }

            if (resultIndex >= 0) {
                return true;
            }

            return false;

        }
    }



    public static void main(String[] args) {
        int key = StdIn.readInt();
        int[] input = StdIn.readAllInts();  //{ 10 , 20, 30, 40, 50 , 45 , 35 ,25,15,5 };
        boolean result;
        SearchBitonicArray bitonicArray = new SearchBitonicArray();

        SearchBitonicArray.SearchBitonicArrayUsingBuiltInMethods usingBuiltInMethods = bitonicArray.new SearchBitonicArrayUsingBuiltInMethods();
        result = usingBuiltInMethods.findInBitonicArray(input, key);
        StdOut.printf("found key %d : %b %n", key, result);


    }

}

