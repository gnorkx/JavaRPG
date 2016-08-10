/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

  private boolean[] keys;
  private Input _input = new Input();

  public KeyManager(){
    keys = new boolean[256];
  }
  public void update(){
    _input.up = keys[KeyEvent.VK_W];
    _input.down = keys[KeyEvent.VK_S];
    _input.left = keys[KeyEvent.VK_A];
    _input.right = keys[KeyEvent.VK_D];
    _input.quit = keys[KeyEvent.VK_Q];
  }
  public Input getInput(){
      return _input;
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
}
