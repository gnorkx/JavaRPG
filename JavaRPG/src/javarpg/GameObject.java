/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;
import java.awt.Color;
import utils.*;
import java.awt.image.BufferedImage;
import static utils.Vector.add;
import static javarpg.ObjectState.*;

/**
 *
 * @author jansh
 */
public abstract class GameObject {
    
    
    
    public GameObject(double x, double y){
        _vel = new Vector(0,0);
        _color = Color.white;
        _size = 20;
        _boundingBox = new Rect(x,y,0,0);
    }
    
    public GameObject(double x, double y, double vx, double vy){
        _vel = new Vector(vx,vy);
        _color = Color.white;
        _size = 20;
        _boundingBox = new Rect(x,y,0,0);
    }
    
    public abstract void update();
    
    
    
    public void setPos(int x, int y){
        getBox().setPos(x, y);
    }

    public Vector getPos(){
        return getBox().getPos();
    }
    public Vector getVel(){
        return _vel;
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

    ObjectState getState() {
        return _state;
    }

    void setState(ObjectState s) {
        _state = s;
    }
    
    protected void move(){
        _vel.add(new Vector(0,0.3));
        Vector vtmp = add(_vel, _velExt);
        _boundingBox.setPos(add(getPos(),vtmp.times(Global.dT)));
    }
    
    public BufferedImage getTexture(){
        return _texture;
    }
    
    abstract double getDamage();    
    abstract void takeDamage(double d);
    
    //protected Vector _pos;
    protected Vector _vel;
    protected Vector _velExt = new Vector(); //non phys movement 
    protected Rect _boundingBox;
    
    protected int _size;
    protected Color _color;
    protected BufferedImage _texture;
    protected ObjectState _state;

    
}
