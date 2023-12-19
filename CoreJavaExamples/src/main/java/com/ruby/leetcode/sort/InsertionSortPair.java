package com.ruby.leetcode.sort;

import com.ruby.leetcode.utils.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement Insertion Sort and return intermediate states.
 *
 * Insertion Sort is a simple sorting algorithm that builds the sorted list one element at a time, from left to right. It works by repeatedly taking an element from the unsorted portion and inserting it into its correct position in the sorted portion of the list.
 *
 * Objective:
 *
 * Given a list of key-value pairs, sort the list by key using Insertion Sort. Return a list of lists showing the state of the array after each insertion. If two key-value pairs have the same key, maintain their relative order in the sorted list.
 *
 * Input:
 *
 * pairs - a list of key-value pairs, where each key-value has an integer key and a string value. (0 <= pairs.length <= 100).
 */
public class InsertionSortPair {
    public List<List<Pair>> insertionSort(List<Pair> pairs){
        List<List<Pair>> sol = new ArrayList<>();
        if(pairs.isEmpty()){
            return sol;
        }

        sol.add(new ArrayList<>(pairs));
        for(int i=1; i<pairs.size(); i++){
            int j = i-1;
            while(j>=0 && pairs.get(j).key > pairs.get(j+1).key){
                Pair temp = pairs.get(j+1);
                pairs.set(j+1 , pairs.get(j));
                pairs.set(j, temp);
                j--;
            }

            sol.add(new ArrayList<>(pairs));
        }
        return sol;
    }

    public static void main(String[] args) {
        InsertionSortPair sortPair = new InsertionSortPair();
        List<Pair> case1 = new ArrayList<>();
        case1.add(new Pair(5, "apple"));
        case1.add(new Pair(2, "banana"));
        case1.add(new Pair(9, "cherry"));

        List<Pair> case2 = new ArrayList<>();
        case2.add(new Pair(3, "cat"));
        case2.add(new Pair(3, "bird"));
        case2.add(new Pair(2, "dog"));
        List<List<Pair>> result =  sortPair.insertionSort(case1);
        System.out.printf("Case 1: result after sorting is %s%n%n" , result.toString());

        result =  sortPair.insertionSort(case2);
        System.out.printf("Case 2 : result after sorting is %s%n" , result.toString());
    }
}


