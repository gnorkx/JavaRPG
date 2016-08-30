/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.Random;

/**
 *
 * @author jansh
 */
public class Range {
    
    public Range(double min, double max){
        _min = min; _max = max;
        _value = getMean();
    }
    
    public Range(double min, double max, double value){
        _min = min; _max = max;
        _value = value;
        
    }
    
    static {
        _rand = ServiceLocator.getRandom();
    }
    
    public double getValue(){
        return _value;
    }
    
    public void setValue(double x){
        _value = x;
    }

    public double getRandom(){
        return _rand.nextDouble()*(_max-_min) + _min;
    }
    
    public double getMean(){
        return (_max+_min)/2.;
    }
    
    private double _min, _max;
    private double _value;
    private static Random _rand;
}
