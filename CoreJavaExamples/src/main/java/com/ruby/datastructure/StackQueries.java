package com.ruby.datastructure;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

import static jdk.nashorn.internal.objects.NativeArray.push;

/**
 * Created by rjha on 12/29/2016.
 *
 You have an empty sequence, and you will be given  queries. Each query is one of these three types:

 1 x  -Push the element x into the stack.
 2    -Delete the element present at the top of the stack.
 3    -Print the maximum element in the stack.
 Input Format

 The first line of input contains an integer, . The next  lines each contain an above mentioned query. (It is guaranteed that each query is valid.)

 Constraints
 1<= N<=100000
 1<= x<=10 pow9
 1<=type<=3

 Output Format

 For each type  query, print the maximum element in the stack on a new line.

 Sample Input

 10
 1 97
 2
 1 20
 2
 1 26
 1 20
 2
 3
 1 91
 3
 Sample Output

 26
 91
 */
public class StackQueries {
    public static void main(String[] args) {
        long starttime = System.currentTimeMillis();
        Scanner scanner = new Scanner(System.in);
        int whileCounter = scanner.nextInt();
        Deque<Integer> stack =  new ArrayDeque<>();
        Deque<Integer> maxstack =  new ArrayDeque<>();
        while (whileCounter>0){
            int nextInput = scanner.nextInt();
            switch (nextInput){
                case 1 :
                    int toPush = scanner.nextInt();
                    stack.addFirst(toPush);
                    if(maxstack.size()==0 || maxstack.peekFirst()<toPush){
                        maxstack.push(toPush);
                    }else {
                        maxstack.push(maxstack.peekFirst());
                    }

                    break;
                case 2 :  stack.removeFirst(); maxstack.removeFirst(); break;
                case 3 :
                    System.out.println(maxstack.peekFirst()); break; //stack.parallelStream().max(Comparator.naturalOrder()).ifPresent(System.out::println); break;
                default:  System.out.println("error"); break;
            }
            whileCounter--;
        }
        scanner.close();
        long totaltime = System.currentTimeMillis()-starttime;
        System.out.println("totoaltime : " + totaltime/1000);
    }
}
