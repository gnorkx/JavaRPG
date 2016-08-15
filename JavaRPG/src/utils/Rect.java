/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author jansh
 */
public class Rect {
    
    public Rect(double x,double y,double w,double h){
        _x = x; _y = y; _w = w; _h = h;
    }
    
    public Rect(){
        _x = 0; _y = 0; _w = -1; _h = 1;
   
    }
    
    public double getX(){ return _x; }
    public double getY(){ return _y; }
    public Vector getPos(){ return new Vector(_x,_y); }
   
    public double getW(){ return _w; }
    public double getH(){ return _h; }
    
    public double area(){ return _w*_h; }
    
    public void setPos(Vector v){
        _x = v.getX(); _y = v.getY();
    }
    public void setPos(double x, double y){
        _x = x; _y = y;
    }
    public void setSize(Vector v){
        _h = v.getX(); _y = v.getY();
    }
    public void setSize(double h, double w){
        _h = h; _w = w;
    }
    
    @Override
    public String toString(){
        return "[ "+ _x + ", " + _y +", "+ _w + ", " + _h +" ]";
    }
    
    public Rect getOverlap( Rect r){
        //if(area() <= 0 || r.area() <= 0) return null;
        if( (_x < r.getX() + r.getW()) && 
            (_x + _w > r.getX() ) &&
            (_y < r.getY() + r.getH() ) &&
            (_y + _h > r.getY() )){
            double x = _x>r.getX()?_x:r.getX();
            double y = _y>r.getY()?_y:r.getY();
            double w = _x+_w<r.getX()+r.getW()?_x+_w:r.getX() + r.getW() - x;
            double h = _y+_h<r.getY()+r.getH()?_y+_h:r.getY() + r.getH() - y;
    
            return new Rect(x,y,w,h);
        }else{ 
            return null;
        }
    }
    
    private double _x,_y;
    private double _w,_h;
    
}
