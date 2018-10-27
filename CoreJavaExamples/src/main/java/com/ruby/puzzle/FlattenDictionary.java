package com.ruby.puzzle;

import java.util.HashMap;


/**
 * created by Ruby Jha on 10/12/2018
 * Problem statement
 * assume that values are either an integer, a string or another dictionary.
 *
 * Given a dictionary dict, write a function flattenDictionary that returns a flattened version of it
 * If a certain key is empty, it should be excluded from the output (see e in the example below).
 * 
 *
 * input:  dict = {
 *             "Key1" : "1",
 *             "Key2" : {
 *                 "a" : "2",
 *                 "b" : "3",
 *                 "c" : {
 *                     "d" : "3",
 *                     "e" : {
 *                         "" : "1"
 *                     }
 *                 }
 *             }
 *         }
 *
 * output: {
 *             "Key1" : "1",
 *             "Key2.a" : "2",
 *             "Key2.b" : "3",
 *             "Key2.c.d" : "3",
 *             "Key2.c.e" : "1"
 *         }
 *         
 */
public class FlattenDictionary {
    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
         HashMap<String, String> result = new HashMap<>();
        //iterate over hashmap
        iterateOverHashmap(dict , "" ,result);
        return result;

    }


    private static void iterateOverHashmap(HashMap<String, Object> dict , String parentKey , HashMap<String, String> result ) {
        for(String key : dict.keySet()){
            String finalKey;
            if(parentKey.isEmpty()){
                finalKey =  key;
            } else {
                if(key.isEmpty()){
                    finalKey = parentKey  ;
                } else{
                    finalKey = parentKey + "." + key;
                }

            }
              //get value for key if it
            Object val=  dict.get(key);

            if(val instanceof HashMap)  {
                iterateOverHashmap( (HashMap<String, Object> )val , finalKey, result);
            } else{
                result.put(finalKey , String.valueOf(val));
            }

        }


    }

    public static void main(String[] args) {

        HashMap<String, Object> e = new HashMap<>();
        e.put("", "1");
        HashMap<String, Object> c = new HashMap<>();
        c.put("d" , "3");
        c.put("e", e);
        HashMap<String, Object> Key2 = new HashMap<>();
        Key2.put("a", "2");
        Key2.put("b", "3");
        Key2.put("c" , c);
        HashMap<String, Object> dictionay = new HashMap<>();
        dictionay.put("Key1", "1");
        dictionay.put("Key2" , Key2);

        HashMap<String, String> result=   flattenDictionary(dictionay);
         System.out.println(result);

    }
}

