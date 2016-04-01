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
public interface Acceleration 
{
    void accelerate();
    
    
    /*
     * These could be put into a separate class but are kept here for brevity.
     */
    
    Acceleration SLOW = () -> System.out.println("Lumbering Slow");
    
    Acceleration FAST = () -> System.out.println("Quick Accelerate");
    
    Acceleration ROCKET_FAST = () -> System.out.println("Tesla Model 3 Fast!");
}
