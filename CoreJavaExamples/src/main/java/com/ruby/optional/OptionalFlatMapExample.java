package com.ruby.optional;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalFlatMapExample {
	
	private Optional<Double> inverse(double inv){
		return inv ==0 ? Optional.empty() : Optional.of(1/inv); 
		
	}
	
	private Optional<Double> squareRoot(double root){
		return root <0 ? Optional.empty() : Optional.of(Math.sqrt(root));
	}
	
	public static void main(String[] args) {
		OptionalFlatMapExample example = new OptionalFlatMapExample();
		Double[] testInputs =  new Double[]{2.0 ,0.0, -2.0 , 4.0 ,10.0 , -10.0};
		Stream.of(testInputs).forEach(input -> {
			System.out.println("input is : " + input);
		
			System.out.printf("Inversed number of %f is %3.3f %n", input , example.inverse(input).orElse(0.0));
		
			System.out.printf("Square rootr of %f is %3.3f %n", input , example.squareRoot(input).orElse(0.0));
			
			//first get inverse and then square root using flatmap
			Optional<Double> finalVal =  example.inverse(input).flatMap(example::squareRoot);
			System.out.printf("final value after applying both the functions : %3.3f %n" , finalVal.orElse(0.0));
		
		});
		
	}

}
