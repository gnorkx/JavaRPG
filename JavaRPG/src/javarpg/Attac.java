/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

import utils.ServiceLocator;
import utils.Vector;

/**
 *
 * @author jansh
 */
public class Attac {
    
    int _timer;
    
    void activate(GameObject o, Vector start, Vector end){
        if(_timer == 0){
            attac(o,start,end);
            _timer = 20;
        }
    }
    
    void update(){
        if(_timer > 0)
            _timer--;
    }
    
    protected void attac(GameObject o, Vector start, Vector end){
         ServiceLocator.getObjectHandler().newProjectile(new Projectile(start, end, o));
    }
    
    
}
