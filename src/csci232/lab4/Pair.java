/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232.lab4;

/**
 *
 * @author atom
 */
public class Pair {
    private Point p1, p2;
    private double distance;
    
    public Pair(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
        
        //checks if it is the same point. if it is, make the distance INF
        if(this.p1.equals(this.p2)){
            distance = Double.MAX_VALUE;
        }else{
            distance = this.p1.DistanceFrom(this.p2);
        }
    }
    
    //getters
    public double getDistance(){
        return distance;
    }
    
    public Point getPoint1(){
        return p1;
    }
    
    public Point getPoint2(){
        return p2;
    }
}
