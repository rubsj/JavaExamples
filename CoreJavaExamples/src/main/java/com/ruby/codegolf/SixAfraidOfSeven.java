package com.ruby.codegolf;

import java.util.stream.Stream;

/**
 * Codegolf link : ->
 * http://codegolf.stackexchange.com/questions/66603/why-was-6-afraid-of-7
 * 
 * Why was 6 afraid of 7? Because 7 8 9!
 * 
 * Given a string apply the following transformations:
 * 
 * If there is a 6 next to a 7 remove the 6 (6 is afraid of 7) If the sequence
 * "789" appears remove the 8 and the 9 (7 ate 9) (If I'm not mistaken it
 * doesn't matter what order you do the transformations in)
 * 
 * Keep applying these transformations until you can no longer.
 * 
 * Example:
 * 
 * 78966
 * 
 * First we see "789", so the string becomes "766". Then we see "76", so we take
 * out the 6, and the string becomes "76". Then we see "76" again, so we are
 * left with "7".
 * 
 * Test Cases:
 * 
 * 987 => 987 (Not in the right order. Does nothing.)
 * 6 7 => 6 7 (The whitespace acts as a buffer between 6 and 7. Nothing happens) 
 * 676 => 7 
 * 7896789 => 77
 * 7689 => 7 
 * abcd => abcd
 * 
 * TODO imeplement it
 * @author rjha
 *
 */
public class SixAfraidOfSeven {

	public static void main(String[] a) {
		SixAfraidOfSeven ofSeven = new SixAfraidOfSeven();
		String[] testcases = new String[]{"987", "6 7", "676", "7896789", "7689", "abcd"};
		Stream.of(testcases).map(ofSeven::performAction).forEach(s-> System.out.printf("The transformed String is %s%n" ,s));
	
	}

	String performAction(String x) {
		for (; x != (x = x.replaceAll("67|76|789", "7"));)
			;
		return x;
	}

}
