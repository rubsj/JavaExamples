package com.ruby.leetcode.sort;

import com.ruby.leetcode.utils.ListNode;

import static com.ruby.leetcode.utils.LeetCodeUtility.listNodeToString;
import static com.ruby.leetcode.utils.LeetCodeUtility.stringToListNode;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 */
public class MergeTwoLists {
    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode merged;
        if(list1.val < list2.val){
            merged = list1;
            merged.next = mergeTwoListsRecursive(list1.next, list2);
        }else{
            merged = list2;
            merged.next = mergeTwoListsRecursive(list1, list2.next);
        }
        return merged;
    }

    public ListNode mergeTwoListsIterate(ListNode list1, ListNode list2){
        ListNode merged;
        ListNode temp = new ListNode(0 );
        merged = temp;
        while(list1!= null && list2 != null){
            if(list1.val < list2.val){
                merged.next = list1;
                list1 = list1.next;
            }else{
                merged.next = list2;
                list2 = list2.next;
            }
            merged = merged.next;
        }
        merged.next = list1 == null ? list2 : list1;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode l1 = stringToListNode("[1,2,4]");
        ListNode l2 = stringToListNode("[1,3,4]");
    //    ListNode l1l2 = new MergeTwoLists().mergeTwoListsIterate(l1, l2);
      //  String outL1l2 = listNodeToString(l1l2);
        //       System.out.print(outL1l2);

        ListNode l3 = stringToListNode("[1,2,4]");
        ListNode l4 = stringToListNode("[1,3,4]");
        ListNode l3l4 = new MergeTwoLists().mergeTwoListsRecursive(l3, l4);
        String outL3l4 = listNodeToString(l3l4);


        System.out.println(outL3l4);
    }
}
