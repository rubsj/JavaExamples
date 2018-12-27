package com.ruby.algs.elementarySort.assignment;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("Duplicates")
public class SampleClient {

    //program arguments C:\Projects\JavaExamples\CoreJavaExamples\src\main\resources\com\ruby\input6.txt
    public static void main(String[] args) {
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++){
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32500);
        StdDraw.setYscale(0, 32500);
        StdDraw.setPenColor(StdDraw.MAGENTA);
        for (Point p : points) {
            p.draw();
            StdOut.println(p.toString());
        }
        StdDraw.show();
        // print and draw the line segments
        StdDraw.setPenColor(StdDraw.BLUE);
   //     BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
