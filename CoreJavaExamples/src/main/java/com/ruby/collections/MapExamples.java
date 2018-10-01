package com.ruby.collections;

import java.util.HashMap;
import java.util.Map;

/***
 * In this class I will explore various java features added to Map interface
 * The newly added  funtions and their behaviours are as below
 * <UL>
 *     <LI><b>compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)</b>
 *        Attempts to compute a mapping for the specified key and
 *        its current mapped value (or null if there is no current mapping).
 *
 *        If the function returns null, the mapping is removed (or remains absent if initially absent).
 *        If the function itself throws an (unchecked) exception, the exception is rethrown, and the current mapping is left unchanged.
 *     </LI>
 *     <LI>
 *         <b>computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)</b>
 *         If the specified key is not already associated with a value (or is mapped to null),
 *         attempts to compute its value using the given mapping function and enters it into this map unless null.
 *         If the function returns null no mapping is recorded. If the function itself throws an (unchecked) exception,
 *         the exception is rethrown, and no mapping is recorded.
 *     </LI>
 *     <LI>
 *         <b>computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)</b>
 *         If the value for the specified key is present and non-null,
 *         attempts to compute a new mapping given the key and its current mapped value.
 *
 *         If the function returns null, the mapping is removed.
 *         If the function itself throws an (unchecked) exception, the exception is rethrown, and the current mapping is left unchanged.
 *     </LI>
 *     <LI>
 *         <b>merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)</b>
 *         If the specified key is not already associated with a value or is associated with null,
 *         associates it with the given non-null value.
 *         Otherwise, replaces the associated value with the results of the given remapping function, or removes if the result is null.
 *         If the function returns null the mapping is removed. If the function itself throws an (unchecked) exception, the exception is rethrown,
 *         and the current mapping is left unchanged
 *
 *     </LI>
 *     <LI>
 *         <b></b>
 *     </LI>
 * </UL>
 *
 * Q1 : What is the difference between Merge and computeIfAbsent?
 * A1 : Merge and computeIfAbsent both work when For the key key either null value is associated or its not already associated
 * However Merge takes BiFunction where as computeIfAbsent takes only Function
 *
 * Q2 : What is the difference between Compute and Merge
 * a default value is passed to merge function so the passed bifunction does not have to compute default every time the existing value is null
 *
 */
public class MapExamples {


    /***
     * This method is to explore  computeIfAbsent(K key, Function<? super K, ? extends V> mappingFunction) of Hashmap
     *
     * The compute if absent function puts value to the map if for the given key there is no value in map or in other words
     * the key is also not present in map then compute if absent will put the key in map the value is calculated
     * by this function and put into the map for the key
     */
    public Map<String, Integer> tryCompute() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("X",null);
        map.put("Y",null);
        map.put("W",20);

        System.out.println("before calling comput : " + map.toString());
        //Say we have map with these two data and for any other coming key
        // we want to set the value to some random number
        map.compute("C", (k, v) -> v == null ? 1 : v + 1);
        map.compute("D", (k, v) -> v == null ? 1 : v + 1);
        map.compute("A", (k, v) -> v == null ? 1 : v + 1);
        map.compute("X",(k, v) -> v == null ? 1 :v + 1);
        map.compute("Y",(k, v) -> null);
        map.compute("Z",(k, v) -> null);
        map.compute("W",(k, v) -> null);
        return map;
    }

    public Map<String, Integer> tryComputeifAbsent() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("X",null);
        map.put("Y",null);

        System.out.println("before calling tryComputeifAbsent : " + map.toString());

        map.computeIfAbsent("C", x -> 3);
        map.computeIfAbsent("D", x -> 4);
        map.computeIfAbsent("A", x -> 11);
        map.computeIfAbsent("X", x -> null);
        map.computeIfAbsent("Y", x -> 5);
        return map;
    }

    public Map<String, Integer> tryComputeifPresent() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("W",20);
        map.put("X",null);


        System.out.println("before calling tryComputeifPresent : " + map.toString());

        map.computeIfPresent("C", (k, v) -> v + 1);
        map.computeIfPresent("D", (k, v) -> v + 1);
        map.computeIfPresent("A", (k, v) -> v + 1);
        map.computeIfPresent("X", (k, v) -> v + 1);
        map.computeIfPresent("W", (k, v) -> null);
        return map;
    }

    public Map<String, Integer> tryMerge() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("X",null);
        map.put("Y",null);
        map.put("W",20);


        System.out.println("before calling tryMerge : " + map.toString());

        map.merge("C",10,(k, v) -> v + 1);
        map.merge("D",10,(k, v) -> v + 1);
        map.merge("A",10,(k, v) -> v + 1);
        map.merge("X",10,(k, v) -> v + 1);
        map.merge("Y",10,(k, v) -> null);
        map.merge("Z",1,(k, v) -> null);
        map.merge("W",1,(k, v) -> null);
        return map;
    }


    public static void main(String[] args) {
        MapExamples mapExamples = new MapExamples();
        Map<String, Integer> result = null;
        System.out.println("Test for Compute function");
        result        =  mapExamples.tryCompute() ;
        System.out.println(result.toString());
    //    result.forEach((k ,v)  -> System.out.printf("For The Key %s the value is %d%n" , k , v));

        System.out.println("Test for ComputeifAbsent function");
        result = mapExamples.tryComputeifAbsent();
        System.out.println(result.toString());
        //result.forEach((k, v) -> System.out.printf("For The Key %s the value is %d%n", k, v));

        System.out.println("Test for ComputeifPresent function");
        result =  mapExamples.tryComputeifPresent() ;
        System.out.println(result.toString());
        //result.forEach((k ,v)  -> System.out.printf("For The Key %s the value is %d%n" , k , v));


        System.out.println("Test for Merge function");
        result =  mapExamples.tryMerge() ;
        System.out.println(result.toString());
        //result.forEach((k ,v)  -> System.out.printf("For The Key %s the value is %d%n" , k , v));
    }


}


