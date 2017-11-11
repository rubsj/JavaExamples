package com.ruby.puzzle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Collectors;

/***
 * Given an array input [1 ,1,2,2,2,3,4,,5,5,4,5,6,7,5,6,7]
 *
 * Find the numbers that is biggest in the given array
 *
 */
public class BiggestInArray {
    public static void main(String[] args) {
        BiggestInArray biggestInArray = new BiggestInArray();
        Arrays.stream(biggestInArray.getTestData())
                .forEach((Object input) -> {
                            // System.out.printf("the first input is : %s%n", Arrays.stream((Integer[]) input).filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(",")));
                            System.out.printf("the first input is : %s%n", Arrays.toString((Integer[]) input));
                            biggestInArray.getBiggestJava8Way((Integer[]) input);
                        }
                );

       /* for(Object input : biggestInArray.getTestData()){
            biggestInArray.getBiggestJava8Way((Integer[])input) ;
        }*/
        int result = biggestInArray.getBiggest(new Integer[]{1, -1, 2, 2, 2, 3, 4, 5, 5, 4, 5, 6, 7, 5, 6, 7});
        System.out.printf("biggest int is %d %n", result);
        //biggestInArray.getBiggestJava8Way(new Integer[]{1, -1, 2, 2, 2, 3, 4, 5, 5, 4, null, 6, 7, 5, 6, 7});
    }

    private Integer getBiggest(Integer[] input) {
        Integer result = input[0];
        for (Integer i : input) {
            if (i.compareTo(result) > 0) {
                result = i;
            }
        }
        return result;
    }

    private void getBiggestJava8Way(Integer[] input) {
        if (null != input) {
            Arrays.stream(input)
                    .filter(Objects::nonNull)
                    .reduce((a, b) -> Integer.max(a, b))
                    .ifPresent(i -> System.out.printf("the biggest integer is %d%n", i));

            //same as above shorter code
            Arrays.stream(input)
                    .filter(Objects::nonNull)
                    .reduce(Integer::max)
                    .ifPresent(i -> System.out.printf("reduce approach the biggest integer is %d%n", i));

            //another way
            Arrays.stream(input)
                    .filter(Objects::nonNull)
                    .collect(Collectors.maxBy(Comparator.naturalOrder()))
                    .ifPresent(i -> System.out.printf("Collector's way the biggest integer is %d%n", i));

            //one more way
            System.out.printf("Collector's way 2 the biggest integer is %d%n",
                    Arrays.stream(input)
                            .filter(Objects::nonNull)
                            .collect(Collectors.summarizingInt(Integer::intValue)).getMax());
        }
    }

    private Object[] getTestData() {
        Integer[] test1 = new Integer[]{-1, -4, 0};
        Integer[] test2 = new Integer[]{1, 4, 0};
        Integer[] test3 = new Integer[]{1, -1, 2, 2, 2, 3, 4, 5, 5, 4, null, 6, 7, 5, 6, 7};
        Integer[] test4 = null;
        Integer[] test5 = new Integer[]{};
        return new Object[]{test1, test2, test3, test4, test5};
    }

}

