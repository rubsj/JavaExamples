package com.ruby.leetcode.utils;

import lombok.ToString;

@ToString
public class Pair {
    public int key;
    public String value;
    public Pair(int key, String value){
        this.key = key;
        this.value = value;
    }
}
