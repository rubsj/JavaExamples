/*
 * Copyright (c) 2018 by Casenet, LLC
 *
 * This file is protected by Federal Copyright Law, with all rights
 * reserved. No part of this file may be reproduced, stored in a
 * retrieval system, translated, transcribed, or transmitted, in any
 * form, or by any means manual, electric, electronic, mechanical,
 * electro-magnetic, chemical, optical, or otherwise, without prior
 * explicit written permission from Casenet, LLC.
 */
package com.ruby.bigONotation;

public class SimpleFunction {
    public static void main(String[] args) {
        simpleFunction(10);
        simpleForLoop(100);

    }

    public static void simpleFunction(int n) {
        int a = 9;
        int b = 3;
        int sum = a + b + n;
        int product = a * b * n;
        int quotient = a * n / b;
        System.out.printf("The sum is : %s , THe product is: %s , the quotient is : %s  %n", sum, product, quotient);
        System.out.println("Big O is O(1)");
    }

    public static void simpleForLoop(int n) {
        for (int i = 0; i < n; i++) {
            System.out.printf("the Square of %s operation performed is : %s %n", i, Math.pow(i, 2.0));
        }

        System.out.println("Big O of this function is O(n)");
    }

}

