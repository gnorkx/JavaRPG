/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

import java.awt.Graphics;
import utils.Jar;

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
    
    public void hit (Projectile o){
        
        if(o.getOwner() == this) 
            return;
        
        _health.remove(o.getDamage());
        System.out.println("hit! " + _health);
        
    }
    
    public void dead(){
       _pos.set(99999,99999);
    }
    
       
    protected Jar _health;
    
}
