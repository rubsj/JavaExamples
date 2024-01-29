package com.ruby.puzzle;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class CreateMatchingBrackets {
    public static String solution(String angles){
        String[] input = angles.split("");
        Deque<String> result = new ArrayDeque<>();
        boolean waitMatch = false;
        for(int i=input.length-1; i > 0 ; i--){
            String val = input[i];
            if(input[i].equals("<")){
                result.addFirst(val);
                if(!waitMatch){
                    result.addLast(">");
                }
                waitMatch = false;
            }else{
                if(waitMatch){
                    result.addFirst("<");
                }
                result.addFirst(val);
                waitMatch = true;
            }
        }

        String lastItem = input[0];
        if(lastItem.equals(">") && waitMatch){
            result.addFirst("<");
            result.addFirst(lastItem);
            result.addFirst("<");
        }else if(lastItem.equals(">") && !waitMatch){
            result.addFirst(lastItem);
            result.addFirst("<");
        }else if(lastItem.equals("<") && waitMatch){
            result.addFirst(lastItem);
        }else if(lastItem.equals("<") && !waitMatch){
            result.addFirst(lastItem);
            result.addLast(">");
        }

        String resultStr = String.join("", result);
        return resultStr;
    }
    public static void main(String[] args) {
        String result = solution("><<><");
        System.out.println(result);

        result = solution(">>>");
        System.out.println(result);

        result = solution("<<<");
        System.out.println(result);

        result = solution(">>");
        System.out.println(result);

        result = solution("<<");
        System.out.println(result);

        result = solution("<<>>");
        System.out.println(result);

        result = solution("<>");
        System.out.println(result);
    }
}
