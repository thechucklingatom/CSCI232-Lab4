/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232.lab4;

import java.util.ArrayList;

/**
 *
 * @author thechucklingatom
 */
public class ClosestPair {

    ArrayList<Point> listX, listY;

    public ClosestPair(ArrayList<Point> xList, ArrayList<Point> yList) {
        listX = xList;
        listY = yList;
    }

    public Point[] bruteForce() {
        double minDis;
        Point[] closestPair = new Point[2];
        if (listX.size() < 2) {
            closestPair[0] = null;
            closestPair[1] = null;
            return closestPair;
        } else {
            minDis = listX.get(0).DistanceFrom(listX.get(1));
            closestPair[0] = listX.get(0);
            closestPair[1] = listX.get(1);
            //just check every point
            for (int i = 0; i < listX.size() - 1; i++) {
                for (int j = i + 1; j < listX.size(); j++) {
                    if (listX.get(i).DistanceFrom(listX.get(j)) < minDis) {
                        minDis = listX.get(i).DistanceFrom(listX.get(j));
                        closestPair[0] = listX.get(i);
                        closestPair[1] = listX.get(j);
                    }
                }
            }
        }

        return closestPair;
    }
    //same as above just uses arrayLists
    public Pair bruteForce(ArrayList<Point> xList) {
        double minDis;
        Pair closestPair;
        if (xList.size() < 2) {
            closestPair = new Pair(xList.get(0), xList.get(0));
            return closestPair;
        } else {
            minDis = xList.get(0).DistanceFrom(xList.get(1));
            closestPair = new Pair(xList.get(0), xList.get(1));
            for (int i = 0; i < xList.size() - 1; i++) {
                for (int j = i + 1; j < xList.size(); j++) {
                    if (xList.get(i).DistanceFrom(xList.get(j)) < minDis) {
                        minDis = xList.get(i).DistanceFrom(xList.get(j));
                        closestPair = new Pair(xList.get(i), xList.get(j));
                    }
                }
            }
        }

        return closestPair;
    }

    public Pair closestAlgorithm(ArrayList<Point> xList, ArrayList<Point> yList) {
        Pair closestPair, pairLeft, pairRight;
        ArrayList<Point> xLeft = new ArrayList<Point>(), xRight = new ArrayList<Point>(), yLeft = new ArrayList<Point>(), yRight = new ArrayList<Point>();
        //use brute force when it is small
        if (xList.size() <= 3) {
            System.out.println("Solving problem: Point[" + xList.get(0).getXPos() + "]...Point[" + xList.get(xList.size()-1).getXPos() + "]");
            closestPair = bruteForce(xList);
            if(closestPair.getDistance() == Double.MAX_VALUE){
                System.out.printf("\tFound result: INF\n");
            }else{
                System.out.printf("\tFound result: P1: (%.4f, %.4f), P2: (%.4f, %.4f), Distance: %.4f\n", 
                        closestPair.getPoint1().getX(), closestPair.getPoint1().getY(), 
                        closestPair.getPoint2().getX(), closestPair.getPoint2().getY(), closestPair.getDistance());
            }
        //else use the full algorithm
        } else {
            closestPair = null;
            int middle = xList.size() / 2;
            System.out.println("Solving problem: Point[" + xList.get(0).getXPos() + "]...Point[" + xList.get(xList.size()-1).getXPos() + "]");
            System.out.printf("\tDividing at Point[%d]\n", xList.get(middle).getXPos());
            
            //create the two new lists
            Point midX = xList.get(middle);
            for (int i = 0; i < xList.size(); i++) {
                if (xList.get(i).getX() <= midX.getX()) {
                    xLeft.add(xList.get(i));
                }else{
                    xRight.add(xList.get(i));
                }
            }
            
            for (int i = 0; i < xList.size(); i++) {
                if (yList.get(i).getX() <= midX.getX()) {
                    yLeft.add(yList.get(i));
                }else{
                    yRight.add(yList.get(i));
                }
            }
            
            //the two pairs from recursion
            pairLeft = closestAlgorithm(xLeft, yLeft);
            pairRight = closestAlgorithm(xRight, yRight);
            
            //pick the smallest
            if(pairLeft.getDistance() < pairRight.getDistance()){
                closestPair = pairLeft;
            }else{
                closestPair = pairRight;
            }
            
            //check in the small strip
            ArrayList<Point> yStrip = new ArrayList<Point>();
            for (Point yListP : yList) {
                if (Math.abs(midX.getX() - yListP.getX()) < closestPair.getDistance()) {
                    yStrip.add(yListP);
                }
            }
            
            System.out.printf("Combining Problems: Point[%d]...Point[%d] and Point[%d]...Point[%d]\n",
                    xList.get(0).getXPos(), xList.get(middle).getXPos(),
                    xList.get(middle + 1).getXPos(), xList.get(xList.size() - 1).getXPos());
            
            //check the middle strip
            for(int i = 0; i < yStrip.size() - 1; i++){
                int k = i +1;
                while(k < yStrip.size() && (yStrip.get(k).getY() - yStrip.get(i).getY()) < closestPair.getDistance()) {
                    if(Math.abs(yStrip.get(k).DistanceFrom(yStrip.get(i))) < closestPair.getDistance()){
                        closestPair = new Pair(yStrip.get(i), yStrip.get(k));
                    }
                    k++;
                }
            }
            
            System.out.printf("\tFound result: P1: (%.4f, %.4f), P2: (%.4f, %.4f), Distance: %.4f\n", 
                        closestPair.getPoint1().getX(), closestPair.getPoint1().getY(), 
                        closestPair.getPoint2().getX(), closestPair.getPoint2().getY(), closestPair.getDistance());
        }
        //return the closest pair
        return closestPair;
    }
}