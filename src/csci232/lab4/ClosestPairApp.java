/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232.lab4;

import java.util.Arrays;
import java.util.ArrayList;
/**
 *
 * @author thechucklingatom
 */
public class ClosestPairApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Point p1 = new Point(2.0, 7.0);
        Point p2 = new Point(4.0, 13.0);
        Point p3 = new Point(5.0, 8.0);
        Point p4 = new Point(10.0, 5.0);
        Point p5 = new Point(14.0, 9.0);
        Point p6 = new Point(15.0, 5.0);
        Point p7 = new Point(17.0, 7.0);
        Point p8 = new Point(19.0, 10.0);
        Point p9 = new Point(22.0, 7.0);
        Point p10 = new Point(25.0, 10.0);
        Point p11 = new Point(29.0, 14.0);
        Point p12 = new Point(30.0, 2.0);
        ArrayList<Point> xList = new ArrayList<>();
        xList.add(p1);
        xList.add(p2);
        xList.add(p3);
        xList.add(p4);
        xList.add(p5);
        xList.add(p6);
        xList.add(p7);
        xList.add(p8);
        xList.add(p9);
        xList.add(p10);
        xList.add(p11);
        xList.add(p12);
        ArrayList<Point> yList = xList;
        
        ClosestPair theBestPair = new ClosestPair(xList, yList);
        Point[] bestPoint = theBestPair.BruteForce();
        for(Point e : bestPoint){
            System.out.println("First point is (" + e.x + ", " + e.y + ")");
        }
        
        System.out.println(theBestPair.getDistance(bestPoint[0], bestPoint[1]));
        
        QuickSort sorter = new QuickSort();
        //sorter.sort(yList);
        
    }
 
    
}

//public static void mergeSort(Point[] arr, boolean x, )

 