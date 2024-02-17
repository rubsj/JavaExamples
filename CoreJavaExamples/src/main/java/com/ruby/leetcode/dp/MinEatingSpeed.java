package com.ruby.leetcode.dp;

/**
 * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
 *
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer k such that she can eat all the bananas within h hours.
 *
 *
 *
 * Example 1:
 *
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * Example 2:
 *
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * Example 3:
 *
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 *
 *
 * Constraints:
 *
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 */
public class MinEatingSpeed {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1 ;
        int high = largestPileSize(piles);
        while(low < high){
            int mid = low + (high -low)/2;
            if(canEatAll(piles, h , mid)){
                high = mid;
            }else{
                low = mid +1;
            }
        }
        return low;
    }

    private boolean canEatAll(int[] piles, int hours , int rate){
        int countHour = 0;
        for(int pile: piles){
            countHour = countHour +  pile / rate;
            if(pile % rate > 0){
                countHour = countHour +1;
            }
        }
        return countHour <= hours;
    }
    private int largestPileSize(int[] piles){
        int biggestPile = 0;
        for (int pile: piles) {
            biggestPile = Math.max(pile , biggestPile);
        }
        return biggestPile;
    }

    public static void main(String[] args) {
        MinEatingSpeed speed = new MinEatingSpeed();
        int[] case1 = new int[]{3,6,7,11};
        int[] case2 = new int[]{30,11,23,4,20};
        int[] case3 = new int[]{30,11,23,4,20};
        int[] case4 = new int[]{2, 2};
        int result = speed.minEatingSpeed(case1 , 8);
        System.out.printf("for case 1 to eat in %d hour the min speed is %d%n" , 8 , result);

        result = speed.minEatingSpeed(case2 , 5);
        System.out.printf("for case 2 to eat in %d hour the min speed is %d%n" , 5 , result);

        result = speed.minEatingSpeed(case3 , 6);
        System.out.printf("for case 3 to eat in %d hour the min speed is %d%n" , 6 , result);

        result = speed.minEatingSpeed(case4 , 4);
        System.out.printf("for case 4 to eat in %d hour the min speed is %d%n" , 4 , result);
    }
}
