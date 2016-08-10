/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import javarpg.GameObjectHandler;
import javarpg.JavaRPG;
import javarpg.RenderingHandler;

/**
 *
 * @author jansh
 */
public class ServiceLocator {
    
    public static void registerRender( RenderingHandler graphics ){
        _renderingHandler = graphics;
    };
    public static void registerGame( JavaRPG game ){
        _game = game;
    };
    public static void registerObjectHandler( GameObjectHandler handler ){
        _objectHandler = handler;
    };
    
    public static RenderingHandler getRender(){
        return _renderingHandler;
    };
    public static JavaRPG getGame(){
        return _game;
    };
    public static GameObjectHandler getObjectHandler(){
        return _objectHandler;
    };
    
    private static JavaRPG _game;
    private static RenderingHandler _renderingHandler;
    private static GameObjectHandler _objectHandler;
}
