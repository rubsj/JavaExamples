package com.ruby.datastructure;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by rjha on 12/21/2016.
 *
 There are  N strings. Each string's length is no more than 20  characters. There are also Q queries.
 For each query, you are given a string, and you need to find out how many times this string occurred previously.

 Input Format

 The first line contains N, the number of strings.
 The next N lines each contain a string.
 The N+2nd line contains , Q the number of queries.
 The following Q lines each contain a query string.

 Constraints
 1<= N<=1000
 1<= Q<=1000
 1<= length of any string<=20

 Sample Input

 4
 aba
 baba
 aba
 xzxb
 3
 aba
 xzxb
 a

 Sample Output

 2
 1
 0

 */
public class findInArray8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> strings = IntStream.range(0, in.nextInt()).mapToObj(i -> in.next()).collect(Collectors.toList());
        List<String> queries = IntStream.range(0, in.nextInt()).mapToObj(i -> in.next()).collect(Collectors.toList());
        queries.stream().mapToLong(q -> strings.stream().filter(q::equals).count()).forEach(System.out::println);
    }
}
