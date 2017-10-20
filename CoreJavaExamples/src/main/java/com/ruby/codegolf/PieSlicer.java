package com.ruby.codegolf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
/**
 * 
 * Problem statement :
 * 
 * Write a program or function that takes in a nonempty list of positive integers. You may assume it is input in a reasonable convenient format such as "1 2 3 4" or [1, 2, 3, 4].
 * The numbers in the input list represent the slices of a full pie chart where each slice size is proportional to its corresponding number and all slices are arranged around the chart in the order given.
 * 
 * 
 * The question your code must answer is: Is the pie chart ever bisected? That is, is there ever a perfectly straight line from one side of the circle to the other, splitting it symmetrically in two?
 * You need to output a truthy value if there is at least one bisector and output a falsy value if there are none.
 * In the 1 2 3 4 example there is a bisection between 4 1 and 2 3 so the output would be truthy.
 * But for input 1 2 3 4 5 there is no bisector so the output would be falsy:
 * 
 * test cases
 * a) 2 1 3 4 → falsy
 * b)10 → falsy
 * c)6 6 12 12 12 11 1 12 → truthy
 * d)1000000 1000001 → falsy
 * e)1000000 1000001 1 → truthy
 * 
 * Truthy
	1 2 3 4
	6 6 12 12 12 11 1 12
	1000000 1000001 1
	1 2 3
	1 1
	42 42
	1 17 9 13 2 7 3
	3 1 2
	10 20 10
 *
 *
 *  Falsy
	1 2 3 4 5
	2 1 3 4
	10
	1000000 1000001
	1
	1 2
	3 1 1
	1 2 1 2 1 2
	10 20 10 1
 * 
 * 
 * @author rjha
 *
 */
public class PieSlicer {
	
	  /**
	   * This is pre java 8 way of looping
	   * Solution approach -> 
	   * 1. add elements in list to get total pie size and get it half size
	   * 2. add list elements and find if they add up to half pie size if it ever succeeds we return true
	   * 
	   * To implement this solution approach
	   * 1. loop twice 
	   *   external loop -> to give opportunity to each number to be added to next till either its half size or more
	   *   internal loop -> to actually add the number and set return true or false
	   * 
	   * 
	   * @param listSlices  list of input ints for pie sectioning
	   * @return true if pie can be cut half.
	   */
	public boolean isPieBisected(int[] slices) {
		boolean isBisected = false;
		List<Integer> listSlices = IntStream.of(slices).boxed().collect(Collectors.toList());
		if (listSlices.isEmpty()) {
			isBisected = false;
		} else {
			float halfPieSize = listSlices.stream().reduce(0, Integer::sum)/2.0f;
			System.out.print("half of pie size :" + halfPieSize + " : ");
			outerloop:	for (int outerLoop : listSlices) {
				float sum = 0;
				// shift the list by one element so that when innner loop starts its first element is the next elemement to start the sum
		        Collections.rotate(listSlices, 1);	
		      //  System.out.println("list slices after rotation " + listSlices.toString());
		    	for (int slice : listSlices) {
		    	//	System.out.println("inner for loop " + slice);
					sum = sum + slice;
					if (sum == halfPieSize) {
						isBisected = true;
						break outerloop;
					} else if (sum > halfPieSize) {
						continue outerloop;
					}
				}
			}
		
		}
		return isBisected;
	}
	
	/* this approach does not work when consecutive values are same in list as stream does not maintain
	index reference and sublist is dependent on index and retriving index using data gives wrong index number
	when same number is repreated multiple time in list..hence need to create sum list using normal for loop approach

	List<Float> sumList = innerList.stream()
								   .map(data ->  innerList.subList(0, innerList.indexOf(data)+1)
								   .stream().reduce(0, Integer::sum).floatValue())
								   .collect(Collectors.toList());*/

	public boolean isPieBisectedJava8(int[] slices) {
		boolean isBisected = false;
		List<Integer> listSlices = IntStream.of(slices).boxed().collect(Collectors.toList());
		//no empty list check required as stream is able to handle it internally..
		float halfPieSize = listSlices.stream().reduce(0, (a, b) -> a + b).floatValue() / 2.0f;
		System.out.print("half of pie size :" + halfPieSize + " : ");
		// get the stream , create sum list for each size .. basically the sum
		// list of inner list in non java way ..
		// flatten that output to plain list as map will give list of list ..
		// check if any value matches half size..
		isBisected = listSlices
				.stream().map(slice -> 
				 {
					List<Integer> innerList = listSlices.subList(listSlices.indexOf(slice), listSlices.size());
					List<Float> sumList = new ArrayList<>();
					float sum = 0;
					for (Integer data : innerList) {
						sum += data;
						sumList.add(sum);
					}

					// System.out.println( "value of slice is : " + slice +" , inner list is : " + Arrays.toString(innerList.toArray()) + " Sum of this inner list is: " +Arrays.toString(sumList.toArray()));
					return sumList;
				}).flatMap(sumList -> sumList.stream())
				.anyMatch(data -> data == halfPieSize);

		return isBisected;
	}
	
	public static void main(String[] args) {
		PieSlicer pieSlicer = new PieSlicer();
		
		System.out.println("testing Truthy conditions ");
		Arrays.stream(getTruthyTestData()).forEach(testArray ->
			System.out.println( "test array  " + Arrays.toString(testArray) + " .is bisecting the pie : " + pieSlicer.isPieBisected(testArray))
		);

		System.out.println("*****************************************************************************");
		System.out.println("testing falsy conditions ");
		
		Arrays.stream(getFalsyTestData()).forEach(testArray ->
			System.out.println( "test array " + Arrays.toString(testArray) + " .is bisecting the pie : " + pieSlicer.isPieBisected(testArray))
		);
		
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("java8 way");
		
		System.out.println("testing Truthy conditions ");
		Arrays.stream(getTruthyTestData()).forEach(testArray ->
			System.out.println( "test array  " + Arrays.toString(testArray) + " .is bisecting the pie : " + pieSlicer.isPieBisectedJava8(testArray))
		);

		System.out.println("*****************************************************************************");
		System.out.println("testing falsy conditions ");
		
		Arrays.stream(getFalsyTestData()).forEach(testArray ->
			System.out.println( "test array " + Arrays.toString(testArray) + " .is bisecting the pie : " + pieSlicer.isPieBisectedJava8(testArray))
		);
	}

	private static int[][] getFalsyTestData() {
		int[][] testFlasyData = new int[][]{{1, 2, 3, 4, 5 },
				{2, 1, 3, 4}, 
				{10} , 
				{1000000, 1000001}, 
				{1} , 
				{1,2}, 
				{3, 1, 1}, 
				{1, 2, 1, 2, 1, 2},
				{10, 20, 10, 1}
				};
		return testFlasyData;
	}

	private static int[][] getTruthyTestData() {
		int[][] testTrueData = new int[][]{{1, 2, 3, 4}, 
				  {6, 6, 12 ,12 ,12, 11, 1, 12},
				  {1000000, 1000001, 1},
				  {1, 2, 3},
				  {1, 1},
				  {42, 42}, 
				  {1, 17, 9, 13, 2, 7, 3},
				  {3, 1, 2}, 
				  {10, 20, 10},
				  { }};
		return testTrueData;
	}
}
