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
public class Input {
    
    public boolean quit, up, down, left, right;
    public boolean lMouse;
    public int x,y;
    public boolean changed;
    
    public Vector getMousePos(){
        return new Vector(x,y);
    }
    
}
