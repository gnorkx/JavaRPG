/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import utils.Rect;

/**
 *
 * @author jansh
 */
public class Tile {
    
    Tile(double x, double y, double w, double h){
        _boundingBox = new Rect(x,y,w,h);
        try {
            _texture = ImageIO.read(new File("res/grass_small.png"));
        } catch (IOException ex) {
            Logger.getLogger(Tile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public BufferedImage getTexture(){
        return _texture;
    }
    public Rect getBox(){
        return _boundingBox;
    }
    
    private Rect _boundingBox;
    private BufferedImage _texture;
    
}
