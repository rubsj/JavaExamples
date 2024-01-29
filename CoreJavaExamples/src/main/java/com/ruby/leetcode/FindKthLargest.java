package com.ruby.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Can you solve it without sorting?
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [3,2,1,5,6,4], k = 2
 * Output: 5
 * Example 2:
 *
 * Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
 * Output: 4
 *
 *
 * Constraints:
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class FindKthLargest {

    public int findKthLargestQuickSelect(int[] nums, int k) {
        int start = 0;
        int end = nums.length -1;
        int sortedIndex = -1;
        boolean foundIndex = false;

        while(!foundIndex){
            // get the sorted position of pivot
            sortedIndex = quickSelect(nums , start , end);

            if(sortedIndex == nums.length -k){
                // if the sorted item's position matches the position for which we are looking to do the sorting, return the element , we don't need to sort the full array
                foundIndex = true;
            }else if(sortedIndex > nums.length -k){
                // if the item that got sorted is in the position which is after the position that we are interested in
                // that means we can shrink the search area on the right side as our position of interested is on the left
                // and is smaller than the currently sorted item
                end = sortedIndex -1;
            }else{
                // sorted item's position is before the position we are looking for so we can shrink the sort list in the begining
                start = sortedIndex +1;
            }
        }

        return nums[sortedIndex];
    }

    // choose the end item as pivot and do the quick sorting
    // after one round of it the pivot will reach its position where it should be in final sorted list
    private int quickSelect(int[] nums , int start , int end){
        int pivotIndex = start + new Random().nextInt(end-start+1);
        int pivot = nums[pivotIndex];
        swap(nums , end , pivotIndex);
        int sortedIndex = start;
        for(int i= start ; i < end; i++){
            if(nums[i] < pivot){
                swap(nums , i , sortedIndex);
                sortedIndex++;
            }
        }
        swap(nums , end , sortedIndex);

        return sortedIndex;
    }
    public int findKthLargestQuickSort(int[] nums, int k) {
        int[] sortedArr = quickSort(nums , 0 , nums.length-1);
        System.out.printf("Sorted array is %s%n", Arrays.toString(sortedArr));
        int findK = nums.length - k;
        return sortedArr[findK];
    }
    private int[] quickSort(int[] nums , int start , int end){
        if(end-start+1 <=1){
            return nums;
        }
        int pivot = nums[end];
        int m = start;
        for(int i= start ; i < end; i++){
            if(nums[i] < pivot){
                swap(nums , i , m);
                m++;
            }
        }
        swap(nums , m , end);

        quickSort(nums , start , m-1);
        quickSort(nums , m+1 , end);
        return  nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int findKthLargestMerge(int[] nums, int k) {
        int[] sortedNums = mergeSort(nums);
        int findK = nums.length - k;
        return sortedNums[findK];
    }

    public int[] mergeSort(int[] nums){
        int[] sortedNums = mergeSort(nums , 0 , nums.length-1);
        System.out.printf("Sorted array is %s%n", Arrays.toString(sortedNums));
        return sortedNums;
    }

    private int[] mergeSort(int[] nums, int start , int end){
        if(start == end){
            return nums;
        }

        int middle = (end+start)/2;
        mergeSort(nums, start , middle);
        mergeSort(nums , middle+1 , end);
        merge(nums , start, middle , end);

        return nums;
    }

    private void merge(int[] nums , int start , int middle , int end){
        int leftSize = middle -start +1;
        int rightSize = end-middle;
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        for(int i = 0 ; i<leftSize ; i++){
            left[i] = nums[start+i];
        }

        for(int i = 0; i < rightSize ; i++){
            right[i] = nums[middle+i+1];
        }

        int l = 0;
        int r = 0;
        int m = start;
        while(l < left.length && r < right.length){
            if(left[l] < right[r] ){
                nums[m] = left[l];
                l++;
            }else{
                nums[m] = right[r];
                r++;
            }
            m++;
        }

        while(l < left.length){
            nums[m] = left[l];
            l++;
            m++;
        }

        while(r < right.length){
            nums[m] = right[r];
            r++;
            m++;
        }
    }

    public static void main(String[] args) {
        FindKthLargest largest = new FindKthLargest();
        int[] case1 = new int[]{3,2,1,5,6,4};
        int[] case2 = new int[]{3,2,3,1,2,4,5,5,6};
        int result = largest.findKthLargestMerge(case1, 2);
        System.out.printf("For case 1 Merge Sort: the k %d element is %d %n" , 2 , result);

        result = largest.findKthLargestMerge(case2, 4);
        System.out.printf("For case 2 Merge sort : the k %d element is %d %n" , 4 , result);

        result = largest.findKthLargestQuickSort(case1, 2);
        System.out.printf("For case 1 quick sort : the k %d element is %d %n" , 2 , result);

        result = largest.findKthLargestQuickSort(case2, 4);
        System.out.printf("For case 2 quick sort : the k %d element is %d %n" , 4 , result);

        result = largest.findKthLargestQuickSelect(case1, 2);
        System.out.printf("For case 1 quick select : the k %d element is %d %n" , 2 , result);

        result = largest.findKthLargestQuickSelect(case2, 4);
        System.out.printf("For case 2 quick select : the k %d element is %d %n" , 4 , result);
    }
}
