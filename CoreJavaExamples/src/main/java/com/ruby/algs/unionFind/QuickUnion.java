/**
 *  created by Ruby Jha on 10/22/2018
 *
 *  Quick Union lazy approach
 *  Data Structure
 *  - Integer array id[] of size N
 *  - Interpretation
 *    - id[i] is parent of i
 *    - root of i is id[id[id[...id[i]...]]]
 *  - find - check if p and q have same root
 *  - union - to merge components containing p and q set the id of p's root to the id of q's root
 *
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
 * Refer edu.princeton.cs.algs4.QuickUnionUF
 *
 */
package com.ruby.algs.unionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class QuickUnion {


    private int[] componentParentID; //componentParentID[i]= parent identifier of i
    private int count;  //number of components

    QuickUnion(int n){
        count = n;
        componentParentID= new int[n];
        for (int i = 0; i < n; i++) {
            componentParentID[i] = i;
        }
    }

    public int[] getComponentParentID() {
        return componentParentID;
    }

    // validate that p is a valid index
    private void validate(int p) {
        if (p < 0 || p >= componentParentID.length) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (componentParentID.length-1));
        }
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
        return find(p)==find(q);
    }

    /**
     * Returns the component identifier for the component containing site
     * @param p the integer representing one object
     * @return
     */
    public int find(int p){
        validate(p);
        while(p !=componentParentID[p]){
            p= componentParentID[p];
        }

        return p;
    }

    /**
     * Merges the component containing site p with the
     * the component containing site q.
     *
     * @param  p the integer representing one site
     * @param  q the integer representing the other site
     */
    public void union(int p , int q){
        validate(p);
        validate(q);
        int rootP=find(p);
        int rootQ= find(q);
        if(rootP== rootQ) return;
        componentParentID[rootP]=rootQ;
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        System.out.printf("entered number for initial array %d%n ", n);
        QuickUnion qf = new QuickUnion(n);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(qf.isConnected(p,q)){
                StdOut.printf("%d is already connected to %d and their connected id is %d %n" , p, q , qf.find(p) );
            }else{
                qf.union(p, q);
                StdOut.printf("Performed union of %d and %d and new component for them is %n", p, q , qf.find(p) );
            }
            StdOut.print("the value of current connected array is " + Arrays.toString(qf.getComponentParentID()));
        }

        StdOut.print("final componnet array is " + Arrays.toString(qf.getComponentParentID()));
        StdOut.printf("final component count is %d%n",qf.totalComponents());
    }

}

