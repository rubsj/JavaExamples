package com.ruby.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringStreamOperations {
	/**
	 * JDK internally uses StringJoiner class to join string using strem or String.join methods.. 
	 */
    public static void main(String[] args) {
		joinString();
		cancatenateStreams();
		
		System.out.printf(" %sdone", "\n");
	}

	private static void joinString() {
		String[] abc = new String[]{"a", "b" , "c", "d"};
		String joinedStr = Arrays.stream(abc).collect(Collectors.joining(", " , "[ " , " ]"));
		System.out.println(joinedStr);
		
		String usingString = String.join(":", abc);
		System.out.println(usingString);
	}
	
	public static void cancatenateStreams(){
		Stream<Character> combined = Stream.concat(characterStream("Hello"), characterStream("World"));
		combined.forEach(s -> System.out.printf("'%c' ", s));
	}
	
	//ways to convert string to Stram<Character>
	public static Stream<Character> characterStream(String str){
		//return str.chars().mapToObj(c-> (char)c);
		 return Pattern.compile("[\\P{L}]*").splitAsStream(str).map(w -> w.charAt(0));
		//return Stream.of(str.split("[\\P{L}]*")).map(w -> w.charAt(0));
	}
	
	//stream flat map example
	//TODO complete it
	public static void StreamFlatmapusage(){
		try {
			List<String> fileLines = Files.readAllLines(Paths.get("/Quote.txt"));
		 fileLines.stream()
					.map(line -> Pattern.compile("[\\P{L}]*").splitAsStream(line))
					.peek(line -> System.out.println("split line : " + line))
					.flatMap(word -> word.map(w -> characterStream(w)));
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
