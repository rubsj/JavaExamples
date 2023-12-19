package com.ruby.leetcode.utils;


import lombok.ToString;

@ToString
public class ListNode {
    public int val;
    @ToString.Exclude
    public ListNode next;

    public ListNode(){}
    public ListNode(int x) { val = x; }

    public  ListNode(int val, ListNode next) { this.val = val; this.next = next; }

}