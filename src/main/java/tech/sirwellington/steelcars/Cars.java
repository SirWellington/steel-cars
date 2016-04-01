/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tech.sirwellington.steelcars;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.sirwellington.alchemy.annotations.access.NonInstantiable;

/**
 * @author SirWellington
 */
@NonInstantiable
public class Cars
{

    private final static Logger LOG = LoggerFactory.getLogger(Cars.class);

    public Cars() throws IllegalAccessException
    {
        throw new IllegalAccessException("cannot instantiate");
    }

    public static Vehicle newFerrari()
    {
        return CarBuilder.newBuilder()
            .withTopSpeed(210)
            .withAcceleration(Acceleration.ROCKET_FAST)
            .withDecceleration(Deceleration.SMOOTH)
            .withEngine(Engine.GASOLINE)
            .build();
    }

    public static Vehicle newHondaInsight()
    {
        return CarBuilder.newBuilder()
            .withTopSpeed(120)
            .withAcceleration(Acceleration.SLOW)
            .withDecceleration(Deceleration.SMOOTH)
            .withEngine(Engine.HYBRID)
            .build();
    }

    public static Vehicle newSemiTruck()
    {
        return CarBuilder.newBuilder()
            .withTopSpeed(80)
            .withAcceleration(Acceleration.SLOW)
            .withDecceleration(Deceleration.SLOWLY)
            .withEngine(Engine.DIESEL)
            .build();
    }

    public static Vehicle newHondaS2000()
    {
        return CarBuilder.newBuilder()
            .withTopSpeed(141)
            .withAcceleration(Acceleration.FAST)
            .withDecceleration(Deceleration.JERKY)
            .withEngine(Engine.GASOLINE)
            .build();
    }

    public static Vehicle newTeslaModel3()
    {
        return CarBuilder.newBuilder()
            .withTopSpeed(165)
            .withAcceleration(Acceleration.ROCKET_FAST)
            .withDecceleration(Deceleration.SMOOTH)
            .withEngine(Engine.ELECTRIC)
            .build();
    }

    public static Vehicle newToyotaPrius()
    {
        return CarBuilder.newBuilder()
            .withTopSpeed(120)
            .withAcceleration(Acceleration.SLOW)
            .withDecceleration(Deceleration.JERKY)
            .withEngine(Engine.HYBRID)
            .build();
    }

}
