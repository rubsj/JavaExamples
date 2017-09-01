package com.ruby.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IterateStream {
	public void processWords(){
		try {
			List<String> fileLines = Files.readAllLines(Paths.get("testSource/AliceInWinderland.txt"));
			fileLines.forEach(System.out::println);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		IterateStream iterateStream = new IterateStream();
		iterateStream.processWords();
	}

}
