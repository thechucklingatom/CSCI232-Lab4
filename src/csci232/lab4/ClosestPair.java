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
    public ClosestPair(ArrayList<Point> xList, ArrayList<Point> yList){
        listX = xList;
        listY = yList;
    }
    
    public Point[] BruteForce(){
        double minDis = Double.MAX_VALUE;
        Point[] closestPair = new Point[2];
        if(listX.size() < 2){
            closestPair[0] = null;
            closestPair[1] = null;
            return closestPair;
        }else{
            minDis = getDistance(listX.get(0), listX.get(1));
            closestPair[0] = listX.get(0);
            closestPair[1] = listX.get(1);
            for(int i = 0; i < listX.size() - 1; i++){
                for(int j = i + 1; j < listX.size(); j++){
                    if(getDistance(listX.get(i), listX.get(j)) < minDis){
                        minDis = getDistance(listX.get(i), listX.get(j));
                        closestPair[0] = listX.get(i);
                        closestPair[1] = listX.get(j);
                    }
                }
            }
        }
        
        return closestPair;
    }
    
    public double getDistance(Point p1, Point p2){
        double dis = Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
        return dis;
    }
}