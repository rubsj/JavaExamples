/**
 * created by Ruby Jha on 11/18/2018
 */
package com.ruby.algs.stacksAndQueues.assignment;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Write a client program Permutation.java that takes an integer k as a command-line argument;
 * reads in a sequence of strings from standard input using StdIn.readString();
 * and prints exactly k of them, uniformly at random. Print each item from the sequence at most once.
 * <p>
 * <p>
 * % more distinct.txt                        % more duplicates.txt
 * A B C D E F G H I                          AA BB BB BB BB BB CC CC
 * <p>
 * % java-algs4 Permutation 3 < distinct.txt   % java-algs4 Permutation 8 < duplicates.txt
 * C                                               BB
 * G                                               AA
 * A                                               BB
 * CC
 * % java-algs4 Permutation 3 < distinct.txt       BB
 * E                                               BB
 * F                                               CC
 * G                                               BB
 * <p>
 * <p>
 * Command-line input.  You may assume that 0 ≤ k ≤ n, where n is the number of string on standard input.
 * <p>
 * Performance requirements.
 * The running time of Permutation must be linear in the size of the input.
 * You may use only a constant amount of memory plus either one Deque or RandomizedQueue
 * object of maximum size at most n. (For an extra challenge, use only one Deque or
 * RandomizedQueue object of maximum size at most k.)
 */

public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue randomizedQueue = new RandomizedQueue();
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            randomizedQueue.enqueue(StdIn.readString());
        }


        for (int i = 0; i < k; i++) {
            StdOut.println(randomizedQueue.dequeue());
        }

    }
}

