/**
 * Created on 10/5/2018
 * <p>
 * problem Statement : MAP THE CLOSING BRACKETS WITH THE CORRESPONDING OPENING BRACKETS
 */
package com.ruby.datastructure.fromZeroToOne.stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MatchParenthesis {
    private static final HashMap<Character, Character> matchingParentMap = new HashMap<>();
    private static final HashSet<Character> openingParenset = new HashSet<>();

    static {
        matchingParentMap.put('}', '{');
        matchingParentMap.put(']', '[');
        matchingParentMap.put(')', '(');
        openingParenset.addAll(matchingParentMap.values());
    }

    public static void main(String[] args) {
        MatchParenthesis matchParenthesis = new MatchParenthesis();
        String testString;
        Scanner scanner = new Scanner(System.in);
        Pattern pt = Pattern.compile("yes|y|true", Pattern.CASE_INSENSITIVE);
        boolean testAnother = true;
        while (testAnother) {
            System.out.println("Enter the testString to test");
            testString = scanner.nextLine();
            boolean match = hasMatchingParenthesis(testString);
            System.out.printf("the parenthesis match %b%n", match);
            System.out.println("Do you want to test another scenario");
            String testAn = scanner.nextLine();
            testAnother = pt.matcher(testAn).find();
        }
        System.out.println("thanks for testing , see you again next time");
    }


    public static boolean hasMatchingParenthesis(String input) {
        java.util.Stack<Character> parenStack = new java.util.Stack<>();

        for (int i = 0; i < input.length(); i++) {
            //get the current character from the string iteration
            Character currentChar = input.charAt(i);
            // if the char is an opening parenthesis push it onto stack
            if (openingParenset.contains(currentChar)) {
                parenStack.push(currentChar);
            }
            //if the char is an closing parenthesis , pop the opening parenthesis from stack to see if it matches the closing bracket
            if (matchingParentMap.containsKey(currentChar)) {
                Character topOfStack = parenStack.pop();
                if (topOfStack != matchingParentMap.get(currentChar)) {
                    return false;
                }
            }
        }
        return parenStack.isEmpty();

    }

}

