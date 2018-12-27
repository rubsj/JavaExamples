package com.ruby.puzzle;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;


/**
 * created by Ruby Jha on 10/30/2018
 *
 * This is solution to problem :- Given N distinct integers, how many triples sum to exactly zero?
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
public class ThreeSumBruteForce {
     @SuppressWarnings("Duplicates")
     public int countThreeSum(int[] input){
         int N =  input.length;
         int result=0;
         for(int i=0; i< N; i++){
             for(int j=i+1; j<N; j++){
                 for(int k=j+1; k<N; k++){
                    if(input[i]+input[j]+input[k]==0){
                        result++;
                        StdOut.println(input[i] + " " + input[j] + " " + input[k]);
                    }
                 }
             }
         }

         return result;

     }

    public static void main(String[] args) {
        ThreeSumBruteForce sumBruteForce = new ThreeSumBruteForce();
        int[] input = StdIn.readAllInts();
        Stopwatch   timer = new Stopwatch();
         int result = sumBruteForce.countThreeSum(input);
        StdOut.printf("The result %d was  found in %.4f time %n", result , timer.elapsedTime());

    }
}

