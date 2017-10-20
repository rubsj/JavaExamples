/*
* Copyright (c) 2017 by Casenet, LLC
*
* This file is protected by Federal Copyright Law, with all rights
* reserved. No part of this file may be reproduced, stored in a
* retrieval system, translated, transcribed, or transmitted, in any
* form, or by any means manual, electric, electronic, mechanical,
* electro-magnetic, chemical, optical, or otherwise, without prior
* explicit written permission from Casenet, LLC.
*/
package com.ruby;

public class Questions1 {
    private void execute (String str){
        System.err.println(str);
    }

    private static final int c=3;
    public void doBusinessLogic(){
        for(int i=0; i< c+1 ; i++){
            if(i==3){
                execute("this is awesome str");
            }
            if(i==2){
                execute("this is good str");
            }
            if(i==1){
                execute("why here");
            }
        }
    }
    public static void main(String[] args) {
         new Questions1().doBusinessLogic();
    }

}

