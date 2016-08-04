/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;
import java.awt.Color;
import static java.lang.Math.pow;
import utils.*;
import static utils.HelperFcn.sqr;
import java.awt.Graphics;

/**
 *
 * @author jansh
 */
public class GameObject {
    
    public GameObject(double x, double y, double vx, double vy){
        _pos = new Vector(x,y);
        _vel = new Vector(vx,vy);
    }
    
    public void update(){
        Vector dist = new Vector(300,300);
        dist.minus(_pos);
        _vel.add(dist.times( 10./pow(dist.abs() + 0.0001,3)*Global.dT));
        _pos.add(_vel.times(Global.dT));
        //System.out.println(_pos);
    }
    
    public void render(Graphics g){
        g.setColor(Color.white);
        g.drawOval((int)_pos.getX(), (int)_pos.getY(), 2 , 2);
    }
    
    private Vector _pos;
    private Vector _vel;
}
