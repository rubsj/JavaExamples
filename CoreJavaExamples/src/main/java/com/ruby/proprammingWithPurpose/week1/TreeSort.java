package com.ruby.proprammingWithPurpose.week1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Three-sort. Write a program that takes three integer command-line arguments and prints them in ascending order.
 */
public class TreeSort {
    public static void main(String[] args) {
        StdOut.println("enter three comma separated integers");
        while(StdIn.hasNextLine()){
            int[] inputs = Arrays.stream(StdIn.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
            StdOut.println("you entered " + Arrays.toString(inputs));
            int a = inputs[0];
            int b = inputs[1];
            int c = inputs[2];
            // Math.max(a , b);
            sortUsingConditions(inputs[0], inputs[1], inputs[2]);
        }

    }

    private static void sortUsingConditions(int a, int b, int c) {
        if (a > b) {
            if (b > c) {
                StdOut.printf("numbers in ascending order are %d > %d > %d \n", a, b, c);
            } else {
                if (a > c) {
                    StdOut.printf("numbers in ascending order are %d > %d > %d \n", a, c, b);
                } else {
                    StdOut.printf("numbers in ascending order are %d > %d > %d \n", c, a, b);
                }
            }
        } else {
            if (a > c) {
                StdOut.printf("numbers in ascending order are %d > %d > %d \n", b, a, c);
            } else {
                if (b > c) {
                    StdOut.printf("numbers in ascending order are %d > %d > %d \n", b, c, a);
                } else {
                    StdOut.printf("numbers in ascending order are %d > %d > %d \n", c, b, a);
                }
            }
        }
    }

/*    private static void sortWithoutUsingConditions(int a, int b, int c){
        int maxNum = Math.max(a, b);
        maxNum = Math.max(a, c);
        maxNum = Math.max(maxNum, b);
        maxNum = Math.max(maxNum, c);
        int minNum = Math.min(a,b);
        minNum = Math.min(a,c);
        minNum = Math.min(minNum,b);
        minNum = Math.min(minNum,c);
        System.out.println("");
    }*/
}
