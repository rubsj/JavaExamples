package com.ruby.generics;

public class ClassImplementingGenericInterface implements GenericInterfaceOneType<String>{

    @Override
    public void performAction(String action) {
        //implementation Here
        System.out.println("In perform action implementation class ClassImplementingGenericInterface");
    }
}

