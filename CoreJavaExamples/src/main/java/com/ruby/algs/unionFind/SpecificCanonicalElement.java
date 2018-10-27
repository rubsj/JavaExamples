package com.ruby.algs.unionFind;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 *Question 2
 * Union-find with specific canonical element. Add a method find() to the union-find data type so that
 * find(i) returns the largest element in the connected component containing i.
 * The operations, union(), connected(), and find() should all take logarithmic time or better.
 *
 * For example, if one of the connected components is {1,2,6,9}, then the find() method should
 * return 9 for each of the four elements in the connected components.
 *
 * Hint: maintain an extra array to the weighted quick-union data structure that stores for each root \mathtt{i}i the large element in the connected component containing \mathtt{i}i
 * 
 */
public class SpecificCanonicalElement {
    private int[] id; //maintian the root ids
    private int[] max; //maintain the max for a root
    private byte[] rank; //for compressed path and rank by height


    SpecificCanonicalElement(int n){
       id = new int[n];
       rank = new byte[n];
       max= new int[n];
       for(int i=0; i<n; i++){
           id[i]=i;
           rank[i]=0;
           max[i]=i;
       }
    }

    private void validate(int p){
       if(p<0 | p>= id.length) throw new IllegalArgumentException(p  + " is not in range of 0 - " + id.length);
    };

    public int find(int p){
        validate(p);
       while(p != id[p]){
         p = id[id[p]];
       }

       return p;
    }

    public int findMax(int p){
        validate(p);
        return max[find(p)];
    }

    public void union(int p , int q){
        validate(p);
        validate(q);
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP==rootQ) return;

        if(rank[p]>rank[q]){
           id[q]=rootP;
        }else if(rank[p]< rank[q]){
           id[p]=rootQ;
        }else{
           id[q]=rootP;
           rank[rootP]++;
        }

        if(max[rootP]>max[rootQ]){
            max[rootQ]=max[rootP];
        }else{
            max[rootP]=max[rootQ];
        }

    }



    public static void main(String[] args) {
        int n = StdIn.readInt();
        SpecificCanonicalElement element = new SpecificCanonicalElement(n);
        while (!StdIn.isEmpty()){
            int p = StdIn.readInt();
            StdOut.printf("root of p is %d and max on this root is %d %n" , element.find(p) , element.findMax(p));
            int q = StdIn.readInt();
            StdOut.printf("root of q is %d and max on this root is %d %n" , element.find(q) , element.findMax(q));
            element.union(p , q);
            StdOut.printf("after union of p and q root is %d and max on this root is %d %n" , element.find(p) , element.findMax(p));

        }
    }

}

