package com.ruby.algs.unionFind;

import edu.princeton.cs.introcs.StdIn;

/*

Social network connectivity.
Given a social network containing n members and a log file containing m timestamps at which times pairs of
members formed friendships, design an algorithm to determine the earliest time at which all members are connected
 (i.e., every member is a friend of a friend of a friend ... of a friend).
 Assume that the log file is sorted by timestamp and that friendship is an equivalence relation.
 The running time of your algorithm should be mlogn or better and use extra space proportional to n.

 test data
 Not all got connected
 10
 1 2 10/11/2018
2 3 10/12/2018
6 7 10/13/2018
8 9 10/14/2018
5 4 10/15/2018
3 4 10/16/2018
3 6 10/17/2018
5 9 10/18/2018
6 8 10/19/2018
1 3 10/20/2018
1 2 10/21/2018

All got connect at  10/19/2018
1 2 10/11/2018
1 3 10/12/2018
1 4 10/13/2018
1 5 10/14/2018
1 6 10/15/2018
1 7 10/16/2018
1 8 10/17/2018
1 9 10/18/2018
1 0 10/19/2018
1 2 10/20/2018
1 2 10/21/2018


 */
public class SocialNetworkConnected {
    private  int[] id;
    private  int count;
    private byte[] rank;

    SocialNetworkConnected(int n){
        count =n;
        id = new int[n];
        rank = new byte[n];
        for(int i=0 ; i<n; i++){
            id[i]=i;
            rank[i]=0;
        }
    }

    public int getCount() {
        return count;
    }

    private void validate(int p){
        if(p<0 || p >= id.length)
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + id.length);
    }

    public int find(int p){
        validate(p);
        while (p != id[p]){
            p = id[id[p]];
        }

        return p;
    }
    public void union(int p , int q){
        int rootP = find(p);
        int rootQ = find(q);
        if(rootP==rootQ) return;

        if(rank[rootP] < rank[rootQ]){
           id[rootP]=rootQ;
        }else if(rank[rootP] > rank[rootQ]){
           id[rootQ]=rootP;
        }else{
            id[rootP]=rootQ;
            rank[rootQ]++;
        }
      count--;
    }

    public static void main(String[] args) {

        int n = StdIn.readInt();
        SocialNetworkConnected connected = new SocialNetworkConnected(n);
        boolean allConnected=false;
        while(!StdIn.isEmpty() && !allConnected){
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            String timestamp = StdIn.readString();
            connected.union(p ,q);
            if(connected.getCount()==1){
                System.out.printf("All friends connected at %s%n" , timestamp );
                allConnected =true;
            }
        }

        if(!allConnected){
            System.out.println("all friends were not connected in the given input");
        }

    }

}

