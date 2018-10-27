package com.ruby.algs.unionFind;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Successor with delete. Given a set of n integers S={0,1,...,n−1} and a sequence of requests of the following
 * form:
 *
 * Remove x from S
 * Find the successor of x: the smallest y in S such that y≥x.
 *
 * design a data type so that all operations (except construction) take logarithmic time or better
 * in the worst case.
 *
 *  Hint:
 * 1. use the modification of the union−find data discussed in the previous question .
 * 2. When a number is removed, union the immediate neighbor if it is also removed. Then the largest successor is equal to the largest number in that component plus 1.
 * 3. don't use weighted union approach as we always want smaller root id to point to larger one
 *
 * Solution  :-
 * The algorithm to solve the problem is to use union-find with path compression only (i.e., do not use weighted quick union).
 *
 *  Treat Root(x) as the successor of x if x is not deleted
 *  Delete(x) is equivalent to  Union(x, x - 1) and Union(x, x + 1) if x-1 and x+1 is also deleted
 *  Successor(x) is equivalent to return Root(x)+1
 *
 * Solution explanation -
 *
 * Initial state	0	1	2	3	4	5	6	7	8	9
 *
 * parent id		0	1	2	3	4	5	6	7	8	9
 * status		    T	T	T	T	T	T	T	T	T	T
 * Successor		0	1	2	3	4	5	6	7	8	9
 *
 * Delete 3
 * parent id		0	1	2	3	4	5	6	7	8	9		no union needed
 * status		    T	T	T	F	T	T	T	T	T	T
 * Successor		0	1	2	4	4	5	6	7	8	9
 *
 * Delete  6
 * parent id		0	1	2	3	4	5	6	7	8	9		no union needed
 * status		    T	T	T	F	T	T	F	T	T	T
 * Successor		0	1	2	4	4	5	7	7	8	9
 *
 * Delete 4
 * parent id		0	1	2	4	4	5	6	7	8	9		union 3 AND 4 because 3 was deleted earlier and was referring to 4
 * status		    T	T	T	F	F	T	F	T	T	T
 * Successor		0	1	2	5	5	5	7	7	8	9
 *
 * Delete 5
 * parent id		0	1	2	6	6	6	6	7	8	9		Union 4 - 5 and union 5 -6 because 3 , 4 also need to point to 7 now
 * status		    T	T	T	F	F	F	F	T	T	T
 * Successor		0	1	2	7	7	7	7	7	8	9
 *
 * Delete 7		    0	1	2	7	7	7	7	7	8	9		union 6-7
 * Status		    T	T	T	F	F	F	F	F	T	T
 * Successor		0	1	2	8	8	8	8	8	8	9
 *
 */
public class SuccessorWithDelete {
    private int[] id; //maintain the root ids
    private boolean data[]; // data[i] == false if removed



    SuccessorWithDelete(int n){
        id = new int[n];
        data = new boolean[n];
        for(int i=0; i<n; i++){
            id[i]=i;
            data[i] = true;
        }
    }

    private void validate(int p){
        if(p<0 | p>= id.length) throw new IllegalArgumentException(p  + " is not in range of 0 - " + id.length);
    };

    public int find(int p){
        validate(p);
        while(p != id[p]){
            p = id[id[p]];    //path compression
        }

        return p;
    }


    public void union(int p , int q){
        validate(p);
        validate(q);
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP==rootQ) return;

        if(rootP>rootQ){      //we want the smaller root to always point to larger root
            id[q]=rootP;
        }else{
            id[p]=rootQ;
        }

    }

    public void remove(int x) {
        if(!data[x]) return; //if it was removed already no need to remove again, the code works even without this check but does u necessary unions that give same result
        data[x] = false;        //once an item is removed mark its status to removed
        if (x > 0 && !data[x-1])
           union(x, x-1);     //if the predecessor was removed earlier union the predecessor with current item so that predecessor's sucessor gets updated
        if (x < id.length - 1 && !data[x+1])
            union(x, x+1); // if the default successor(curr +1) was also removed then current item needs to merge with default succsor so that it gets the root which points to next succesor
    }

    public int successor(int x) {
        if (data[x]) {
            return x;
        } else {
            int res = find(x) + 1;
            if (res >= id.length) {
                StdOut.println("Error, no successor can be found");
                return -1;
            } else {
                return res;
            }
        }
    }

    public static void main(String[] args) {
       int n = StdIn.readInt();
        SuccessorWithDelete successor = new SuccessorWithDelete(n);
        while (!StdIn.isEmpty()){
            int deleteX = StdIn.readInt();
            successor.remove(deleteX);
            for(int i=0 ; i<n ; i++){
                StdOut.printf("Successor for %d is %d  and its root is %d %n" , i , successor.successor(i) , successor.find(i));
            }
            StdOut.println("enter next item to delete"); 
        }
    }

}

