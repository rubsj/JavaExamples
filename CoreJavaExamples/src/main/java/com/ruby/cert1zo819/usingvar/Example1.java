package com.ruby.cert1zo819.usingvar;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Example1 {
    // var is NOT permitted for fields
    // var y =100;
    public static void main(String[] args) throws IOException {
        // YES immediately initialized local variable
        var x = 3_000_000_000L;
        var z = new int[]{1 , 2, 3};
        // YES allowed in for var initialization
        for(var j =0 ; j<5; j++){
            System.out.println(j);
        }
        // YES multiple declaration sperated by ; are allowed
        try(var in = new FileReader(""); var out = new FileWriter("")){

        }
        // YES var is a pseudo type hence you can declare a variable name var.
        // var is not a keyword and hence can be used to name a variable
        var var = "var";
        // NOT allowed var must represent full type
        //var[] z = new int[]{1 , 2, 3};

        // NOT allowed to declare without initialization
        // var y ;
        // y=20;

        // NOT allowed only one variable can be defined
        // var a=10, s =12;

        // catch with var NOT allowed
      /*  try{
            // do stuff
        }catch (var x){}*/
    }
    // var is NOT permitted for method parameter
    // fails because not explicit initialization and no context to determine init val
    // void doStuff(var x){}

    int d= 4;
    String s= "Hello";
    Object v = Math.random() > 0.5 ? d : s;
    // NOT allowed
    //var t = (Math.random() > 0.5) ? d : s;
}

//NOT allowed where var is being used as type since var is a pseudo type
//class var {}