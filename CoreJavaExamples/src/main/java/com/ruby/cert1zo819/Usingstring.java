package com.ruby.cert1zo819;

import java.time.LocalDate;

public class Usingstring {
    public static void main(String[] args) {
        String s1 = "Hello";
        System.out.println("s1 == X.h " + (s1 == X.h));

        String s2 = new StringBuilder("Hello").toString();
        String s3 = s2.intern();
        System.out.println("s2 == s3 " + (s2 == s3));
        System.out.println("s1 == s2 " + (s1 == s2));
        System.out.println("s1 == s3 " + (s1 == s3));
    }

    // void doStuff(int i, int j){}
     void doStuff(int i, long j){}
    // void doStuff(long i, int j){}
    // void doStuff(long i, long j){}
     void doStuff(int ... i){}
     void doStuff(Integer i, Long j){}
   // void doStuff(Long i, Long j){}
    // void doStuff(Long i, Integer j){}

    static void tryDoStuff(){
        new Usingstring().doStuff(1, 2);
    }
}

class X{
    static String h = "Hello";
}