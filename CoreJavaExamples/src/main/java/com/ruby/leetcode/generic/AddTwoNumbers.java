package com.ruby.leetcode.generic;

import java.util.LinkedList;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public LinkedList<Integer> addTwoNumbers(LinkedList<Integer> l1, LinkedList<Integer> l2) {
        LinkedList<Integer> result = new LinkedList<>();
        if (l1.size() > l2.size()) {
            for (int i = l2.size(); i < l1.size(); i++) {
                l2.add(i, 0);
            }
        } else if (l2.size() > l1.size()) {

            for (int i = l1.size(); i < l2.size(); i++) {
                l1.add(i, 0);
            }
        }

        int carryOver = 0;
        for (int i = 0; i < l1.size(); i++) {
            int sum = (l1.get(i) + l2.get(i) + carryOver) % 10;
            if(l1.get(i) + l2.get(i)>=10){
                carryOver = 1;
            }else{
                carryOver = 0;
            }

            result.add(i, sum);
        }
        return result;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        LinkedList<Integer> l1 = new LinkedList<>();
        l1.add(0, 2);
        l1.add(1, 4);
        l1.add(2, 3);
        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(0, 5);
        l2.add(1, 6);
        l2.add(2, 4);
        System.out.println(l1.toString());
        System.out.println(l2.toString());
        LinkedList<Integer> l3 = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(l3);
    }
}

