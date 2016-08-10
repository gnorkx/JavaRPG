/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

import java.awt.Color;
import java.awt.Graphics;
import utils.Vector;

/**
 *
 * @author jansh
 */
public class RenderingHandler {
    public RenderingHandler(Graphics g){
        _g = g;
    }
    
    void render(GameObject o){
        int size = o.getSize();
        Vector pos = new Vector(o.getPos());
        _g.setColor(o.getColor());
        _g.drawOval((int)pos.getX(), (int)pos.getY(), size , size);
    }
    
    private Graphics _g;
}
