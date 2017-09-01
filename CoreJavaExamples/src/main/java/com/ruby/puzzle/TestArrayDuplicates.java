/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ruby.puzzle;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

/**
 *
 * @author Sanjana Somisetty
 */
public class TestArrayDuplicates {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] args) {
    //  int[] numbers = new int[]{1,1,2,2,3,3,3,4,4,4,4,4,5,5,6,7,6,7};
          //	 int[] numbers = new int[]{1,1,2,2,3,3,3,4,4,4,4,4,5,5,6,7,6,7,1,2,8,3,4};
          int[] numbers = Stream.of(args).mapToInt(Integer::parseInt).toArray();
       int temp = 0;
       
       Map mp = new HashMap<String,String>();
        
       for( int i =0; i<numbers.length; i ++){
            for(int j=1; j<((numbers.length)-i) ; j++){
                if(numbers[j-1] > numbers[j]){
                    temp= numbers[j-1];
                    numbers[j-1] = numbers[j];
                    numbers[j] = temp;
                }
                
            }
        }
        System.out.println("SortedArray");
        for(int l = 0; l <numbers.length ; l++){
            System.out.println(numbers[l]);
        } 
        
        int duplicateNum = 0, countOfDuplicates = 0;
        int previous = -1;
        for (int k=0; k < numbers.length; ++k) {
            if (numbers[k] == previous) {
                ++duplicateNum;
                if (duplicateNum == 1) {
                    ++countOfDuplicates;
                    if (countOfDuplicates == 1) {
                        System.out.print(numbers[k]);
                        mp.put(numbers[k],countOfDuplicates);
                    }
                    else {
                        System.out.print(", " + numbers[k]);
                        mp.put(numbers[k],countOfDuplicates);
                    }
                }
            }
            else {
                previous = numbers[k];
                duplicateNum = 0;
            }
            
        }
        System.out.println("");
        Set entrySet = mp.entrySet();
       
        Iterator itr = entrySet.iterator();
        while(itr.hasNext()){
            Map.Entry entry = (Map.Entry)itr.next();
            
            System.out.println(entry.getKey()+ "-"+entry.getValue());
        }

        
      }
    }
    

