package com.ruby.codegolf;

import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * 
 * My friend made a lisp translator the other day, that is to say it took a string and converted s=>th and S=>Th. It was quite long and I thought that it could be golfed.
 * So the task is to make a program/function that takes an input string, translates it in to lisp and outputs the string

Test case
Sam and Sally like Sheep        Tham and Thally like Thheep
Sally likes sausages            Thally liketh thauthageth
Sally sells seashells           Thally thellth theathhellth


Note that it doesn't matter that h gets repeated all the time

 * 
 * @author rjha
 *
 */
public class LithpTranthlator {
	
	public static void main(String[] args) {
	
		UnaryOperator<String> optr  = s->s.replace("S","Th").replace("s","th");
		
		String[] testInputs = new String[]{
				"Sam and Sally like Sheep",
				"Sally likes sausages",
				"Sally sells seashells"
		};
		
		Stream.of(testInputs).forEach(input -> System.out.println(optr.apply(input)));
		
	}

}
