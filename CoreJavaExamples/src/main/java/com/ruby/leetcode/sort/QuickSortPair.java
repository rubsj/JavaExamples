package com.ruby.leetcode.sort;

import com.ruby.leetcode.utils.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement Quick Sort.
 * <p>
 * Quick Sort is a divide-and-conquer sorting algorithm that works by partitioning an array into two smaller sub-arrays based on a pivot element. The elements less than the pivot go to the left sub-array and those greater go to the right sub-array. The algorithm then recursively sorts the sub-arrays.
 * <p>
 * Objective:
 * <p>
 * Given a list of key-value pairs, sort the list by key using Quick Sort. For each partitioning step:
 * <p>
 * Use the right-most element as the pivot.
 * Elements less than the pivot should be placed to the left of the pivot, and elements greater than or equal to the pivot should be placed to the right of the pivot.
 * The correctness of your solution will be determined based on these requirements.
 * <p>
 * Input:
 * <p>
 * pairs - a list of key-value pairs, where each key-value has an integer key and a string value. (0 <= pairs.length <= 100).
 * Example 1:
 * <p>
 * Input:
 * pairs = [(3, "cat"), (2, "dog"), (3, "bird")]
 * <p>
 * Output:
 * [(2, "dog"), (3, "bird"), (3, "cat")]
 * Note: As you can see, the solution is not necessarily stable. The two pairs with the key 9 have switched their relative positions.
 * <p>
 * Example 2:
 * <p>
 * Input:
 * pairs = [(5, "apple"), (9, "banana"), (9, "cherry"), (1, "date"), (9, "elderberry")]
 * <p>
 * Output:
 * [(1, "date"), (5, "apple"), (9, "elderberry"), (9, "cherry"), (9, "banana")]
 */
public class QuickSortPair {
    public List<Pair> quickSort(List<Pair> pairs) {
        if (pairs.isEmpty()) {
            return pairs;
        }
        return quickSort(pairs, 0, pairs.size() - 1);
    }

    private List<Pair> quickSort(List<Pair> pairs, int start, int end) {
        if (end - start + 1 <= 1) {
            return pairs;
        }
        Pair pivot = pairs.get(end);
        int left = start;

        for (int i = start; i < end; i++) {
            if (pairs.get(i).key < pivot.key) {
                Pair temp = pairs.get(i);
                pairs.set(i, pairs.get(left));
                pairs.set(left, temp);
                left++;
            }
        }

        Pair temp = pairs.get(left);
        pairs.set(left, pivot);
        pairs.set(end, temp);

        quickSort(pairs, start, left - 1);
        quickSort(pairs, left + 1, end);

        return pairs;
    }

    public static void main(String[] args) {
        QuickSortPair sortPair = new QuickSortPair();

        List<Pair> case1 = new ArrayList<>();
        case1.add(new Pair(5, "apple"));
        case1.add(new Pair(9, "banana"));
        case1.add(new Pair(9, "cherry"));
        case1.add(new Pair(1, "date"));
        case1.add(new Pair(9, "elderberry"));

        List<Pair> case2 = new ArrayList<>();
        case2.add(new Pair(3, "cat"));
        case2.add(new Pair(2, "dog"));
        case2.add(new Pair(3, "bird"));

        List<Pair> result = sortPair.quickSort(case1);
        System.out.printf("Case 1: result after sorting is %s%n%n", result.toString());

        result = sortPair.quickSort(case2);
        System.out.printf("Case 2: result after sorting is %s%n%n", result.toString());
    }
}
