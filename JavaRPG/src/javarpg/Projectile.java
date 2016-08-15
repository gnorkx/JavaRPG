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
public class Projectile extends GameObject{
    
    public Projectile(double x, double y, double vx, double vy, GameObject o) {
        super(x, y, vx, vy);
        _origin = o;
        _color = Color.blue;
        _size = 5;
        _boundingBox.setSize(40.,30.);
        try {
            _texture = ImageIO.read(new File("res/arrow.png"));
        } catch (IOException ex) {
            Logger.getLogger(Projectile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Projectile(Vector start, Vector end, GameObject o){
        super(start.getX(), start.getY(), 0, 0);
        double v = 80;
        Vector vel = Vector.minus(end,start);
        vel.scale( v/vel.abs() );
        _vel.set(vel);
        _origin = o;
        _color = Color.blue;
        _size = 5;
        _boundingBox.setSize(40.,30.);
        try {
            _texture = ImageIO.read(new File("res/arrow.png"));
        } catch (IOException ex) {
            Logger.getLogger(Projectile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Override
    public void update(){
        move();
    };
    
    public GameObject getOwner(){
        return _origin;
    }
    
    @Override
    double getDamage(){
        System.out.println("dsdf");
        return 10.;
    }
    
    @Override
    void takeDamage(double d){
        _pos = new Vector(999,999);
        _boundingBox.setPos(_pos);
    }
    
    private GameObject _origin;
}
