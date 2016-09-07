/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;



import static javarpg.ObjectState.*;
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
       _boundingBox.scaleH(0.8);
    }
    
    void jump(){
        if(_state == INAIR) return;
        _state = INAIR;
        _velExt.add(new Vector(0., -50));
        
    }
    
    void duck(){
        
    }
    
    void stand(){
        
    }
    
    void walk(double v){
        Vector vel = new Vector(v,0);
        _velExt = vel;
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
