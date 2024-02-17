package com.ruby.leetcode.dp;


import java.util.Arrays;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 * <p>
 * You can either start from the step with index 0, or the step with index 1.
 * <p>
 * Return the minimum cost to reach the top of the floor.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: cost = [10,15,20]
 * Output: 15
 * Explanation: You will start at index 1.
 * - Pay 15 and climb two steps to reach the top.
 * The total cost is 15.
 * Example 2:
 * <p>
 * Input: cost = [1,100,1,1,1,100,1,1,100,1]
 * Output: 6
 * Explanation: You will start at index 0.
 * - Pay 1 and climb two steps to reach index 2.
 * - Pay 1 and climb two steps to reach index 4.
 * - Pay 1 and climb two steps to reach index 6.
 * - Pay 1 and climb one step to reach index 7.
 * - Pay 1 and climb two steps to reach index 9.
 * - Pay 1 and climb one step to reach the top.
 * The total cost is 6.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 */
public class MinCostClimbingStairs {
    /**
     * recursive relation minCost[i] =  cost[i] + min(const[i-1] , cost[i-2])
     * minCost[0] =cost[0]
     * minCost[1] = cost[1]
     */
    // using basic recursive approach
    //Convert the recurrence relation to recursion
    public int minCostClimbingStairsRecursive(int[] cost) {
        return Math.min(costFind(cost, cost.length-1) , costFind(cost, cost.length-2));
    }

    private int costFind(int[] cost, int i) {
        int minCost;
        if(i<0){
            return 0;
        }
        if (i < 2) {
            minCost = cost[i];
            return minCost;
        }
        minCost = cost[i] + Math.min(costFind(cost, i - 1), costFind(cost, i - 2));
        return minCost;
    }

    //Optimization 1 - Top Down DP - Add memoization to recursion - From exponential to linear.
    public int minCostClimbingStairsMemoized(int[] cost) {
        int[] dp = new int[cost.length];
        return Math.min(costFindMemo(cost, cost.length-1 , dp) , costFindMemo(cost, cost.length-2 ,dp));
    }

    private int costFindMemo(int[] cost, int i, int[] dp) {
        int minCost;
        if(i<0){
            return 0;
        }
        if (i < 2) {
            minCost = cost[i];
            dp[i] = minCost;
            return minCost;
        }
        if(dp[i] != 0){
            return dp[i];
        }
        minCost = cost[i] + Math.min(costFindMemo(cost, i - 1, dp), costFindMemo(cost, i - 2 , dp));
        dp[i] = minCost;
        return minCost;
    }

    public int minCostClimbingStairsItrMemo(int[] cost){
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2; i < cost.length; i++){
            dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        System.out.println(Arrays.toString(dp));
        return Math.min(dp[cost.length -1], dp[cost.length -2]);
    }

    public int minCostClimbingStairsItr(int[] cost){
        int posMinusOne = cost[1];
        int posMinusTwo = cost[0];
        int temp;
        for(int i = 2; i < cost.length; i++){
            temp = cost[i] + Math.min(posMinusOne, posMinusTwo);
            posMinusTwo = posMinusOne;
            posMinusOne = temp;
        }

        return Math.min(posMinusOne, posMinusTwo);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs stairs = new MinCostClimbingStairs();
        // using basic recursive approach
        int[] case1 = new int[]{10,15,20};
        int[] case2 = new int[]{1,100,1,1,1,100,1,1,100,1};

        int minCost = stairs.minCostClimbingStairsRecursive(case1);
        System.out.printf("using recursive: for stairs %s the min cost is %d %n" , Arrays.toString(case1) , minCost);

        minCost = stairs.minCostClimbingStairsRecursive(case2);
        System.out.printf("using recursive: for stairs %s the min cost is %d %n" , Arrays.toString(case2) , minCost);

        minCost = stairs.minCostClimbingStairsMemoized(case1);
        System.out.printf("using memoized: for stairs %s the min cost is %d %n" , Arrays.toString(case1) , minCost);

        minCost = stairs.minCostClimbingStairsMemoized(case2);
        System.out.printf("using memoized: for stairs %s the min cost is %d %n" , Arrays.toString(case2) , minCost);

        minCost = stairs.minCostClimbingStairsItrMemo(case1);
        System.out.printf("using Iteration memoized: for stairs %s the min cost is %d %n" , Arrays.toString(case1) , minCost);

        minCost = stairs.minCostClimbingStairsItrMemo(case2);
        System.out.printf("using Iteration memoized: for stairs %s the min cost is %d %n" , Arrays.toString(case2) , minCost);

        minCost = stairs.minCostClimbingStairsItr(case1);
        System.out.printf("using Iteration: for stairs %s the min cost is %d %n" , Arrays.toString(case1) , minCost);

        minCost = stairs.minCostClimbingStairsItr(case2);
        System.out.printf("using Iteration: for stairs %s the min cost is %d %n" , Arrays.toString(case2) , minCost);
    }
}
