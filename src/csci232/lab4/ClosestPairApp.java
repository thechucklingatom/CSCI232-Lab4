/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232.lab4;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author thechucklingatom
 */
public class ClosestPairApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random rand = new Random();
        Point[] xArr = new Point[20];
        ArrayList<Point> xList = new ArrayList<>();
        ArrayList<Point> yList = new ArrayList<>();
        QuickSort sorter = new QuickSort();
        Double yComponent, xComponent;
        
       
        
        for(int i = 0; i < xArr.length; i++){
            xArr[i] = new Point(rand.nextDouble() * i, rand.nextDouble() * i);
            //i+=2;
        }
        
        sorter.sort(xArr, true);
        
        for(Point p : xArr){
            xList.add(p);
        }
        
        sorter.sort(xArr, false);
        
        for(Point p : xArr){
            yList.add(p);
        }
        
        
        
        
//        Point p1 = new Point(2.0, 7.0);
//        Point p2 = new Point(4.0, 13.0);
//        Point p3 = new Point(5.0, 8.0);
//        Point p4 = new Point(10.0, 5.0);
//        Point p5 = new Point(14.0, 9.0);
//        Point p6 = new Point(15.0, 5.0);
//        Point p7 = new Point(17.0, 7.0);
//        Point p8 = new Point(19.0, 10.0);
//        Point p9 = new Point(22.0, 7.0);
//        Point p10 = new Point(25.0, 10.0);
//        Point p11 = new Point(29.0, 14.0);
//        Point p12 = new Point(30.0, 2.0);
//        ArrayList<Point> xList = new ArrayList<>();
//        xList.add(p1);
//        xList.add(p2);
//        xList.add(p3);
//        xList.add(p4);
//        xList.add(p5);
//        xList.add(p6);
//        xList.add(p7);
//        xList.add(p8);
//        xList.add(p9);
//        xList.add(p10);
//        xList.add(p11);
//        xList.add(p12);
//        ArrayList<Point> yList = xList;
//        
//        Point[] yArr = new Point[xList.size()]; 
//        yList.toArray(yArr);
//        QuickSort sorter = new QuickSort();
//        sorter.sort(yArr, false);
//        yList = new ArrayList<Point>();
//        for(Point p : yArr){
//            yList.add(p);
//        }
        
        ClosestPair theBestPair = new ClosestPair(xList, yList);
        Point[] bestPoint = theBestPair.bruteForce();
        for(Point e : bestPoint){
            System.out.println("First point is (" + e.getX() + ", " + e.getY() + ")");
        }
        
        System.out.printf("%.4f\n", bestPoint[0].DistanceFrom(bestPoint[1]));
        
        Pair bestPair = theBestPair.closestAlgorithm(xList, yList);
        
        System.out.println("The First Point is (" + bestPair.getPoint1().getX() + ", " + bestPair.getPoint1().getY() + ")");
        System.out.println("The Second Point is (" + bestPair.getPoint2().getX() + ", " + bestPair.getPoint2().getY() + ")");
        System.out.println("The distance is " + bestPair.getDistance());
    }
    
} 