/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author jansh
 */
public class Camera {
    
    public Camera(){
        _center = new Vector(0.,0.);
        //_fov = Rect();
        _zoom = new Range(0.5, 1.5, 1.);
    }
    
    public Vector getPos(){
        return _center;
    }
    public void setPos(Vector v){
        _center = v;
    }
    
    public double getZoom(){
        return _zoom.getValue();
    }
    
    public void setZoom( double x ){
        _zoom.setValue(x);
    }
    
    public Vector World2Screen( Vector v){
        return Vector.minus(v,getPos()).times(getZoom());
    }
    
    public Rect World2Screen( Rect r ){
        Rect tmp = new Rect(World2Screen(r.getPos()),r.getSize().times(getZoom()));
        return tmp;
    }
    
    public Vector Screen2World( Vector v){
        return (Vector.add(v,getPos())).times(1./getZoom());
    }
    
    public Rect Screen2World( Rect r ){
        Rect tmp = new Rect(Screen2World(r.getPos()),r.getSize().times(1./getZoom()));
        return tmp;
    }
    
    private Vector _center;
    private Range _zoom;
    private Rect _fov;
}
