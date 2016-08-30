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
public class Vector implements Cloneable{
    protected double _x;
    protected double _y;
    
    
    public Vector(double x, double y){
        set(x,y);
    }
    public Vector(Vector v){
        set(v.getX(),v.getY());
    }
    public Vector(){
        set(0,0);
    }
    public void set(double x, double y){
        _x = x; _y = y;
    }
    public void setX(double x){
        _x = x;
    }
    public void setY(double y){
        _y = y;
    }
    public void set(Vector v){
        _x = v.getX(); _y = v.getY();
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
    
    public static Vector add( Vector lhs, Vector rhs ){
        return new Vector(lhs._x + rhs._x, lhs._y + rhs._y); 
    }
    
    public static Vector minus( Vector lhs, Vector rhs ){
        return new Vector(lhs._x - rhs._x, lhs._y - rhs._y); 
    }
    
    public double scalar( Vector rhs ){
        return _x*rhs._x + _y*rhs._y; 
    }
    public Vector times(double A){
        return new Vector(A*_x, A*_y);
    }
    public void scale(double A){
        _x = A*_x; _y =  A*_y;
    }
    @Override
    public String toString(){
        return "(" + _x + ", "+ _y + ")";
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException{
       return super.clone();
    }
    
    public double getX(){
        return _x;
    }
    public double getY(){
        return _y;
    }
}
