package com.ruby.stream;

import java.util.StringJoiner;
/**
 * The purpose of this class is to create string from char array using stream approach
 * the chars() function return intStream and to convert it to string requires using collect function
 * 
 * @author rjha
 *
 */
public class CharStreamToString {
	public static void main(String[] args) {
		String abc = "abcdefghijklmnopqrstuvwxyz";
		//approach one
		StringBuilder builtStr = abc.chars() 
									.collect(StringBuilder::new, (strBldr , c) -> strBldr.append((char)c), StringBuilder::append);
		System.out.println(builtStr);
		
		//approach 2
		String joinedStr = abc.chars()
							  .mapToObj(c -> (char)c)
							  .collect(() -> new StringJoiner(" : ", "[", "]"),
									  (strJnr , c) -> strJnr.add(String.valueOf(c)), 
									  StringJoiner::merge)
							  .toString();
		System.out.println(joinedStr);
	}

}
