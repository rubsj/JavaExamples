package com.ruby.leetcode.sort;

import com.ruby.leetcode.utils.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 *
 * Merge all the linked-lists into one sorted linked-list and return it.
 *
 *
 *
 * Example 1:
 *
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * Example 2:
 *
 * Input: lists = []
 * Output: []
 * Example 3:
 *
 * Input: lists = [[]]
 * Output: []
 *
 *
 * Constraints:
 *
 * k == lists.length
 * 0 <= k <= 104
 * 0 <= lists[i].length <= 500
 * -104 <= lists[i][j] <= 104
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length will not exceed 104.
 */
public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        List<ListNode> list = Arrays.asList(lists);
      while(list.size() > 1){
          List<ListNode> resultList = new ArrayList<>();
          for(int i=0; i < list.size(); i = i+2){
              ListNode left = list.get(i);
              ListNode right;
              if(i+1 >= list.size()){
                  right = null;
              }else{
                  right = list.get(i+1);
              }
              ListNode merged = merge(left, right);
              resultList.add(merged);
          }
          list = resultList;
      }

      return list.get(0);
    }

    private ListNode merge(ListNode left, ListNode right){
        ListNode merge = new ListNode();
        ListNode current = merge;
        while(left != null && right != null){
            if(left.val <= right.val ){
                current.next = new ListNode(left.val , null);
                left = left.next;
            }else{
                current.next = new ListNode(right.val , null);
                right = right.next;
            }
            current = current.next;
        }

        current.next = left != null ? left : right;

        return merge.next;
    }

    private String listNodeToString(ListNode node) {
        if (node == null) {
            return "[]";
        }

        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return "[" + result.substring(0, result.length() - 2) + "]";
    }

    public static void main(String[] args) {
        MergeKLists mergeKLists = new MergeKLists();

        ListNode item1 = new ListNode(1);
        item1.next = new ListNode(4);
        item1.next.next = new ListNode(5);

        ListNode item2 = new ListNode(1);
        item2.next = new ListNode(3);
        item2.next.next = new ListNode(4);

        ListNode item3 = new ListNode(2);
        item3.next = new ListNode(6);

        ListNode[] case1Lists  = new ListNode[]{item1, item2 , item3};
        ListNode result =  mergeKLists.mergeKLists(case1Lists);

        System.out.printf("The merged linked list is %s %n" , mergeKLists.listNodeToString(result));
    }
}
