/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javarpg;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.function.Predicate;
import static javarpg.ObjectState.*;
import utils.Input;
import utils.Rect;
import utils.ServiceLocator;
import utils.Vector;
import static utils.Vector.*;

/**
 *
 * @author jansh
 */
public class GameObjectHandler {
    
    
    
    
    void newPlayer(){
       _player = new Player(200,300); 
       _creatures.add((Creature)_player);
    };
    
    void newProjectile(Projectile p){
        _projectiles.add(p);
    }
    
    void newTile(Tile t){
        _world.add(t);
    }
    
    void newMonster(Vector pos) {
        _creatures.add((Creature) new Monster(pos));
    }
    
    void update(){
        
        cleanUp();
        
        for(Creature c: _creatures){
            c.update();
        }
        for(Projectile p: _projectiles){
            p.update();
        }
        
        for(Creature c: _creatures){
            for(Projectile p: _projectiles){
                if(p.getOwner() == c) continue;
                handleCollision(c,p);
            }
        }
        for(Creature c1: _creatures){
            for(Creature c2: _creatures){
                if(c1 == c2) continue;
                handleCollision(c1,c2);
            }
        }
        for(Creature c: _creatures){
            for(Tile t: _world){
                handleCollision(c,t);
            }
        }
    }
    
    void cleanUp(){
        _creatures.removeIf((GameObject o) -> o.getState() == DELETE);
        _projectiles.removeIf((GameObject o) -> o.getState() == DELETE);
    }
    
    void render(Graphics g){
        for(Creature c: _creatures){
            ServiceLocator.getRender().render(c); 
        }
        for(Projectile p: _projectiles){
            ServiceLocator.getRender().render(p);
        }
        for(Tile t: _world){
            ServiceLocator.getRender().render(t);
        }
    }
    
    void handleInput(Input in){
        _player.handleInput(in);
    }
            
    
    private void handleCollision(GameObject o1, GameObject o2){
        //do they collide?
        Rect rect1 = o1.getBox(); Rect rect2 = o2.getBox();
        Rect overlap = rect1.getOverlap(rect2);
        if(overlap == null) return;
        System.out.println("hit");
        
        handleHit(o1,o2, overlap);
        
    }
    
    private void handleCollision(GameObject o1, Tile t){
        //do they collide?
        Rect rect1 = o1.getBox(); Rect rect2 = t.getBox();
        Rect overlap = rect1.getOverlap(rect2);
        if(overlap == null) return;
        //System.out.println("hit");
        
        handleTouch(o1,t, overlap);
        
    }
    
    private void handleHit(GameObject o1, GameObject o2, Rect overlap){
        double d1 = o1.getDamage(); double d2 = o2.getDamage();
        o1.takeDamage(d2); o2.takeDamage(d1);
    }
    
    private void handleTouch(GameObject o, Tile t, Rect overlap){
        Rect rect1 = o.getBox(); Rect rect2 = t.getBox();
        overlap.setW(0);
        o.getBox().setPos(minus(rect1.getPos(),overlap.getSize()));
        o.getVel().setY(0);
        o.setState(GROUND);
        
    }
            
    private ArrayList<GameObject> _objects = new ArrayList();
    private Player _player;
    private ArrayList<Projectile> _projectiles = new ArrayList();
    private ArrayList<Creature> _creatures = new ArrayList();
    private ArrayList<Tile> _world = new ArrayList();

    
}
