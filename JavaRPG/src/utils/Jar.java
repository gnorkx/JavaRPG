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
public class Jar {
    
    public Jar(double max){
        _maximum = max;
        _current = max;
        _isEmpty = false;
    }
    
    public void fill(double x){
        _current += x;
        if(_current > 0)
            _isEmpty = false;
        if( _current > _maximum)
                _current = _maximum;
    }
    
    public void remove(double x){
        _current -= x;
        if(_current <= 0){
            _current = 0;
            _isEmpty = true;
        }
    }
    
    public boolean isEmpty(){
        return _isEmpty;
    }
    
    public double getCurrent(){
        return _current;
    }
    
    public double getMax(){
        return _maximum;
    }
   
    public void setMax(double x){
        _maximum = x;
    }
    
    public void setFull(){
        _current = _maximum;
        _isEmpty = false;
    }
    
    @Override
    public String toString(){
        return "[" + _current + " / "+ _maximum + "] (" + _current/_maximum*100 + "%)";
    }
    
    private double _maximum;
    private double _current;
    private boolean _isEmpty;
    
}
