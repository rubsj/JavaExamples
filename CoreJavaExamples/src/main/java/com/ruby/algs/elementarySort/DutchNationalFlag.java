/**
 * Created by Ruby Jha on 11/19/2018
 *
 */
package com.ruby.algs.elementarySort;

import java.util.Arrays;

import static com.ruby.algs.elementarySort.DutchNationalFlag.Pebble.Blue;
import static com.ruby.algs.elementarySort.DutchNationalFlag.Pebble.Red;
import static com.ruby.algs.elementarySort.DutchNationalFlag.Pebble.White;

/**
 *  Dutch national flag.
 *  Given an array of n buckets, each containing a red, white, or blue pebble, sort them by color.
 *  The allowed operations are:
 *
 *      swap(i,j): swap the pebble in bucket i with the pebble in bucket j.
 *      color(i): determine the color of the pebble in bucket i.
 *
 * The performance requirements are as follows:
 *   At most n calls to color().
 *   At most n calls to swap().
 *   Constant extra space.
 *
 * The solution to this algorithm will require 3 pointers to iterate throughout the array, swapping the necessary elements.
 * (1) Create a low pointer at the beginning of the array and a high pointer at the end of the array.
 * (2) Create a mid pointer that starts at the beginning of the array and iterates through each element.
 * (3) If the element at arr[mid] is a 2(Blue), then swap arr[mid] and arr[high] and decrease the high pointer by 1.
 * (4) If the element at arr[mid] is a 0(Red), then swap arr[mid] and arr[low] and increase the low and mid pointers by 1.
 * (5) If the element at arr[mid] is a 1(White), don't swap anything and just increase the mid pointer by 1.
 *
 */
public class DutchNationalFlag {
   enum Pebble{
       Red, White , Blue
   }

   private Pebble[] pebbles;

   public DutchNationalFlag(Pebble[] pebbles){
       this.pebbles=pebbles;
   }

   private void swap ( Pebble[] pebbles , int i, int j){
       Pebble temp =pebbles[i];
       pebbles[i]=pebbles[j];
       pebbles[j]=temp;
   }

    private Pebble color(int i) {
        return pebbles[i];
    }

    private void createDutchNationalFlag(){
        int low =0;
        int mid=0;
        int high =  pebbles.length-1;
        while(mid<=high){
            Pebble color = color(mid);
            if(color==Red){
               swap(pebbles , low++ , mid++);
            }else if(color==Blue){
                swap(pebbles , mid , high--);
            }else if(color == White){
                mid++;
            }
        }
    }

    public static void main(String[] args) {
        Pebble[] pebbles = {Blue , Red , Red, White , Blue ,Red ,Blue ,White};
        System.out.println("pebbles before sorting" + Arrays.deepToString(pebbles));
        DutchNationalFlag dutchNationalFlag = new DutchNationalFlag(pebbles);
        dutchNationalFlag.createDutchNationalFlag();
        System.out.println(Arrays.deepToString(pebbles));
    }
}
