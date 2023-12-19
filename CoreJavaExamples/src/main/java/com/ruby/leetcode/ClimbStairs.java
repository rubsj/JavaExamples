package com.ruby.leetcode;

import java.util.Arrays;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
public class ClimbStairs {
    public int climbStairsRecursive(int n){
        int memo[] = new int[n+1];
        Arrays.fill(memo, -1);
        memo[n] = climb(n-1, memo) + climb(n-2, memo);
        System.out.printf("the memo is %s%n",Arrays.toString(memo));
        return memo[n];

    }

    private int climb(int n , int[] memo){
        if(n<0) return 0;
        if(n==0 || n ==1){
            memo[n] = 1;
            return memo[n];
        }
        if(memo[n] != -1) return memo[n];
        memo[n] = climb(n-1 , memo) + climb(n-2 , memo);
        System.out.printf("For step %d the memo is %s%n", n ,Arrays.toString(memo));
        return memo[n];
    }

    public int climbStairsIterative(int n){
        int memo[] = new int[n+1];
        memo[0] =1;
        memo[1]=1;
        for (int i = 2; i < n+1; i++) {
            memo[i] = memo[i-1] + memo[i-2];
        }
        System.out.printf("memo in interative is %s%n" , Arrays.toString(memo));
        return memo[n];
    }

    public int climbStairsNonArray(int n){
        int nMinusOne = 1;
        int nMinusTwo = 1;
        int temp;
        for(int i = 2 ; i < n+1 ; i++){
            temp = nMinusOne + nMinusTwo;
            nMinusTwo = nMinusOne;
            nMinusOne = temp;
        }
        return nMinusOne;
    }

    public static void main(String[] args) {
        ClimbStairs climbStairs = new ClimbStairs();
        int result = climbStairs.climbStairsRecursive(5);
        System.out.printf("Climbing 5 steps can be achieved in %d ways : recursive %n", result);

        result = climbStairs.climbStairsIterative(5);
        System.out.printf("Climbing 5 steps can be achieved in %d ways : iterative%n", result);

        result = climbStairs.climbStairsNonArray(5);
        System.out.printf("Climbing 5 steps can be achieved in %d ways : non array%n", result);
    }
}
