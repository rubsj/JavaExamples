package com.ruby.algs.elementarySort.assignment;


import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

@SuppressWarnings("Duplicates")
public class FastCollinearPoints {
    private LineSegment[] lineSegments = new LineSegment[]{};

    // finds all line segments containing 4 or more points
    public FastCollinearPoints(Point[] points){
        if (points == null) throw new IllegalArgumentException("no points array supplied");
        int arraySize = points.length;
        invalidPoint(points);
        Point[] sortedPoints = new Point[arraySize];
        System.arraycopy(points ,0 , sortedPoints , 0 , arraySize);
        for(int i=0; i<arraySize; i++){
            Point referencePoint = points[i];
            Arrays.sort(sortedPoints); //sort once on natural order so that items always get consistent start point for slope sort
            Arrays.sort(sortedPoints, referencePoint.slopeOrder());

            int min=0;
            while(min< arraySize && referencePoint.slopeTo(sortedPoints[min])==Double.NEGATIVE_INFINITY){
                min++; //at this point min value should always be 1
            }
            int max = min;
            while(min < arraySize){
               while(max < arraySize && (referencePoint.slopeTo(sortedPoints[max])== referencePoint.slopeTo(sortedPoints[min]))){
                  max++; //increase max till the consecutive points are collinear
               }
               if(max-min>=3){
                   Point minPoint = sortedPoints[min].compareTo(referencePoint)<0 ? sortedPoints[min] : referencePoint; //if the min is befoew reference point that should be taken
                   Point maxPoint = sortedPoints[max-1].compareTo(referencePoint) >0 ? sortedPoints[max-1]: referencePoint;
                   if(minPoint==referencePoint){ //only if the min point is reference point that its a unique segment...
                       LineSegment[] newLineSegments = new LineSegment[lineSegments.length + 1]; //since I don't want to use arraylist doing this hoop for adding item in array
                       System.arraycopy(lineSegments, 0, newLineSegments, 0, lineSegments.length);
                       LineSegment newSegment = new LineSegment(minPoint, maxPoint);
                       newLineSegments[newLineSegments.length - 1] = newSegment;
                       lineSegments = newLineSegments;
                       StdOut.println( "The line segment created for  p: " + minPoint.toString() + " q: " +
                              maxPoint.toString() + " IS:" +newSegment.toString());
                   }
               }
               min=max; //we should jump till the point max had reached
            }
        }

    }



    private void invalidPoint(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            if (points[i] == null) throw new IllegalArgumentException("null point in array supplied");
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("duplicate point in array supplied");
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
