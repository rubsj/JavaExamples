
package com.ruby.puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/***
 * Given an array input [1 ,1,2,2,2,3,4,,5,5,4,5,6,7,5,6,7]
 *
 * Find the numbers that are duplicates and the times that are duplicate
 *
 */
public class DuplicatesInArray {

    private class Duplicate{

        private int duplicateNum;
        private int frequency;
        public int getDuplicateNum() {
            return duplicateNum;
        }

        public void setDuplicateNum(int duplicateNum) {
            this.duplicateNum = duplicateNum;
        }

        public int getFrequency() {
            return frequency;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        @Override
        public String toString() {
            return com.google.common.base.Objects.toStringHelper(this)
                    .add("duplicateNum", duplicateNum)
                    .add("frequency", frequency)
                    .toString();
        }
    }

    public List<DuplicatesInArray.Duplicate> findDuplicates(int[] inputArray){
        List<DuplicatesInArray.Duplicate> duplicates = new ArrayList<>();

          if(inputArray.length !=0){
              Map<Integer, Integer> dataHolder = new HashMap<>();
              for(int  i : inputArray){
                  if(dataHolder.get(i)==null){
                      dataHolder.put(i , 1);
                  }else{
                     int frequency = dataHolder.get(i);
                     dataHolder.put(i , frequency+1);
                  }
              }

             Iterator<Integer> itr =  dataHolder.keySet().iterator();
              while(itr.hasNext()){
                  Integer key =  itr.next();
                  if(dataHolder.get(key) != 1){
                      DuplicatesInArray.Duplicate duplicate = new DuplicatesInArray.Duplicate();
                      duplicate.setDuplicateNum(key);
                      duplicate.setFrequency(dataHolder.get(key));
                      duplicates.add(duplicate);
                  }
              }
          }
          return duplicates;
    }

    public static void main(String[] args) {
        DuplicatesInArray duplicatesInArray = new DuplicatesInArray();
        int[] inputArray =  new int[]{1,1,2,2,2,3,4,4,5,5,5,5,6,7,7,7,7};
        List<DuplicatesInArray.Duplicate>  dups = duplicatesInArray.findDuplicates(inputArray);
        System.out.println(dups.toString());
    }
}

