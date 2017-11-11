package com.ruby;

public class Questions1 {
    private void execute (String str){
        System.err.println(str);
    }

    private static final int c=3;

    public void doBusinessLogic(){
/*        for(int i=0; i< c+1 ; i++){
            if(i==3){
                execute("this is awesome str");
            }
            if(i==2){
                execute("this is good str");
            }
            if(i==1){
                execute("why here");
            }
        }*/


        execute("why here");
        execute("this is good str");
        execute("this is awesome str");
    }
    public static void main(String[] args) {

        new Questions1().doBusinessLogic();

    }

}

