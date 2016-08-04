/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

import java.util.ArrayList;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;


  

/**
 *
 * @author jansh
 */
public class JavaRPG implements Runnable {
 
    public static void main(String[] args) {
        JavaRPG game = new JavaRPG();
        new Thread(game).start();
    }
    
    @Override
    public void run(){
        initGame();
        while(_running){
            update();
            render();
        }
    }
    
    private void update(){
        for(GameObject o: _objects){
            o.update();
        }
    }
    
        
    private void render(){
        
        Canvas c = _screen.getCanvas();
        c.setBackground(Color.black);
        _bs = c.getBufferStrategy();
        if(_bs == null){
            _screen.getCanvas().createBufferStrategy(2);
            return;
        }
        _g = _bs.getDrawGraphics();
        //Clear Screen
        _g.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        for(GameObject o: _objects){
            o.render(_g);
        }
        _bs.show();
        _g.dispose();

    }
    
    private void initGame(){
        _screen = new Screen("Game", SCREEN_WIDTH, SCREEN_HEIGHT);
        _objects.add(new GameObject(200,200,0,0.2));
        _objects.add(new GameObject(200,200,0,0.3));
        _objects.add(new GameObject(200,200,0,0.1));
        
    }
    
    Screen _screen;
    BufferStrategy _bs;
    Graphics _g;
    private boolean _running = true;
    private ArrayList<GameObject> _objects = new ArrayList<GameObject>();
}
