/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;
import java.awt.Color;
import utils.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 *
 * @author jansh
 */
public abstract class GameObject {
    
    
    
    public GameObject(double x, double y){
        _pos = new Vector(x,y);
        _vel = new Vector(0,0);
        _color = Color.white;
        _size = 20;
        _boundingBox = new Rect(x,y,0,0);
    }
    
    public GameObject(double x, double y, double vx, double vy){
        _pos = new Vector(x,y);
        _vel = new Vector(vx,vy);
        _color = Color.white;
        _size = 20;
        _boundingBox = new Rect(x,y,0,0);
    }
    
    public abstract void update();
    
    
    
    public void setPos(int x, int y){
        _pos.set(x, y);
    }

    public Vector getPos(){
        return _pos;
    }
    public int getSize(){
        return _size;
    }
    public Rect getBox(){
        return _boundingBox;
    }
    public Color getColor(){
        return _color;
    }

    
    protected void move(){
        _pos.add(_vel.times(Global.dT));
        _boundingBox.setPos(_pos);
    }
    
    public BufferedImage getTexture(){
        return _texture;
    }
    
    abstract double getDamage();    
    abstract void takeDamage(double d);
    
    protected Vector _pos;
    protected Vector _vel;
    protected Rect _boundingBox;
    
    protected int _size;
    protected Color _color;
    protected BufferedImage _texture;
}
