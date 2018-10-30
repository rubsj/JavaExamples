package com.ruby.puzzle;

/**
 * created by Ruby Jha on 10/29/2018
 *
 * You are given an array of characters arr that consists of sequences of characters separated by space characters. Each space-delimited sequence of characters defines a word.
 *
 * Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.
 *
 * Explain your solution and analyze its time and space complexities.
 * 
 */
public class SentenceReverse {

    static char[] reverseWords(char[] arr) {
        // your code goes here

        arr = reverseArray(arr, 0, arr.length);
        int wordIndex = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] == ' ') {
                arr = reverseArray(arr, wordIndex, j);
                wordIndex = j + 1;
            }
            if (j == arr.length - 1) {
                arr = reverseArray(arr, wordIndex, arr.length);
            }
        }

        System.out.println(arr);
        return arr;


    }

    static private char[] reverseArray(char[] arr, int reverseStartPosition, int reverseEndPosition) {
        int iEnd = (reverseStartPosition + reverseEndPosition) / 2;
        for (int i = reverseStartPosition, k = 0; i < iEnd; i++, k++) {

            char temp = arr[i];
            arr[i] = arr[reverseEndPosition - k - 1];
            arr[reverseEndPosition - k - 1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {

        char[] input = new char[]{
                'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'
        };

        char[] output = reverseWords(input);
        System.out.println(output);


        //test case 1 ['' '']
        // case 2 ["a"," "," ","b"]
        //case 3 ["h","e","l","l","o"]
        //case 4 ["p","e","r","f","e","c","t"," ","m","a","k","e","s"," ","p","r","a","c","t","i","c","e"]
        // case 5 ["y","o","u"," ","w","i","t","h"," ","b","e"," ","f","o","r","c","e"," ","t","h","e"," ","m","a","y"]
        // case 6 ["g","r","e","a","t","e","s","t"," ","n","a","m","e"," ","f","i","r","s","t"," ","e","v","e","r"," ","n","a","m","e"," ","l","a","s","t"]
    }
}

