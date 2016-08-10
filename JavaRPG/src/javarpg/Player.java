/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import utils.Input;
import utils.Vector;
import utils.Jar;

/**
 *
 * @author jansh
 */
public class Player extends Creature {
    
    public Player(double x, double y) {
        super(x, y);
        _attac = new Attac();
        try {
            _texture = ImageIO.read(new File("res/archer.png"));
        } catch (IOException ex) {
            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
        }
    };
    
    @Override
    public void update(){
        move();
        _attac.update();
    };
    
    
    public void handleInput(Input in){
       _in = in;
       if(in.left == true) _vel.add( new Vector(-1,0));
       if(in.right == true) _vel.add( new Vector(1,0));
       if(in.up == true) _vel.add( new Vector(0,-1));
       if(in.down == true) _vel.add( new Vector(0,1));
       if(in.lMouse == true) _attac.activate(this, _pos, _in.getMousePos());
    
    };
    
    
    Input _in;
    Attac _attac;
    
}
