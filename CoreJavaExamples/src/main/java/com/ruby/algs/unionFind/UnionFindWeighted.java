package com.ruby.algs.unionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * created by Ruby Jha 10/23/2018
 *
 *  This implementation uses weighted quick union by size (without path compression).
 *  Weighted Quick Union - Weighting concepts
 *   - Modify quick-union to avoid tall trees
 *   - keep track of size of each tree (number of objects)
 *   - balance by linking root of smaller tree to root of larger tree
 *
 *  Initializing a data structure with <em>n</em> sites takes linear time.
 *  Afterwards, the <em>union</em>, <em>find</em>, and <em>connected</em>
 *  operations  take logarithmic time (in the worst case) and the
 *  <em>count</em> operation takes constant time.
 *  For alternate implementations of the same API, see  {@link QuickUnion} {@link QuickFind}
 */
public class UnionFindWeighted {
    private int[] componentParentID; //componentParentID[i]= parent identifier of i
    private int count;  //number of components
    private int[] size; //size of subtree rooted at i size[i] = number of sites rooted in subtree i .

    UnionFindWeighted(int n) {
        count = n;
        componentParentID = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            componentParentID[i] = i;
            size[i] = 1;
        }
    }

    public int[] getComponentParentID() {
        return componentParentID;
    }

    public int[] getSize() {
        return size;
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

    public boolean isConnected(int p , int q){
        validate(p);
        validate(q);
        return find(p)==find(q);
    }

    public int find(int p){
        validate(p);
        while(p !=componentParentID[p]){
            p = componentParentID[p];
        }

        return p;
    }

    public void union(int p , int q){
        validate(p);
        validate(q);
        int rootP = find(p);
        int rootQ= find(q);

        if(rootP==rootQ) return;

        int sizeP = size[rootP];
        int sizeQ= size[rootQ];
        // make smaller root point to larger one
        if(sizeP<sizeQ){
            componentParentID[rootP]=rootQ;
            size[rootQ] = sizeP+sizeQ;
        }else{
            componentParentID[rootQ] =rootP;
            size[rootP]=sizeP+sizeQ;
        }
       count--;

    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        System.out.printf("entered number for initial array %d%n ", n);
        UnionFindWeighted qf = new UnionFindWeighted(n);
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
            StdOut.print("the value of current size array is " + Arrays.toString(qf.getSize()));
        }

        StdOut.print("final componnet array is " + Arrays.toString(qf.getComponentParentID()));
        StdOut.print("the value of final size array is " + Arrays.toString(qf.getSize()));
        StdOut.printf("final component count is %d%n",qf.totalComponents());
    }
}

