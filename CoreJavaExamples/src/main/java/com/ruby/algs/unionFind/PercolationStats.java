package com.ruby.algs.unionFind;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

/**
 * created by ruby jha on 10/28/2018
 * <p>
 * To perform a series of computational experiments, create a data type PercolationStats with the following API.
 */
public class PercolationStats {

    final private double[] results;

    final private int numberOftrials;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException("can not have grid size or trail count  less than 1 ");

        int gridSize = n;
        double sizeSquared = n * n;    //squared size needs to be double so that when division perfromed later we get double number and not int
        numberOftrials = trials;
        results = new double[trials];
        Percolation percolation;

        for (int i = 0; i < trials; i++) {
            percolation = new Percolation(gridSize);
            int row;
            int col;
            while (!percolation.percolates()) {
                row = StdRandom.uniform(1, gridSize + 1);
                col = StdRandom.uniform(1, gridSize + 1);
                percolation.open(row, col);
            }
            results[i] = percolation.numberOfOpenSites() / sizeSquared;    //store percolation threshold (number of open sites divided by n*n) in result array to get other mathematical calculations
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(results);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(results);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / Math.sqrt(numberOftrials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / Math.sqrt(numberOftrials);
    }

    // test client (described below)
    public static void main(String[] args) {
       /*  StdOut.print("enter grid size and  number of trails to be performed ");   //keeping it commented since submission needs to read it from args
       int gridSize = StdIn.readInt();
        int trails = StdIn.readInt();*/
        int gridSize = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);
        PercolationStats stats = new PercolationStats(gridSize, trails);
        StdOut.printf("mean                    = %f%n", stats.mean());
        StdOut.printf("stddev                  = %f%n", stats.stddev());
        StdOut.printf("95%% confidence interval = %f, %f%n", stats.confidenceLo(), stats.confidenceHi());
    }

}

