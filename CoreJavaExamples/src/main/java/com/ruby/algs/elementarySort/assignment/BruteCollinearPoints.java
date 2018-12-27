package com.ruby.algs.elementarySort.assignment;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;


@SuppressWarnings("Duplicates")
public class BruteCollinearPoints {
    private LineSegment[] lineSegments = new LineSegment[]{};

    // finds all line segments containing 4 points
    public BruteCollinearPoints(Point[] points) {
        if (points == null) throw new IllegalArgumentException("no points array supplied");
        int arraySize = points.length;
        invalidPoint(points);
        Arrays.sort(points);
        for (int p = 0; p < arraySize - 3; p++) {
            for (int q = p + 1; q < arraySize - 2; q++) {
                for (int r = q + 1; r < arraySize - 1; r++) {
                    for (int s = r + 1; s < arraySize; s++) {
                        if ((points[p].slopeTo(points[q]) == points[p].slopeTo(points[r]))
                                && (points[p].slopeTo(points[q]) == points[p].slopeTo(points[s]))) {
                            LineSegment[] newLineSegments = new LineSegment[lineSegments.length + 1];
                            System.arraycopy(lineSegments, 0, newLineSegments, 0, lineSegments.length);
                            LineSegment newSegment = new LineSegment(points[p], points[s]);
                            StdOut.println( "The line segment created for  p: " + points[p].toString() + " q: " +
                                    points[q].toString() + " r: "+ points[r].toString() +
                                    " s:" + points[s].toString()+" IS:" +newSegment.toString());
                            newLineSegments[newLineSegments.length - 1] = newSegment;
                            lineSegments = newLineSegments;
                        }
                    }
                }
            }
        }

    }

    private void invalidPoint(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i] == null) throw new IllegalArgumentException("no points array supplied");
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("duplicates points in array supplied");
                }
            }
        }
    }

    // the number of line segments
    public int numberOfSegments() {
        return this.lineSegments.length;
    }

    // the line segments
    public LineSegment[] segments() {
        return this.lineSegments;
    }
}
