package com.ruby.algs.analysisOfAlgo;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.Arrays;

/**
 * created by Ruby Jha on 11/4/2018
 *
 * 3-SUM in quadratic time. Design an algorithm for the 3-SUM problem that takes time proportional to n^2
 * in the worst case. You may assume that you can sort the n integers in time proportional to n^2
 * or better.
 *
 *  Test Data files:   https://algs4.cs.princeton.edu/14analysis/1Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/2Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/4Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/8Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/16Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/32Kints.txt
 *                https://algs4.cs.princeton.edu/14analysis/1Mints.txt
 *                
 */
public class ThreeSumQuadratic {

    public int countThreeSum(int[] input) {
        int result = 0;
        Arrays.sort(input);
        int arraySize = input.length;
        for (int i = 0; i < arraySize; i++) {
            for (int j = i + 1; j < arraySize; j++) {
                int k = Arrays.binarySearch(input, -(input[i] + input[j]));
                if (k > j) {
                    result++;
                    StdOut.println(input[i] + " " + input[j] + " " + input[k]);
                }
            }

        }

        return result;
    }

    public static void main(String[] args) {
        ThreeSumQuadratic sumQuadratic = new ThreeSumQuadratic();
        int[] input = StdIn.readAllInts();
        Stopwatch timer = new Stopwatch();
        int result = sumQuadratic.countThreeSum(input);
        StdOut.printf("The result %d was  found in %.4f time %n", result, timer.elapsedTime());
    }

}

