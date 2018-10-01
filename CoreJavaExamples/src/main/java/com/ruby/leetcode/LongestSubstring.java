package com.ruby.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * AU
 * A
 */
public class LongestSubstring {

    /***
     * Sliding Window
     *
     * By using HashSet as a sliding window, checking if a character in the current can be done in O(1).
     * A sliding window is an abstract concept commonly used in array/string problems.
     * A window is a range of elements in the array/string which usually defined by the start and end indices, i.e. [i, j)(left-closed, right-open).
     * A sliding window is a window "slides" its two boundaries to the certain direction.
     * For example, if we slide [i, j) to the right by 1 element, then it becomes [i+1, j+1)(left-closed, right-open).
     *
     * Back to our problem. We use HashSet to store the characters in current window [i, j) (j = i initially).
     * Then we slide the index j to the right. If it is not in the HashSet, we slide j further.
     * Doing so until s[j] is already in the HashSet.
     * At this point, we found the maximum size of substrings without duplicate characters start with index i.
     * If we do this for all i, we get our answer.
     *
     *
     * Complexity Analysis
     * Time complexity : O(2n) = O(n). In the worst case each character will be visited twice by i and j.
     * Space complexity : O(min(m, n)). Same as the previous approach. We need O(k) space for the sliding window, where k is the size of the Set.
     * The size of the Set is upper bounded by the size of the string n and the size of the charset/alphabet m.
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return ans;
    }

    /**
     * Sliding Window Optimized
     * The above solution requires at most 2n steps. In fact, it could be optimized to require only n steps.
     * Instead of using a set to tell if a character exists or not, we could define a mapping of the characters to its index.
     * Then we can skip the characters immediately when we found a repeated character.
     * <p>
     * The reason is that if s[j]s[j] have a duplicate in the range [i, j)[i,j) with index j',
     * we don't need to increase i little by little. We can skip all the elements in the range [i, j']
     * and let i to be j'+1 directly.
     *
     * Complexity Analysis
     * Time complexity : O(n). Index j will iterate n times.
     * Space complexity (HashMap) : O(min(m, n)). Same as the previous approach.
     * 
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }

            map.put(s.charAt(j), j++);
            ans = Math.max(ans, j - i + 1);
        }

        return ans;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        System.out.println("Enter next String");
        while ((line = in.readLine()) != null) {

            String s = line;

//            int ret = new LongestSubstring().lengthOfLongestSubstring(s);
            int ret = new LongestSubstring().lengthOfLongestSubstring2(s);

            String out = String.valueOf(ret);

            System.out.println(out);
            System.out.println("Enter next String");
        }
    }
}

