package com.ruby.codegolf;

/**
 * code golf link->
 * http://codegolf.stackexchange.com/questions/68504/swap-the-alphabet
 * 
 * In this challenge, you will be "reversing" the alphabet or swapping a-z with z-a
 * 
 * Specification
 * 
 * 1. The input may contain multiple lines, and will be ASCII-only
 * 2. No additional whitespace should be added to the output 
 * 3. Case must be preserved
 * 
 * Examples
 * 
 * abcdefghijklmnopqrstuvwxyz
 * zyxwvutsrqponmlkjihgfedcba
 * 
 * Programming Puzzles & Code Golf Kiltiznnrmt Kfaaovh & Xlwv Tlou
 * 
 * Hello, World! 
 * Svool, Dliow! 
 * 

 * TODO implement it
 * @author rjha
 *
 */
public class SwapTheAlphabet {

	static void x(String i) {
		for (char c : i.toCharArray()) {
			if (Character.isLetter(c))
				c = c < 91 ? (char) (90 - (c - 65)) : (char) (122 - (c - 97));
			System.out.print(c);
		}
	}

	public static void main(String[] args) {
		x("Programming Puzzles & Code Golf");
		// produces "Kiltiznnrmt Kfaaovh & Xlwv Tlou"
		System.out.println(" ");
		x("Hello World");
	}

}
