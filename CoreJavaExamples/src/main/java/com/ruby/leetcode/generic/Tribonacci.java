package com.ruby.leetcode.generic;

import java.util.Arrays;

/**
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * Example 2:
 *
 * Input: n = 25
 * Output: 1389537
 *
 *
 * Constraints:
 *
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
public class Tribonacci {
    // recursive case Tn = Tn-3 + Tn-2 + Tn-1
    // base vals t0 =0 , t1=1 t2 =1
    public int tribonacci(int n) {
        int[] dp = new int[n+1];
        int val = trib(n , dp);
        System.out.printf("in the end dp val is %s%n", Arrays.toString(dp));
        return val;
    }

    private int trib(int n , int[] dp){
        if(n <=0){
            dp[n]=0;
            return 0;
        }
        if(n<3){
            dp[n] = 1;
            return 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int val = trib(n-1, dp) + trib(n-2, dp) + trib(n-3, dp);
        dp[n] = val;
        return val;
    }

    public int tribonacciItrDp(int n){
        if(n<=0){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1] = 1;
        dp[2] =1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        System.out.printf("dp in itr is %s%n", Arrays.toString(dp));
        return dp[n];
    }

    public int tribonacciItr(int n){
        if(n<=0){
            return 0;
        }
        int posMinus3=0;
        int posMinus2 = 1;
        int posMinus1 =1;
        int temp;
        for (int i = 3; i <= n; i++) {
            temp = posMinus1 +posMinus2 + posMinus3;
            posMinus3 = posMinus2;
            posMinus2 = posMinus1;
            posMinus1 = temp;
        }

        return posMinus1;
    }

    public static void main(String[] args) {
        Tribonacci tribonacci = new Tribonacci();
        int case1 = 4;
        int case2 = 25;
        int result = tribonacci.tribonacci(case1);
        System.out.printf("For the input %d the result is %d %n", case1 , result);

        result = tribonacci.tribonacci(case2);
        System.out.printf("For the input %d the result is %d %n", case2 , result);

        result = tribonacci.tribonacciItrDp(case1);
        System.out.printf("using iteration with Dp : For the input %d the result is %d %n", case1 , result);

        result = tribonacci.tribonacciItrDp(case2);
        System.out.printf("using iteration with Dp :  For the input %d the result is %d %n", case2 , result);
        result = tribonacci.tribonacciItr(case1);
        System.out.printf("using iteration : For the input %d the result is %d %n", case1 , result);

        result = tribonacci.tribonacciItr(case2);
        System.out.printf("using iteration  :  For the input %d the result is %d %n", case2 , result);
    }
}
