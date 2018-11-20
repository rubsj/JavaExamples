/**
 * Created by Ruby Jha on 11/19/2018
 *
 */
package com.ruby.algs.elementarySort;

import edu.princeton.cs.algs4.Shell;

/**
 * Permutation.
 * Given two integer arrays of size n, design a subquadratic algorithm to determine whether one is a
 * permutation of the other. That is, do they contain exactly the same entries but, possibly, in a different order.
 *
 */
public class Permutation {
    public boolean isPermutation(Integer[] a , Integer[] b){
        if(a.length != b.length) return false;
        Shell.sort(a);
        Shell.sort(b);
        int i=0;
        while(i<a.length){
            if(a[i]!=b[i])
                return false;
        }
        return true;
    }
}

