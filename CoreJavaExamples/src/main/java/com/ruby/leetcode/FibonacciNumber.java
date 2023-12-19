package com.ruby.leetcode;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
 *
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: n = 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: n = 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 * Constraints:
 *
 * 0 <= n <= 30
 */
public class FibonacciNumber {
    public int fib(int n) {
        if(n <=1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    public int fibIterate(int n){
        if(n<=1){
            return n;
        }
        int nMinus2 =0;
        int nMinus1 =1;
        int temp;
        for(int i = 1; i<n; i++){
            temp = nMinus2;
            nMinus2 = nMinus1;
            nMinus1 = nMinus1 + temp;
        }
        return nMinus1;
    }

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
        int result = fibonacciNumber.fib(2);
        System.out.printf("the fib for 2 should be 1 and it is %d%n" , result);

        result = fibonacciNumber.fib(3);
        System.out.printf("the fib for 3 should be 2 and it is %d%n" , result);

        result = fibonacciNumber.fib(4);
        System.out.printf("the fib for 4 should be 3 and it is %d%n" , result);

        result = fibonacciNumber.fibIterate(5);
        System.out.printf("the fib for 5 should be 5 and it is %d%n" , result);
        result = fibonacciNumber.fib(6);
        System.out.printf("the fib for 6 should be 8 and it is %d%n" , result);
    }
}
