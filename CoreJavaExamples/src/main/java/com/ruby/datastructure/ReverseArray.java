package com.ruby.datastructure;

/**
 * Created by rjha on 12/15/2016.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 *  Challange :
 *  An array is a type of data structure that stores elements of the same type in a contiguous block of memory. In an array, , of size , each memory location has some unique index,  (where ), that can be referenced as  (you may also see it written as ).

 Given an array, , of  integers, print each element in reverse order as a single line of space-separated integers.

 Note: If you've already solved our C++ domain's Arrays Introduction challenge, you may want to skip this.

 Input Format

 The first line contains an integer,  (the number of integers in ).
 The second line contains  space-separated integers describing .

 Constraints
  1<= N<=1000
  1<=Ai<=10000 where Ai is the ith interger in A
 Output Format

 Print all  integers in  in reverse order as a single line of space-separated integers.

 Sample Input

 4
 1 4 3 2
 Sample Output

 2 3 4 1

 */

public class ReverseArray {

    public static void main(String[] args) {
        /* Enter your code here. Read4 input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in).useDelimiter("\\n");
        System.out.print("enter the size of array : 1<=N<=1000 : ");
        int sizeA = input.nextInt();
        System.out.print("enter the data of array: 1<=Ai<=10000 : ");
        String inputData = input.next();
        Pattern p = Pattern.compile("^(?=.*\\d)[\\d\\s]*$");
        Matcher matcher = p.matcher(inputData);
        if (matcher.matches()) {
            String[] dataArray = inputData.split("\\s+");
            if (validateInput(sizeA , dataArray)){
                String[] reversedArray = new String[sizeA];
                for (int i = 0; i < dataArray.length; i++) {
                    reversedArray[i] = dataArray[dataArray.length - i - 1];
                }

                String joinedReversedString = String.join(" ", (CharSequence[]) reversedArray);
                System.out.println(joinedReversedString);
            }
        } else{
            System.err.println("input was not given as The second line contains  space-separated integers describing A ");
        }

    }

    private static boolean validateInput(int arraySize, String[] inputData) {
        if (arraySize < 1 || arraySize > 1000) {
            System.err.println("input array size must be between 1 and 1000");
            return false;
        }

        for (String data : inputData) {
            int dataInput = Integer.parseInt(data);
             if(dataInput < 1 || dataInput > 10000){
                 System.err.println("input array data must be between 1 and 10000");
                 return false;
             }

        }

        if (inputData.length != arraySize) {
            System.err.println("The input size does not match with data input");
            return false;
        }

        return true;
    }
}
