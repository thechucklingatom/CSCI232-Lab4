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
        if (xList.size() <= 3) {
            closestPair = bruteForce(xList);
        } else {
            closestPair = null;
            int middle = xList.size() / 2;
            
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
            
            pairLeft = closestAlgorithm(xLeft, yLeft);
            pairRight = closestAlgorithm(xRight, yRight);
            if(pairLeft.getDistance() < pairRight.getDistance()){
                closestPair = pairLeft;
            }else{
                closestPair = pairRight;
            }
            
            ArrayList<Point> yStrip = new ArrayList<Point>();
            for (Point yList1 : yList) {
                if (Math.abs(midX.getX() - yList1.getX()) < closestPair.getDistance()) {
                    yStrip.add(yList1);
                }
            }
            
            for(int i = 0; i < yStrip.size() - 1; i++){
                int k = i +1;
                while(k < yStrip.size() && (yStrip.get(k).getY() - yStrip.get(i).getY()) < closestPair.getDistance()) {
                    if(Math.abs(yStrip.get(k).DistanceFrom(yStrip.get(i))) < closestPair.getDistance()){
                        closestPair = new Pair(yStrip.get(i), yStrip.get(k));
                    }
                    k++;
                }
            }
        }

        return closestPair;
    }
}