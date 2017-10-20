package com.ruby.stream;

public class ArraySumCartesian {

	public static void main(String args[]) {
		Integer[] numbersArray = new Integer[] { 1, 2, 3, 4, 5 };
		
/*		 Arrays.stream(numbersArray).collect(new ArrayList<Integer>(), data -> new ArrayList<Integer>().add(data),  ArrayList::addAll);
		System.out.println("after stream processing");
		Arrays.toString(updated);
		*/
		
	/*	 List<String> list2 = Arrays.asList("adf", "bcd", "abc", "hgr", "jyt", "edr", "biu");

		    String collect = list2.stream().collect(StringBuilder::new, 
		    		(res, elem) -> {
		        res.append(" ").append(elem);
		    }, 
		    (res1, res2) -> {
		        res1.append(res2.toString());
		        System.out.printf("res1=%s, res2=%s\n", res1, res2);
		    }).toString();
		    System.out.println("collect=" + collect);

		System.out.println(Arrays.stream(numbersArray).collect(
				Collectors.counting()));

		System.out.println(Arrays.stream(numbersArray).collect(
				Collectors.summingInt((Integer x) -> x)));

		System.out.println(Arrays.stream(numbersArray).collect(
				Collectors.averagingInt((Integer x) -> x)));

		System.out.println(Arrays.stream(numbersArray)
				.collect(Collectors.maxBy(Integer::compare)).get());

		System.out.println(Arrays.stream(numbersArray)
				.collect(Collectors.minBy(Integer::compare)).get());

		System.out.println(Arrays.stream(numbersArray).collect(
				Collectors.summarizingInt((Integer x) -> x)));
		
		Stream<String> words = Stream.of("Java", "Magazine", "is", 
			     "the", "best");

			Map<String, Long> letterToCount =words.map(w -> w.split(""))
			                                   .flatMap(Arrays::stream)
			                                   .collect(groupingBy(identity(), counting()));
			System.out.println(letterToCount.toString());*/
	}

	private static int[][] getFalsyTestData() {
		int[][] testFlasyData = new int[][] { { 1, 2, 3, 4, 5 },
				{ 2, 1, 3, 4 }, { 10 }, { 1000000, 1000001 }, { 1 }, { 1, 2 },
				{ 3, 1, 1 }, { 1, 2, 1, 2, 1, 2 }, { 10, 20, 10, 1 } };
		return testFlasyData;
	}

}
