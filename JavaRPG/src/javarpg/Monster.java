/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

import java.awt.Color;
import java.awt.Graphics;
import utils.Input;
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
    }

    Monster(Vector pos) {
        super(pos.getX(), pos.getY());
        _color = Color.red;
        _size = 20;
    }
 
    @Override
    public void update(){
        move();
        if(_health.isEmpty())
            dead();
    };
    
        
}
