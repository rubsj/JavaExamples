package com.ruby.puzzle;

/**
 * created by Ruby Jha on 10/15/2018
 */
public class CalculateHCF {

    static int gcd(int a, int b)
    {
        System.out.printf("the value of a is %d and b is %d %n" , a ,b);
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int generalizedGCD(int num, int[] arr)
    {
        int result =arr[0];
        for(int i=1; i<num; i++){
            result = gcd(arr[i], result);
        }


        return result;
    }
    public static void main(String[] args) {
        int arr[] = { 2, 4, 6, 8, 16 };
        int n = arr.length;
        CalculateHCF hcf = new CalculateHCF();
        System.out.println(hcf.generalizedGCD(n, arr));
    }
}

