package com.ruby.generics;

public class GenericClassImplementingGenericInterface<T> implements GenericInterfaceOneType<T> {

    @Override
    public void performAction(T action) {
        //do implementation
        System.out.println("GenericClassImplementingGenericInterface" + action.toString());
    }
}

