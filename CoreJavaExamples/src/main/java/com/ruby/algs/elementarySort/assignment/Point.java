package com.ruby.algs.elementarySort.assignment;

/******************************************************************************
 *  Compilation:  javac Point.java
 *  Execution:    java Point
 *  Dependencies: none
 *
 *  An immutable data type for points in the plane.
 *  For use on Coursera, Algorithms Part I programming assignment.
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final int x;     // x-coordinate of this point
    private final int y;     // y-coordinate of this point

    /**
     * Initializes a new point.
     *
     * @param  x the <em>x</em>-coordinate of the point
     * @param  y the <em>y</em>-coordinate of the point
     */
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    /**
     * Returns the slope between this point and the specified point.
     * Formally, if the two points are (x0, y0) and (x1, y1), then the slope
     * is (y1 - y0) / (x1 - x0). For completeness, the slope is defined to be
     * +0.0 if the line segment connecting the two points is horizontal;
     * Double.POSITIVE_INFINITY if the line segment is vertical;
     * and Double.NEGATIVE_INFINITY if (x0, y0) and (x1, y1) are equal.
     *
     * @param  that the other point
     * @return the slope between this point and the specified point
     */
    public double slopeTo(Point that) {
        /* YOUR CODE HERE */
        int diffY = that.y - this.y ;
        int diffX = that.x - this.x ;
        if(diffY ==0 && diffX>0){
            return 0.0;
        }else if(diffX==0 && diffY!=0){
           return Double.POSITIVE_INFINITY;
        }else if(diffX==0 && diffY==0){
            return Double.NEGATIVE_INFINITY;
        }else{
            return diffY/(double)diffX;
        }
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param  that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     *         point (x0 = x1 and y0 = y1);
     *         a negative integer if this point is less than the argument
     *         point; and a positive integer if this point is greater than the
     *         argument point
     */
    public int compareTo(Point that) {
        /* YOUR CODE HERE */
        int diffY = this.y - that.y;
        int diffX = this.x - that.x;
        if (diffY != 0) {
            return diffY;
        } else {
            return diffX;
        }
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
        /* YOUR CODE HERE */
        return new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                double slopDiff = slopeTo(o1) - slopeTo(o2);
                if(slopDiff >0){
                    return 1;
                }else if(slopDiff < 0){
                    return -1;
                }else{
                    return 0;
                }
            }
        };

    }


    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    /**
     * Unit tests the Point data type.
     */
    public static void main(String[] args) {
        /* YOUR CODE HERE */
/*        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(0.5, 0.5);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        StdDraw.line(0.2, 0.2, 0.8, 0.2); */
        Point point1, point2;

        /* Vertical line segments should be +Infinity */
        point1 = new Point(5, 10);
        point2 = new Point(5, 7);
        assert point1.slopeTo(point2) == Double.POSITIVE_INFINITY : "Vertical line segments should be +Infinity";
        StdOut.printf("point1.slopeTo(point2) : %f %n" , point1.slopeTo(point2));

        /* Horizontal line segments should be +0.0 */
        point1 = new Point(12, 3);
        point2 = new Point(3, 3);
        assert point1.slopeTo(point2) == +0.0 : "Horizontal line segments should be +0.0";
        StdOut.printf("point1.slopeTo(point2) : %f %n" , point1.slopeTo(point2));

        /* The slope of a point with himself should be -Infinity */
        Point p = new Point(1, 5);
        assert p.slopeTo(p) == Double.NEGATIVE_INFINITY  : "The slpe of a point with himself should be -Infinity";
        StdOut.printf("p.slopeTo(p : %f %n" , p.slopeTo(p));

        /* regular slope should be a double number */
        point1 = new Point(3, 16);
        point2 = new Point(8, 7);
        assert point1.slopeTo(point2) != -1.000000;
        StdOut.printf("point1.slopeTo(point2) : %f %n" , point1.slopeTo(point2));



    }
}