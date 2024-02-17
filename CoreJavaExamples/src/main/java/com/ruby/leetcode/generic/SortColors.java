package com.ruby.leetcode.generic;

import java.util.Arrays;

/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 * You must solve this problem without using the library's sort function.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 *
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 300
 * nums[i] is either 0, 1, or 2.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        // prepare the bucket
        int[] bucket = new int[]{0,0,0};
        // fll the buckets with values from array
        for(int i =0 ; i< nums.length ; i++){
            int n = nums[i];
            bucket[n] = bucket[n] + 1;
        }
        // place the bucket items into array
        int i = 0;
        for(int b = 0 ; b < bucket.length ; b++){
            for(int j = 0 ; j < bucket[b] ; j++){
                nums[i] = b;
                i++;
            }
        }

    }

    public static void main(String[] args) {
        SortColors colors = new SortColors();
        int[] case1 = new int[]{2,0,2,1,1,0};
        int[] case2 = new int[]{2,0,1};
        colors.sortColors(case1);
        System.out.printf("Case one after sorting is %s%n " , Arrays.toString(case1));
        colors.sortColors(case2);
        System.out.printf("Case two after sorting is %s%n " , Arrays.toString(case2));
    }
}
