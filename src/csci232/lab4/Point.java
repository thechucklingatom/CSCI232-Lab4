/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci232.lab4;

/**
 *
 * @author thechucklingatom
 */
public class Point {
    private double x, y;
    public Point(double inX, double inY){
        x = inX;
        y = inY;
    }
    
    public double DistanceFrom(Point p2){
        double dis = Math.sqrt(Math.pow(p2.getX() - x, 2) + Math.pow(p2.getY() - y, 2));
        if(dis == 0){
            //Infinite
            return Double.MAX_VALUE;
        }
        return dis;
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
}