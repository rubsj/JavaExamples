package com.ruby.codegolf;

import java.util.stream.Collectors;

/**
 * he pattern is pretty simple, it takes a String input, verifies if it is
 * numerical, and if so, converts it to SHOUTY_SNAKE_CASE. Example : "1231" ->
 * "ONE_TWO_THREE_ONE"
 * 
 * @author rjha
 *
 */
public class ShoutySnakesCode {

	private static final String[] words = new String[] { "zero", "one", "two",
			"three", "four", "five", "six", "seven", "eight", "nine" };
	
	private String getWordFromCharCode(int code) {
		return words[code - 48];
	}

	//approach 1
	public String convertNumbersToWords(final String input) {

		if (input == null || !input.matches("^\\d*$")) {
			throw new IllegalArgumentException(
					"input cannot be null or non-numerical.");
		}

		return input.chars()
				.mapToObj(c -> getWordFromCharCode(c).toUpperCase())
				.collect(Collectors.joining("_"));
	}
	
	

	public static void main(String[] args) {
		ShoutySnakesCode code = new ShoutySnakesCode();
		String output = code.convertNumbersToWords("345");
		System.out.println(output);
	}

}
