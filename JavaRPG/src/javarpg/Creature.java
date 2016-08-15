/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

import java.awt.Graphics;
import utils.Jar;
import utils.Vector;

/**
 *
 * @author jansh
 */
public abstract class Creature extends GameObject{
    
    public Creature(double x, double y) {
        super(x, y);
        _health = new Jar(100);
    }
    
    @Override
    public abstract void update();
    
    
    public void dead(){
      // _pos.set(99999,99999);
       _boundingBox.setSize(70,30);
    }
    
    
    @Override
    double getDamage(){
        return 0.;
    }
    
    @Override
    void takeDamage(double d){
        _health.remove(d);
        System.out.println(_health);
    }
       
    protected Jar _health;
    
}
