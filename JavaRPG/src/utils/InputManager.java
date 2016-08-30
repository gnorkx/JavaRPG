/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

/**
 *
 * @author jansh
 */
public class InputManager extends MouseInputAdapter implements KeyListener {
    
    public InputManager(){
        _input = new Input();
        keys = new boolean[256];
    }
    
    
    public void update(){
        _input.up = keys[KeyEvent.VK_W];
        _input.down = keys[KeyEvent.VK_S];
        _input.left = keys[KeyEvent.VK_A];
        _input.right = keys[KeyEvent.VK_D];
        _input.quit = keys[KeyEvent.VK_Q];
        _input.zoom = keys[KeyEvent.VK_O];
        _input.unzoom = keys[KeyEvent.VK_P];
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }
    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
    @Override
    public void keyTyped(KeyEvent e) {
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
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        _input.x = e.getX();
        _input.y = e.getY();
        _input.changed = true;
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
        _input.x = e.getX();
        _input.y = e.getY();
        _input.changed = true;
    }
    
    public Input getInput(){
      return _input;
  }
    
    private Input _input;
    private boolean[] keys;
}
