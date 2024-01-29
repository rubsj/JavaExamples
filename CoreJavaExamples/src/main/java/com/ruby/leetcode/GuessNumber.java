package com.ruby.leetcode;

import lombok.Data;
import lombok.Setter;
import lombok.Value;

/**
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 * <p>
 * You call a pre-defined API int guess(int num), which returns three possible results:
 * <p>
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 10, pick = 6
 * Output: 6
 * Example 2:
 * <p>
 * Input: n = 1, pick = 1
 * Output: 1
 * Example 3:
 * <p>
 * Input: n = 2, pick = 1
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 */

@Data
public class GuessNumber {

    int pick;

    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while (true) {
            int mid = low + (high -low) / 2;
            int guessedVal = guess(mid);
            if (guessedVal == -1) {
                high = mid - 1;
            } else if (guessedVal == 1) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
    }

    int guess(int num) {
        if (num > pick) {
            return -1;
        } else if (num < pick) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        GuessNumber guessNumber = new GuessNumber();
        guessNumber.setPick(6);
        int result = guessNumber.guessNumber(10);
        System.out.printf("For the range %d you guessed the number %d%n" , 10 , result);

        guessNumber.setPick(1);
        result = guessNumber.guessNumber(1);
        System.out.printf("For the range %d you guessed the number %d%n" , 1 , result);

        guessNumber.setPick(1);
        result = guessNumber.guessNumber(2);
        System.out.printf("For the range %d you guessed the number %d%n" , 2 , result);
    }
}
