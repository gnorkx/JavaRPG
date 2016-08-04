/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import static java.lang.Math.*;
/**
 *
 * @author jansh
 */
public class Vector {
    protected double _x;
    protected double _y;
    
    
    public Vector(double x, double y){
        set(x,y);
    }
    public Vector(){
        set(0,0);
    }
    public void set(double x, double y){
        _x = x; _y = y;
    }
    public double abssqr(){
        return _x*_x + _y*_y;
    }
    public double abs(){
        return sqrt(abssqr());
    }
    public void add( Vector rhs ){
        _x += rhs._x; _y += rhs._y; 
    }
    public void minus( Vector rhs ){
        _x -= rhs._x; _y -= rhs._y; 
    }
    public double scalar( Vector rhs ){
        return _x*rhs._x + _y*rhs._y; 
    }
    public Vector times(double A){
        return new Vector(A*_x, A*_y);
    }
    public String toString(){
        return "(" + _x + ", "+ _y + ")";
    }
    
    public double getX(){
        return _x;
    }
    public double getY(){
        return _y;
    }
}
