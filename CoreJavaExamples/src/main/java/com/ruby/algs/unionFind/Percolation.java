package com.ruby.algs.unionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * created by Ruby jha on 10/27/2018
 * <p>
 * The problem. In a famous scientific problem, researchers are interested in the following question: if sites are independently set to be open with probability p (and therefore blocked with probability 1 − p), what is the probability that the system percolates? When p equals 0, the system does not percolate; when p equals 1, the system percolates.
 */
public class Percolation {
    private boolean[][] gridStatus; //initialize with blocked sites
    final private int size; //n*n+2 all grid items plus two virtual top and bottom
    final private int gridLength;
    final private WeightedQuickUnionUF percolatesUF;    //for percolates
    final private WeightedQuickUnionUF fullUF;   //for isfull
    private int countOpen;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("grid size must be >= 1");
        gridStatus = new boolean[n][n];
        for (int i = 0; i < n; i++) {    //the row and column indices are integers between 1 and n, where (1, 1) is the upper-left site:
            for (int j = 0; j < n; j++) {  //since array takes 0 as start point sit with index 1 will map to grid 0,0
                gridStatus[i][j] = false;
            }
        }
        countOpen = 0;
        size = n * n + 2;
        gridLength = n;
        percolatesUF = new WeightedQuickUnionUF(size);
        fullUF = new WeightedQuickUnionUF(size - 1);
        for (int k = 1; k <= n; k++) {
            percolatesUF.union(0, k);      //connect all top
            percolatesUF.union(size - 1, size - 1 - k);   //connect all bottom
            fullUF.union(0, k);
        }


    }

    private void validateInput(int i, int j) {
        if (i < 1 || i > gridLength || j < 1 || j > gridLength)
            throw new java.lang.IndexOutOfBoundsException();
    }

    private int indexPosition(int row, int col) {
        return (row - 1) * gridLength + col;
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        validateInput(row, col);
        if (gridStatus[row - 1][col - 1]) return;
        gridStatus[row - 1][col - 1] = true;   //set the status to open true
        countOpen++; //every time a site open increment the count open
        int index = indexPosition(row, col);    //get the index of the site and connect the neighbors if they are open
        if (row > 1 && isOpen(row - 1, col)) {
            //index of one above site
            int aboveSite = indexPosition(row - 1, col);
            percolatesUF.union(aboveSite, index);
            fullUF.union(aboveSite, index);
        }
        if (row < gridLength && isOpen(row + 1, col)) {
            //index of below site
            int belowIndex = indexPosition(row + 1, col);
            percolatesUF.union(belowIndex, index);
            fullUF.union(belowIndex, index);
        }

        if (col > 1 && isOpen(row, col - 1)) {
            //index to the left
            int leftIndex = indexPosition(row, col - 1);
            percolatesUF.union(leftIndex, index);
            fullUF.union(leftIndex, index);
        }

        if (col < gridLength && isOpen(row, col + 1)) {
            //index to the right
            int rightIndex = indexPosition(row, col + 1);
            percolatesUF.union(rightIndex, index);
            fullUF.union(rightIndex, index);
        }


    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        validateInput(row, col);
        return gridStatus[row - 1][col - 1];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        validateInput(row, col);
        return isOpen(row, col) && fullUF.connected(indexPosition(row, col), 0);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return countOpen;
    }

    // does the system percolate?
    public boolean percolates() {
        return percolatesUF.connected(0, size - 1);
    }

    // test client (optional)
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Percolation percolation = new Percolation(n);
        while (!StdIn.isEmpty()) {
            int row = StdIn.readInt();
            int col = StdIn.readInt();
            percolation.open(row, col);
            StdOut.printf("Does system percolates %b%n", percolation.percolates());
            StdOut.printf("Is the site full %b%n", percolation.isFull(row, col));
            StdOut.printf("The current count of number of open sites is %d%n", percolation.numberOfOpenSites());
        }
    }
}

