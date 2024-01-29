package com.ruby.leetcode;


import java.util.Arrays;

/**
 * You are given an m x n integer matrix matrix with the following two properties:
 *
 * Each row is sorted in non-decreasing order.
 * The first integer of each row is greater than the last integer of the previous row.
 * Given an integer target, return true if target is in matrix or false otherwise.
 *
 * You must write a solution in O(log(m * n)) time complexity.
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int low = 0;
        int high = matrix.length-1;
        int mid = -1;
        while(low<=high){
            mid = (low + high)/2;
            if(target < matrix[mid][0]){
                high = mid-1;
            }else if(target > matrix[mid][matrix[mid].length -1]){
                low = mid +1;
            }else{
                break;
            }
        }
        if(mid == -1){
            return false;
        }
        return binarySearch(matrix[mid] , target);
    }
    public boolean binarySearch(int[] nums, int target) {
        System.out.printf("search being performed on %s item in matrix %n" , Arrays.toString(nums));
        int low = 0;
        int high = nums.length -1;
        int mid;

        while(low <= high){
            mid = (low+high)/2;
            if(target < nums[mid]){
                high = mid-1;
            }else if(target > nums[mid]){
                low =  mid +1;
            }else{
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SearchMatrix search = new SearchMatrix();
        int[][] matrix = new int[][]{new int[]{1,3,5,7}, new int[]{10,11,16,20}, new int[]{23,30,34,60}};
        int case1 = 3;
        int case2 = 13;
        boolean result = search.searchMatrix(matrix , case1);
        System.out.printf("For case %d the value in matrix is found %b %n" , case1 , result);

        result = search.searchMatrix(matrix , case2);
        System.out.printf("For case %d the value in matrix is found %b %n" , case2 , result);

        int[][] matrix2 = new int[][]{new int[]{1}};
        result = search.searchMatrix(matrix2 , case1);
        System.out.printf("For case %d the value in matrix is found %b %n" , case1 , result);

    }
}
