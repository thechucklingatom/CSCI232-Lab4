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
    //just to help keep order of the points if using arrayLists
    private int xPos;
    public Point(double inX, double inY){
        x = inX;
        y = inY;
    }
    
    public double DistanceFrom(Point p2){
        
        double dis = Math.sqrt(Math.pow(p2.getX() - x, 2) + Math.pow(p2.getY() - y, 2));
        
        //If they are the same point then INF distance
        if(dis == 0){
            //Infinite
            return Double.MAX_VALUE;
        }
        return dis;
    }
    
    
    //getters
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public int getXPos(){
        return xPos;
    }
    
    //setter
    public void setXPos(int pos){
        xPos = pos;
    }
}