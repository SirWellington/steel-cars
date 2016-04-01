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
public interface Deceleration 
{
    void decelerate();
    
    /*
     * These could also be put into separate classes but are written here for brevity.
     */
    
    Deceleration SLOWLY = () -> System.out.println("Stopping Slowly");
    
    Deceleration COMPLETE_STOP = () -> System.out.println("Jamming the Breaks");
    
    Deceleration FAST = () -> System.out.println("Stopping Quickly but Smoothly");
}
