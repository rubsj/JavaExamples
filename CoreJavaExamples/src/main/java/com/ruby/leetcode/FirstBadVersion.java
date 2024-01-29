package com.ruby.leetcode;

import lombok.Data;

/**
 * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
 *
 * You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5, bad = 4
 * Output: 4
 * Explanation:
 * call isBadVersion(3) -> false
 * call isBadVersion(5) -> true
 * call isBadVersion(4) -> true
 * Then 4 is the first bad version.
 * Example 2:
 *
 * Input: n = 1, bad = 1
 * Output: 1
 *
 *
 * Constraints:
 *
 * 1 <= bad <= n <= 231 - 1
 */

@Data
public class FirstBadVersion {
    int badVersion;

    public int firstBadVersion1(int n) {
        int low =1;
        int high = n;
        while(low < high){
            int mid = low + (high -low) /2;
            boolean isBad = isBadVersion(mid);
            if(!isBad){
                low = mid+1;
            }else{
                high = mid;
            }
        }
        return low;
    }

    public int firstBadVersion2(int n) {
        int low =1;
        int high = n;
        while(low <=high){
            int mid = low + (high -low) /2;
            if(isBadVersion(mid)){
                if(!isBadVersion(mid-1)){
                    return mid;
                }else{
                    high = mid -1;
                }
            }else{
                low = mid+1;
            }
        }
        return low;
    }

    boolean isBadVersion(int version){
        if(version >= badVersion){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
         FirstBadVersion version = new FirstBadVersion();
         version.setBadVersion(4);

         int result = version.firstBadVersion1(5);
        System.out.printf("for the given number %d first bad version is %d%n", 5 , result);

        version.setBadVersion(1);
        result = version.firstBadVersion1(1);
        System.out.printf("for the given number %d first bad version is %d%n", 1 , result);

        version.setBadVersion(4);
        result = version.firstBadVersion2(5);
        System.out.printf("approach2 : for the given number %d first bad version is %d%n", 5 , result);

        version.setBadVersion(1);
        result = version.firstBadVersion2(1);
        System.out.printf("approach2 :  for the given number %d first bad version is %d%n", 1 , result);
    }
}
