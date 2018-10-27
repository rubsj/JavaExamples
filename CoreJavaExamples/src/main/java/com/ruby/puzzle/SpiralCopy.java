/**
 * Created by Ruby Jha 10/11/2018
 * <p>
 * Problem Statement -  Given a 2D array (matrix) inputMatrix of integers, create a function spiralCopy that copies inputMatrix’s values into a 1D array
 * in a spiral order, clockwise. Your function then should return that array. Analyze the time and space complexities of your solution.
 * <p>
 * input:  inputMatrix  = [ [1,    2,   3,  4,    5],
 * [6,    7,   8,  9,   10],
 * [11,  12,  13,  14,  15],
 * [16,  17,  18,  19,  20] ]
 * <p>
 * output: [1, 2, 3, 4, 5, 10, 15, 20, 19, 18, 17, 16, 11, 6, 7, 8, 9, 14, 13, 12]
 *
 * Time Complexity: O(n*m)
 * Space Complexity:  O(n*m)
 */
package com.ruby.puzzle;

import java.util.Arrays;

public class SpiralCopy {
    static int[] getSpiralCopy(int[][] inputMatrix) {

        int[] result = new int[inputMatrix.length * inputMatrix[0].length];
        int topRow = 0;
        int bottomRow = inputMatrix.length - 1;
        int rightCol = inputMatrix[0].length - 1;
        int leftCol = 0;
        int m = 0;

        while (topRow <= bottomRow && leftCol <= rightCol) {
            //copy the next top row
            for (int i = leftCol; i <= rightCol; i++) {
                result[m] = inputMatrix[topRow][i];
                m++;
            }
            topRow++;

            //copy the next right hand side column
            for (int j = topRow; j <= bottomRow; j++) {
                result[m] = inputMatrix[j][rightCol];
                m++;
            }
            rightCol--;
            //copy the next bottom row
            if (topRow <= bottomRow) {
                for (int k = rightCol; k >= leftCol; k--) {
                    result[m] = inputMatrix[bottomRow][k];
                    m++;
                }
                bottomRow--;
            }
            //copy the next left hand side column
            if (leftCol <= rightCol) {
                for (int l = bottomRow; l >= topRow; l--) {
                    result[m] = inputMatrix[l][leftCol];
                    m++;
                }
                leftCol++;
            }


        }
        return result;
    }

    public static void main(String[] args) {
        int[][] inputMatrix = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20}
        };
        int[] result = getSpiralCopy(inputMatrix);
        System.out.println("inputMatrix : " + Arrays.deepToString(inputMatrix));
        System.out.println("result : " + Arrays.toString(result));
    }
}

