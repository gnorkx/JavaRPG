/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import utils.Vector;

/**
 *
 * @author jansh
 */
public class Monster extends Creature {

    public Monster(double x, double y) {
        super(x, y);
        _color = Color.red;
        _size = 20;
        _boundingBox.setSize(50.,70.);
        try {
            _texture = ImageIO.read(new File("res/monster.png"));
        } catch (IOException ex) {
            Logger.getLogger(Monster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    Monster(Vector pos) {
        super(pos.getX(), pos.getY());
        _color = Color.red;
        _size = 20;
        _boundingBox.setSize(50.,70.);
        try {
            _texture = ImageIO.read(new File("res/monster.png"));
        } catch (IOException ex) {
            Logger.getLogger(Monster.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    @Override
    public void update(){
        move();
        if(_health.isEmpty())
            dead();
    };
    
   
        
}
