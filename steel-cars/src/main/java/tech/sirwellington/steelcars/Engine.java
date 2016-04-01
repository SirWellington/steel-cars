/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
package tech.sirwellington.steelcars;



import static tech.sirwellington.alchemy.arguments.Arguments.checkThat;
import static tech.sirwellington.alchemy.arguments.assertions.NumberAssertions.greaterThan;

/**
 *
 * @author SirWellington
 */
public enum Engine 
{
    GASOLINE(1000),
    DIESEL(750),
    ELECTRIC(100),
    HYBRID(3000)
    ;
    
    public final int weight;

    Engine(int weight)
    {
        checkThat(weight).is(greaterThan(0));
        
        this.weight = weight;
    }
    
}
