package com.ruby.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class IterateStream {
	public void processWords() {
		try {
			List<String> fileLines = Files.readAllLines(Paths.get("/AliceInWinderland.txt"));
			// fileLines.forEach(System.out::println);
			int overallCount = 0;
			for (String line : fileLines) {

				List<String> words = Arrays.asList(line.split("[\\P{L}]+"));
				int count = 0;
				for (String w : words) {
					if (w.length() > 6) {
						count++;
					}
				}
				overallCount += count;
			}
			System.out.println("total count of  words greater than size 6 : "	+ overallCount);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void processWordsJava8() {
		try {
			List<String> fileLines = Files.readAllLines(Paths.get("/AliceInWinderland.txt"));

			long overallCount = fileLines
					.stream()
					.map(str -> {
						List<String> words = Arrays.asList(str.split("[\\P{L}]+"));
						long count = words.stream().filter(w -> w.length() > 6).count();
						return count;})
					.reduce((long) 0, (a, b) -> a + b);
			
			System.out.println("total count of  words greater than size 6 : " + overallCount);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		IterateStream iterateStream = new IterateStream();
		iterateStream.processWords();
		System.out.println("calling java 8 way now ");
		iterateStream.processWordsJava8();
	}

}
