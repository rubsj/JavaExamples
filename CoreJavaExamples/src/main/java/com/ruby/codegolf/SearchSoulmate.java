package com.ruby.codegolf;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.function.Function;

/**
 * Given a nonempty finite list of integers, output a truthy value
 * if there are exactly two equal entries and all other entries are distinct,
 * and a falsey value otherwise
 * <p>
 * truthy:
 * [1,1]
 * [1,2,1]
 * [1,6,3,4,4,7,9]
 * <p>
 * falsey:
 * [0]
 * [1,1,1]
 * [1,1,1,2]
 * [1,1,2,2]
 * [2,1,2,1,2]
 * [1,2,3,4,5]
 *
 * Solution approach - Get the count of distinct elements and that should be equal to total count -1
 */
public class SearchSoulmate {
    private Integer[][] getTestData() {
        return new Integer[][]{
                {1, 1},
                {1, 2, 1},
                {1, 6, 3, 4, 4, 7, 9},
                {0},
                {1, 1, 1},
                {1, 1, 1, 2},
                {1, 1, 2, 2},
                {2, 1, 2, 1, 2},
                {1, 2, 3, 4, 5},
                {},
                null
        };


    }

    private boolean searchSoulMateApproach1(Integer[] inputData) {
        Function<Integer[], Boolean> soulMatFunction = (Integer[] a) -> new HashSet<>(Arrays.asList(a)).size() == (a.length - 1);
        return soulMatFunction.apply(inputData);

    }


    private boolean searchSoulMateApproach2(Integer[] inputData) {
        Function<Integer[], Boolean> soulMatFunction = (Integer[] a) -> Arrays.stream(a).distinct().count() == (a.length - 1);
        return soulMatFunction.apply(inputData);

    }

    public static void main(String[] args) {
        SearchSoulmate searchSoulmate = new SearchSoulmate();
  /*      for (Integer[] testData : searchSoulmate.getTestData()) {
            System.out.printf("using approach 1 For the input %s the output is %b%n", Arrays.toString(testData), searchSoulmate.searchSoulMateApproach1(testData));
            System.out.printf("using approach 2 For the input %s the output is %b%n ", Arrays.toString(testData), searchSoulmate.searchSoulMateApproach2(testData));
        }*/
        Arrays.stream(searchSoulmate.getTestData())
              .filter(Objects::nonNull)
              .forEach(a -> System.out.printf("using approach 1 For the input %s the output is %b%n", Arrays.toString(a), searchSoulmate.searchSoulMateApproach1(a)));
        Arrays.stream(searchSoulmate.getTestData())
              .filter(Objects::nonNull)
              .forEach(a -> System.out.printf("using approach 2 For the input %s the output is %b%n", Arrays.toString(a), searchSoulmate.searchSoulMateApproach2(a)));
    }
}

