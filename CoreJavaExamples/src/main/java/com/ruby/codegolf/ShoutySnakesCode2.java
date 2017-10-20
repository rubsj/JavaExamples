package com.ruby.codegolf;

import java.util.EnumSet;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * The pattern is pretty simple, it takes a String input, verifies if it is
 * numerical, and if so, converts it to SHOUTY_SNAKE_CASE. Example : "1231" ->
 * "ONE_TWO_THREE_ONE"
 * 
 * @author rjha
 *
 */
public class ShoutySnakesCode2 {
	// approach 2
		private enum Word{  ZERO('0'), ONE('1'), TWO('2'), THREE('3'), FOUR('4'), FIVE('5'), SIX('6'), SEVEN('7'), EIGHT('8'), NINE('9');
		    private static final  Map<Character , Word> wordsMapped = 
		    		EnumSet.allOf(Word.class).stream().collect(Collectors.toMap(Word::getCode, Function.identity()));
	    
		
		    private char code;
		    //using char as code type as int value from char array comes as 48 , 49 etc ..
		    private Word(char code) {
				this.code = code;
			}
		    
		    public char getCode(){
		    	return code;
		    }
		    

		};
		private static final String NUMBERS_ONLY = "^\\d*$";
		
		public String convertNumbersToWords2(final String input) {
			
		
			return Optional.ofNullable(input)
					.filter(inpt -> inpt != null && inpt.matches(NUMBERS_ONLY))
			        .orElseThrow(IllegalArgumentException::new)
			        .chars()   //the chars function return intstream where the int value for char is provided like '0'==48			        
			        .mapToObj(i -> (char)i)  //map the  char int value to char value 			         
			        .map(c-> Word.wordsMapped.get(c).toString())  //map this char'0' etc to enum value using static map in enum
			        .collect(Collectors.joining("_"));
			
		
		}
		
		public static void main(String[] args) {
			ShoutySnakesCode2 snakesCode2 = new ShoutySnakesCode2();
			String convertedStr = snakesCode2.convertNumbersToWords2("12345");
			System.out.println(convertedStr);
		}

}
