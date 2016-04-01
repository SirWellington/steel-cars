/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package tech.sirwellington.steelcars;


/**
 *
 * @author SirWellington
 */
public interface Vehicle 
{

    int getTopSpeed();
    
    Engine getEngine();
    
    void accelerate();
    
    void decelerate();
}
