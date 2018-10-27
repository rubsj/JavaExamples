package com.ruby.algs.unionFind;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Arrays;

/**
 * created by Ruby Jha on 10/22/2018
 * <p>
 * Quick Find eager
 * <p>
 * Data Structure
 * - Integer array id[] of size N
 * - Interpretation : (1) p and q are connected if and only if they have the same id
 * (2)the item i/p/q are represented by the position in the array and value for that position (i/p/q)
 * represents connectedness/component identifier
 * (3) Initially there are N components with each component sitting its own site
 * <p>
 * id[0] =0
 * id[1] = 1
 * id[2] = 1
 * id[3] = 8
 * id[4] = 8
 * id[5] = 0
 * id[6] = 0
 * id[7] = 1
 * id[8] = 8
 * id[9] = 8
 * <p>
 * 0, 5,6 are connected
 * 1, 2 and 7 are connected
 * 3 ,4 ,8 and 9 are connected
 *
 *  Refer edu.princeton.cs.algs4.QuickFindUF
 */
public class QuickFind {


    private int[] componentID; //componentID[i]= component identifier of i
    private int count; //number of components

    QuickFind(int n) {
        count = n;
        componentID= new int[n];
        for (int i = 0; i < n; i++) {
            componentID[i] = i;
        }
    }

    public int[] getComponentID() {
        return componentID;
    }

    // validate that p is a valid index
    private void validate(int p) {
        if (p < 0 || p >= componentID.length) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (componentID.length-1));
        }
    }

    /**
     * Returns the component identifier for the component containing site p
     * @param p  the integer representing one site
     * @return the component identifier for the component containing site
     */
    public int find(int p){
        validate(p);
        return componentID[p];
    }

    /**
     *
     * @return Returns the number of components.
     */
    public int totalComponents(){
      return count;
    }

    /**
     * Returns true if the the two sites are in the same component.
     * @param p the integer representing one site
     * @param q the integer representing onother site
     * @return  Returns true if the the two sites are in the same component. false otherwise
     */
    public boolean isConnected(int p , int q){
        validate(p);
        validate(q);
        return componentID[p]==componentID[q];
    }

    public void union(int p , int q){
        validate(p);
        validate(q);
        int pId= componentID[p];
        int qId = componentID[q]; //local variables to reduce array access
        if(pId==qId){
          return;
        }

        for(int i=0; i< componentID.length; i++){
            if(componentID[i]==pId){
                componentID[i]=qId;
            }
        }
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        System.out.printf("entered number for initial array %d%n ", n);
        QuickFind qf = new QuickFind(n);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(qf.isConnected(p,q)){
                StdOut.printf("%d is already connected to %d and their connected id is %d %n" , p, q , qf.find(p) );
            }else{
                qf.union(p, q);
                StdOut.printf("Performed union of %d and %d and new component for them is %n", p, q , qf.find(p) );
            }
            StdOut.print("the value of current connected array is " + Arrays.toString(qf.getComponentID()));
        }

        StdOut.print("final componnet array is " + Arrays.toString(qf.getComponentID()));
        StdOut.printf("final component count is %d%n",qf.totalComponents());
    }


}

