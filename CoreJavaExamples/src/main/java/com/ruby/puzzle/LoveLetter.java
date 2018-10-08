/*
Created by Ruby Jha on 10/8/2018

Problem Statement -
You have written an anonymous love letter and you don’t want your handwriting to be recognized.
Since you don’t have a printer within reach, you are trying to write this letter by copying and pasting characters from a newspaper.
Given a string L representing the letter and a string N representing the newspaper,
return true if the L can be written entirely from N and false otherwise.
The letter includes only ascii characters.

Time complexity O(n)
space complexity O(n+m)

 */
package com.ruby.puzzle;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class LoveLetter {
    public static void main(String[] args){
        String letter = "I love to write letter";
        String newsPaper ="abc"; // "I love to write letter"; //"I am being copied for letter";

        LoveLetter letterTester = new LoveLetter();
        Scanner scanner = new Scanner(System.in);
        Pattern pt =  Pattern.compile("yes|true", Pattern.CASE_INSENSITIVE);
        boolean testAnother=true;
        while(testAnother){
           System.out.println("Enter the letter to test");
            letter = scanner.nextLine();
            System.out.println("print the newspaper test");
            newsPaper = scanner.nextLine();
            boolean test = letterTester.isLetterCopiable(letter , newsPaper);
            System.out.printf("The letter is  copiable %b %n" , test);
            System.out.println("Do you want to test more");
            String testAn =  scanner.nextLine();
            testAnother = pt.matcher(testAn).find();
        }
        System.out.println("thanks for testing , see you again next time");


    }

    public boolean isLetterCopiable(String l , String n){

        List<Character> lArray= l.chars().mapToObj(e -> (char)e).filter(Character::isLetterOrDigit).collect(Collectors.toList());
        List<Character> nArray = n.chars().mapToObj(e -> (char)e).filter(c -> Character.isLetterOrDigit(c)).collect(Collectors.toList());

        for(Character le : lArray){
           if(!nArray.contains(le)) {
               return false;
           }else{
               nArray.remove(le);
           }

        }

        return true;
    }
}

