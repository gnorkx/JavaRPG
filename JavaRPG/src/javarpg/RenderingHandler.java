/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

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
         Vector pos = new Vector(o.getPos());
        _g.drawImage(o.getTexture(), (int)pos.getX(), (int)pos.getY(),(int)o.getBox().getW(),(int)o.getBox().getH(),null);
        
    }
    void render(Tile t){
         Vector pos = new Vector(t.getBox().getPos());
        _g.drawImage(t.getTexture(), (int)pos.getX(), (int)pos.getY(),(int)t.getBox().getW(),(int)t.getBox().getH(),null);
        
    }
    private Graphics _g;
}
