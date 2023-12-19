package com.ruby.leetcode.sort;

import java.util.Arrays;

/**
 * Given an array of integers nums, sort the array in ascending order and return it.
 *
 * You must solve the problem without using any built-in functions in O(nlog(n)) time complexity and with the smallest space complexity possible.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [5,2,3,1]
 * Output: [1,2,3,5]
 * Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
 * Example 2:
 *
 * Input: nums = [5,1,1,2,0,0]
 * Output: [0,0,1,1,2,5]
 * Explanation: Note that the values of nums are not necessairly unique.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5 * 104
 * -5 * 104 <= nums[i] <= 5 * 104
 */
public class SortArrayMerge {
    public int[] sortArray(int[] nums) {
        if(nums.length ==0){
            return nums;
        }
        return sortArray(nums , 0 , nums.length -1);
    }

    private int[] sortArray(int[] nums , int left , int right){
        if(left==right){
            return nums;
        }

        int middle = (right + left )/2;
        sortArray(nums , left , middle);
        sortArray(nums, middle+1 , right);
        merge(nums , left , middle , right);
        return nums;
    }

    private void merge(int[] nums, int left , int middle , int right){
        int leftLength = middle-left +1;
        int rightLength = right-middle;
        int[] leftArr = new int[leftLength];
        int[] rightArr = new int[rightLength];

        for(int i=0; i<leftLength;i++){
            leftArr[i] = nums[left+i];
        }

        for(int i=0; i<rightLength; i++){
            rightArr[i] = nums[middle+1+i];
        }

        int l=0;
        int r=0;
        int m = left;
        while (l < leftLength && r < rightLength){
            if(leftArr[l] <= rightArr[r]){
                nums[m] = leftArr[l];
                l++;
            }else{
                nums[m] = rightArr[r];
                r++;
            }
            m++;
        }

        while(l < leftLength){
            nums[m] = leftArr[l];
            m++;
            l++;
        }

        while(r < rightLength){
            nums[m] = rightArr[r];
            m++;
            r++;
        }
    }

    public static void main(String[] args) {
        SortArrayMerge merge = new SortArrayMerge();
        int[] case1 = new int[] {5,2,3,1};
        int[] case2 = new int[] {5,1,1,2,0,0};
        int[] result = merge.sortArray(case1);
        System.out.printf("Case1 : after sorting is %s%n ", Arrays.toString(result));

        result = merge.sortArray(case2);
        System.out.printf("Case2 : after sorting is %s%n ", Arrays.toString(result));
    }
}
