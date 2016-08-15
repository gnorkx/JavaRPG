/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import utils.*;


  

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
        long timestamp;
        long oldTimestamp;
        while(_running){
            oldTimestamp = System.currentTimeMillis();
            update();
            timestamp = System.currentTimeMillis();
            if(timestamp-oldTimestamp > maxLoopTime) {
              //System.out.println("Wir zu spät!");
              continue;
            }
            render();
            timestamp = System.currentTimeMillis();
            //System.out.println(maxLoopTime + " : " + (timestamp-oldTimestamp));
            if(timestamp-oldTimestamp <= maxLoopTime) {
              try {
                Thread.sleep(maxLoopTime - (timestamp-oldTimestamp) );
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
         
        }
        _screen.getFrame().dispose();
    }
    
    private void update(){
        
        _inputManager.update();
        handleInput(_inputManager.getInput());
        _objectHandler.handleInput(_inputManager.getInput());
        
        
        _objectHandler.update();
        
        
    
    }
    
        
    private void render(){
        
        Canvas c = _screen.getCanvas();
        c.setBackground(Color.lightGray);
        _bs = c.getBufferStrategy();
        if(_bs == null){
            _screen.getCanvas().createBufferStrategy(3);
            _bs = c.getBufferStrategy();
            _g = _bs.getDrawGraphics();
            ServiceLocator.registerRender(new RenderingHandler(_g));
            return;
        }
        //Clear Screen
        _g.clearRect(0, 0, Global.SCREEN_WIDTH, Global.SCREEN_HEIGHT);
        _objectHandler.render(_g);
        _bs.show();
        //_g.dispose();
        Toolkit.getDefaultToolkit().sync();

    }
    
    private void initGame(){
        _screen = new Screen("Game", Global.SCREEN_WIDTH, Global.SCREEN_HEIGHT);
        _inputManager = new InputManager();
        
        _screen.getCanvas().addMouseListener(_inputManager);
        _screen.getCanvas().addMouseMotionListener(_inputManager);
        _screen.getCanvas().addKeyListener(_inputManager);
        _screen.getCanvas().setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
        _screen.getCanvas().setFocusable(true);
        _screen.getFrame().setVisible(true);

        
        
        _objectHandler = new GameObjectHandler();
        ServiceLocator.registerObjectHandler(_objectHandler);
        _objectHandler.newPlayer();
        _objectHandler.newMonster(new Vector(400,300));
        
        
    }
    
    private void handleInput(Input in){
        
        if(in.quit == true)
            _running = false;
        
    }
   
    Screen _screen;
    BufferStrategy _bs;
    Graphics _g;
    InputManager _inputManager;
    private boolean _running = true;
    
    private GameObjectHandler _objectHandler;
    
    public static final int FPS = 60;
    public static final long maxLoopTime = 1000 / FPS;
}
