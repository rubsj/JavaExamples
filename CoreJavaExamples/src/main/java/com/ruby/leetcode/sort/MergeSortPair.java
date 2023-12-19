package com.ruby.leetcode.sort;

import com.ruby.leetcode.utils.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement Merge Sort.
 *
 * Merge Sort is a divide-and-conquer algorithm for sorting an array or list of elements. It works by recursively dividing the unsorted list into n sub-lists, each containing one element. Then, it repeatedly merges sub-lists to produce new sorted sub-lists until there is only one sub-list remaining.
 *
 * Objective:
 *
 * Given a list of key-value pairs, sort the list by key using Merge Sort. If two key-value pairs have the same key, maintain their relative order in the sorted list.
 *
 * Input:
 *
 * pairs - a list of key-value pairs, where each key-value has an integer key and a string value. (0 <= pairs.length <= 100).
 */
public class MergeSortPair {
    public List<Pair> mergeSort(List<Pair> pairs) {
        if(pairs.isEmpty()){
            return pairs;
        }
        return mergeSort(pairs , 0, pairs.size()-1);
    }

    private List<Pair> mergeSort(List<Pair> pairs , int left , int right){
        System.out.printf("entering merge sort with left %d and right %d %n", left , right);
        if(left == right){
            return pairs;
        }
        int middle = (left + right)/2;
        mergeSort(pairs, left , middle);
        mergeSort(pairs, middle+1 , right);
        merge(pairs , left, middle, right);
        return pairs;
    }

    private void merge(List<Pair> pairs, int left , int middle , int right){
        System.out.printf("Entering merge with left %d , middle %d and  right %d %n", left , middle , right);
        int leftLen = middle -left +1;
        int rightLen = right - middle;
        List<Pair> leftLlist = new ArrayList<>(leftLen);
        List<Pair> rightList = new ArrayList<>(rightLen);
        for(int i =0 ; i< leftLen; i++){
            leftLlist.add(i, pairs.get(left+i));
        }

        for(int i=0; i< rightLen; i++){
            rightList.add(i, pairs.get(middle+1+i));

        }

        int l =0; // index of left
        int r=0; // index of right
        int m = left; // index of merged in main array
        while(l < leftLen && r < rightLen){
            if(leftLlist.get(l).key <= rightList.get(r).key){
                pairs.set(m , leftLlist.get(l));
                l++;
            }else{
                pairs.set(m, rightList.get(r));
                r++;
            }
            m++;
        }
        while(l<leftLen){
            pairs.set(m , leftLlist.get(l));
            l++;
            m++;
        }

        while(r < rightLen){
            pairs.set(m, rightList.get(r));
            r++;
            m++;
        }
        System.out.printf("pair after merge is %s%n" , pairs.toString());
    }

    public static void main(String[] args) {
        MergeSortPair sortPair = new MergeSortPair();
        List<Pair> case1 = new ArrayList<>();
        case1.add(new Pair(5, "apple"));
        case1.add(new Pair(2, "banana"));
        case1.add(new Pair(9, "cherry"));
        case1.add(new Pair(1, "date"));
        case1.add(new Pair(9, "elderberry"));

        List<Pair> case2 = new ArrayList<>();
        case2.add(new Pair(3, "cat"));
        case2.add(new Pair(2, "dog"));
        case2.add(new Pair(3, "bird"));

        List<Pair> result = sortPair.mergeSort(case1);
        System.out.printf("Case 1: result after sorting is %s%n%n" , result.toString());

     //    result = sortPair.mergeSort(case2);
      //  System.out.printf("Case 2: result after sorting is %s%n%n" , result.toString());

    }
}
