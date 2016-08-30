/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

import java.awt.Graphics;
import utils.Vector;
import utils.Camera;
import utils.Rect;

/**
 *
 * @author jansh
 */
public class RenderingHandler {
    public RenderingHandler(Graphics g){
        _g = g;
        _camera = new Camera();
    }
    
    void render(GameObject o){
         Rect tmp = _camera.World2Screen(o.getBox());
        _g.drawImage(o.getTexture(), (int)tmp.getPos().getX(), (int)tmp.getPos().getY(),
                (int)tmp.getSize().getX(),(int)tmp.getSize().getY(),null);
        
    }
    void render(Tile t){
         Rect tmp = _camera.World2Screen(t.getBox());
        _g.drawImage(t.getTexture(), (int)tmp.getPos().getX(), (int)tmp.getPos().getY(),
                (int)tmp.getSize().getX(),(int)tmp.getSize().getY(),null);
        
    }
    
    
    public Camera getCamera(){
        return _camera;
    }
    
    private Graphics _g;
    private Camera _camera;
}
