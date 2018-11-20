/**
 * created by Ruby Jha on 11/19/2018
 */
package com.ruby.algs.elementarySort;

import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdOut;

/**
 * Intersection of two sets.
 * Given two arrays a[] and b[], each containing n distinct 2D points in the plane,
 * design a subquadratic algorithm to count the number of points that are contained both in array
 * a[] and array b[].
 */
public class TwoSetsIntersection {

    /**
     * create a private class Point having two variables x and y representing one point in a 2D plane
     */
    static class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point that) {
            if (this.x < that.x) return -1;
            if (this.x > that.x) return 1;
            if (this.y < that.y) return -1;
            if (this.y > that.y) return 1;
            return 0;
        }
    }

    public int countIntersectionPoints(Point[] a, Point[] b) {
        Shell.sort(a);
        Shell.sort(b);
        int count = 0;
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            int comparison = a[i].compareTo(b[j]);
            if (comparison == 0) {
                i++;
                j++;
                count++;
            } else if (comparison > 0) {
                j++;
            } else {
                i++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        TwoSetsIntersection.Point one =  new Point(1,1);
        TwoSetsIntersection.Point two =  new Point(2,1);
        TwoSetsIntersection.Point three =  new Point(3,1);
        TwoSetsIntersection.Point four =  new Point(4,1);
        TwoSetsIntersection.Point five =  new Point(5,2);
        TwoSetsIntersection.Point six =  new Point(6,3);
        TwoSetsIntersection.Point seven =  new Point(7,4);
        TwoSetsIntersection.Point eight =  new Point(8,5);
        TwoSetsIntersection.Point nine =  new Point(9,7);
        TwoSetsIntersection.Point ten =  new Point(10,9);
        TwoSetsIntersection.Point eleven =  new Point(11,10);

        TwoSetsIntersection.Point[] a = {one , two , three, four, eight, nine, ten , seven, eleven};
        TwoSetsIntersection.Point[] b = {five , six , seven, four, eight, nine, ten};

        TwoSetsIntersection  intersection = new TwoSetsIntersection();
        int count = intersection.countIntersectionPoints(a , b);
        StdOut.print(count);
    }
}



