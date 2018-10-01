package com.ruby.generics;

public class GenericClassOneType<T> {
    void performAction(final T action){
        // implemetation here
        System.out.println("GenericClassOneType" + action.toString());
    }
}

