package com.ruby.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/***
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 *
 */
public class TwoSum {

    /**
     * Approach #1 (Brute Force)
     * The brute force approach is simple. Loop through each element xx and find if there is another value that equals to target - xtarget−x.
     * <p>
     * Complexity Analysis
     * <p>
     * Time complexity : O(n^2). For each element, we try to find its complement by looping through the rest of array which takes O(n) time.
     * Therefore, the time complexity is O(n^2).
     * Space complexity : O(1).
     */
    public int[] twoSum_Approach1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        //Instead of returning null , throw exception
        return null;
    }

    /**
     *    Approach #2 (Two-pass Hash Table)
     *  To improve our run time complexity, we need a more efficient way to check if the complement exists in the array.
     *  If the complement exists, we need to look up its index. What is the best way to maintain a mapping of each element in the array to its index? A hash table.
     *  We reduce the look up time from O(n) to O(1) by trading space for speed. A hash table is built exactly for this purpose,
     *  it supports fast look up in near constant time. I say "near" because if a collision occurred, a look up could degenerate to O(n)time.
     *  But look up in hash table should be amortized O(1)O(1) time as long as the hash function was chosen carefully.
     *
     *  A simple implementation uses two iterations. In the first iteration, we add each element's value and its index to the table.
     *  Then, in the second iteration we check if each element's complement (target - nums[i]) exists in the table.
     *  Beware that the complement must not be nums[i] itself!
     *
     *  Complexity Analysis:

     Time complexity : O(n). We traverse the list containing nn elements exactly twice. Since the hash table reduces the look up time to O(1), the time complexity is O(n).

     Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores exactly nn elements.
     *    
     */
    public int[] twoSum_Approach2(int[] nums, int target) {
        Map<Integer, Integer> dataInMap = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            dataInMap.put(nums[i] , i);
        }

        for(int i=0; i<nums.length ; i++){
            int complement = target - nums[i];
            if(dataInMap.containsKey(complement) && dataInMap.get(complement)!=i){
                return new int[]{i ,dataInMap.get(complement)};
            }

        }
        return  null;
    }

    /**
     * Approach #3 (One-pass Hash Table)
     * 
     * It turns out we can do it in one-pass. While we iterate and inserting elements into the table, we also look back to check if current element's complement
     * already exists in the table. If it exists, we have found a solution and return immediately.
     *
     *  Complexity Analysis:

     Time complexity : O(n). We traverse the list containing nn elements only once. Each look up in the table costs only O(1) time.

     Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores at most n elements.
     *
     * 
     */
    public int[] twoSum_Approach3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return  null;
    }

}


class MainClass {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static String integerArrayToString(int[] nums, int length) {
        if (length == 0) {
            return "[]";
        }

        String result = "";
        for (int index = 0; index < length; index++) {
            int number = nums[index];
            result += Integer.toString(number) + ", ";
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static String integerArrayToString(int[] nums) {
        return integerArrayToString(nums, nums.length);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[] nums = stringToIntegerArray(line);
            line = in.readLine();
            int target = Integer.parseInt(line);

            int[] ret = new TwoSum().twoSum_Approach1(nums, target);

            String out = integerArrayToString(ret);

            System.out.print(out);
        }
    }
}

