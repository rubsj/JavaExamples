package com.ruby.datastructure;

/**
 * Created by rjha on 12/15/2016.
 */

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

public class ReverseArray8 {

    public static void main(String[] args) {
        /* Enter your code here. Read4 input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner input = new Scanner(System.in);
        System.out.print("enter the size of array : 1<=N<=1000 : ");
        int sizeA = input.nextInt();
        System.out.print("enter the data of array: 1<=Ai<=10000 : ");
        //String inputData = input.next();
        //solution 1
     /*   List<String> inputArray = IntStream.range(0, sizeA).mapToObj(i -> input.next()).collect(Collectors.toList());
        Collections.reverse(inputArray);
        String reversedString = inputArray.stream().collect(Collectors.joining(" ")); //reduce((t, u) -> t + " " + u ).get();
        System.out.println(reversedString);*/

        //solution 2
        int from = 0;
        int to =  sizeA;
        List<String> inputArray = IntStream.range(0, sizeA).mapToObj(i -> input.next()).collect(Collectors.toList());
        Object[] temp =  inputArray.toArray();
        String reversedString = IntStream.range(0, temp.length).mapToObj(i -> temp[temp.length - i - 1]).map(String::valueOf).collect(Collectors.joining(" ")) ;
        System.out.println(reversedString);



    }


}
