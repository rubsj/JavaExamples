package com.ruby.puzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/***
 * 20
 * [[1 ,8] [2 , 13] [3 10] ]
 * [1, 8] [2 , 10] [3 , 13]
 *
 *
 *
 * 20
 * [[1 ,8] [2 , 13] [3 10] ]
 * [1, 8]
 *
 */
public class Question2 {

    List<List<Integer>> optimalUtilization(int maxTravelDist,
                                           List<List<Integer>> forwardRouteList,
                                           List<List<Integer>> returnRouteList)
    {
        // WRITE YOUR CODE HERE
        HashMap<List<Integer> , Integer> possibleRoutes =  new HashMap<>();
        for (List<Integer> fwdDestination: forwardRouteList) {
            int fwdId = fwdDestination.get(0);
            int fwdDistance = fwdDestination.get(1);
            for (List<Integer> retDestination: returnRouteList){
                int retId = retDestination.get(0);
                int retDistance = retDestination.get(1);
                List<Integer> route = new ArrayList<>();
                route.add(0 ,fwdId);
                route.add(1, retId);
                possibleRoutes.put(route , fwdDistance+retDistance);
            }
        }

        System.out.println("possibleRoutes" + possibleRoutes);
        HashMap<List<Integer> , Integer> OptimalRoutes =  new HashMap<>();
        Integer optVal=0;
        for(List<Integer> routeCombination : possibleRoutes.keySet()){
            Integer currentVal = possibleRoutes.get(routeCombination);
            if( currentVal<=maxTravelDist ){
                if(optVal <currentVal ){
                    OptimalRoutes.clear();

                    OptimalRoutes.put(routeCombination , currentVal);
                    optVal = currentVal;
                }else if(optVal.equals(currentVal) ) {
                    OptimalRoutes.put(routeCombination , currentVal);
                }

            }

            System.out.println("OptimalRoutes" + OptimalRoutes);
        }


        return new ArrayList<>(OptimalRoutes.keySet());
    }


    public static void main(String[] args) {
        Question2 question2 = new Question2();
        int maxTravelDist = 20;
        List<List<Integer>> forwardRouteList = new ArrayList<>();
         //1 ,8] [2 , 13] [3 10]
        List<Integer> fwdRoute1 = new ArrayList<>();
        fwdRoute1.add(0 ,1);
        fwdRoute1.add(1, 8);
        List<Integer> fwdRoute2 = new ArrayList<>();
        fwdRoute2.add(0 ,2);
        fwdRoute2.add(1, 13);
        List<Integer> fwdRoute3 = new ArrayList<>();
        fwdRoute3.add(0 ,3);
        fwdRoute3.add(1, 10);
        forwardRouteList.add(fwdRoute1);
        forwardRouteList.add(fwdRoute2);
        forwardRouteList.add(fwdRoute3);

        //[1, 8] [2 , 10] [3 , 13]
        List<List<Integer>> returnRouteList = new ArrayList<>();
        List<Integer> retRoute1 = new ArrayList<>();
        retRoute1.add(0 ,1);
        retRoute1.add(1, 8);
      /*  List<Integer> retRoute2 = new ArrayList<>();
        retRoute2.add(0 ,2);
        retRoute2.add(1, 10);
        List<Integer> retRoute3 = new ArrayList<>();
        retRoute3.add(0 ,3);
        retRoute3.add(1, 13);*/
        returnRouteList.add(retRoute1);
  /*      returnRouteList.add(retRoute2);
        returnRouteList.add(retRoute3);*/
        List<List<Integer>> result=  question2.optimalUtilization(maxTravelDist, forwardRouteList, returnRouteList);

        System.out.println("result" + result);

    }
}

