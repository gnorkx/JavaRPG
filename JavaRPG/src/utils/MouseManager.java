/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author jansh
 */
public class MouseManager extends MouseInputAdapter{
    
    public MouseManager(){
        _input = new Input();
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
        _input.lMouse = true;
        _input.x = e.getX();
        _input.y = e.getY();
        System.out.println(_input.x+" " + _input.y);
        _input.changed = true;
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        _input.lMouse = false;
        _input.changed = true;
        //System.out.println("release " + _input.x+" " + _input.y);
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        _input.x = e.getX();
        _input.y = e.getY();
       // System.out.println(_input.x+" " + _input.y);
        _input.changed = true;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        _input.x = e.getX();
        _input.y = e.getY();
       // System.out.println(_input.x+" " + _input.y);
        _input.changed = true;
    }
    
    public Input getInput(){
      return _input;
  }
    
    private Input _input;
}
