
package com.ruby.puzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * created by Ruby Jha on 10/13/2018
 *
 * Problem statement :- A colony of eight houses . represented as cells are arranged in a straight line. Each day every cell competes
 * with its adjacent cell. An integer value of 1 represents an active cell and value of 0 represents an inactive cell.
 * If both the neighbours are either active or inactive the cells becomes inactive the next day. otherwise it becomes active on next day. The two cells on end have single adjacent cell
 * so the other adjacent cell can be assumed to be always inactive. Even after updating the cell state, its previous state is considered for updating the sate of the cells.
 * The cell information of call cells should be updated simultaneously.
 *
 * Write an algotithm to output the state of the cells after the given number of days
 *
 * state- a list of intergers representing current state of cells
 * days and int representing number of days
 *
 * the elements of the list states contains 0s and 1s only.
 *
 *
 *
 * Test cases [1 ,0 , 0 0 0 1 0 0] 1
 * Output 0 1 0 0 1 0 1 0
 *
 * Case2 [ 1 1 1 0 1 1 1 1 ] 2
 *
 * output 0 0 0 0 0 1 1 0
 *
 */
public class HouseColony {
    /**
     *
     * @param states   representing current state of cells
     * @param days    number of days
     * @return  representing  state of cells after number of days
     */
    public List<Integer> cellCompete(int[] states, int days)
    {
        List<Integer> result = new ArrayList<>();
        //since there are two more states creaqte new array representing additional edge values
        int[] statesWithEdges = new int[10];
        statesWithEdges[0]=0;
        statesWithEdges[9]=0;
        //map to keep state of house at any time. House number begin with 1
        Map<Integer , Integer>  houseState = new HashMap<>();
            for (int i=0; i<states.length;i++){
                houseState.put(i+1, states[i]);
                statesWithEdges[i+1]=states[i];
            }

        for(int i=0 ; i<days; i++){
            for(int n : houseState.keySet()){
              if(statesWithEdges[n-1]+  statesWithEdges[n+1]==1){
                  houseState.put(n, 1);
              }else{
                  houseState.put(n, 0);
              }
            }
            for(int k=1; k<=8; k++){
                statesWithEdges[k]= houseState.get(k);
            }

            System.out.println("statesWithEdges" + Arrays.toString(statesWithEdges) );

        }

        //after all house states updated get all the values  and put into arraylist
        for(int n : houseState.keySet()){
            result.add(n-1 , houseState.get(n));
        }

        return result;

    }

    public static void main(String[] args) {
        int[] states = {1 ,1,1,0,1,1,1,1};
        int days = 2;

        HouseColony houseColony = new HouseColony();
        List<Integer> result=  houseColony.cellCompete(states , days);
        System.out.println(result);

    }
}

