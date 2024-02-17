package com.ruby.leetcode.ds;

import com.ruby.leetcode.utils.ListNode;

import static com.ruby.leetcode.utils.LeetCodeUtility.listNodeToString;
import static com.ruby.leetcode.utils.LeetCodeUtility.stringToListNode;

/**
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * example 1
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * <p>
 * example 2
 * Input: head = [1,2]
 * Output: [2,1]
 * <p>
 * Example 3:
 * Input: head = []
 * Output: []
 */
public class ReverseListRecursive {
    public ListNode reverseList(ListNode head){
        return rec(head, null);
    }

    private ListNode rec(ListNode current , ListNode prev){
        if(current == null){
            return prev;
        }
        ListNode nextCurrent = current.next;
        current.next = prev;
        prev = current;
        current = nextCurrent;
        return rec(current , prev);
    }

    public static void main(String[] args) {
        String input = "[1,2,3,4,5]";
        String output = "[5,4,3,2,1]";
        ListNode head = stringToListNode(input);
        ListNode resultNode = new ReverseListRecursive().reverseList(head);
        String result = listNodeToString(resultNode);
        assert output == result;
        System.out.printf("result is %s%n" , result);
        resultNode = new ReverseListRecursive().reverseList(stringToListNode("[1,2]"));
        System.out.printf("result is %s%n" , listNodeToString(resultNode));
    }
}
