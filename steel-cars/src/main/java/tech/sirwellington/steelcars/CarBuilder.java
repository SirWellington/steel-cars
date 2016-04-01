/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tech.sirwellington.steelcars;

import tech.sirwellington.alchemy.annotations.designs.patterns.BuilderPattern;
import tech.sirwellington.alchemy.arguments.assertions.Assertions;
import tech.sirwellington.alchemy.arguments.assertions.NumberAssertions;

import static tech.sirwellington.alchemy.annotations.designs.patterns.BuilderPattern.Role.BUILDER;
import static tech.sirwellington.alchemy.arguments.Arguments.checkThat;
import static tech.sirwellington.alchemy.arguments.assertions.Assertions.notNull;

/**
 *
 * @author SirWellington
 */
@BuilderPattern(role = BUILDER)
public final class CarBuilder
{

    private int topSpeed;
    private Engine engine;
    private Acceleration acceleration;
    private Deceleration deceleration;

    public static CarBuilder newBuilder()
    {
        return new CarBuilder();
    }

    public CarBuilder()
    {
    }

    public CarBuilder withTopSpeed(int topSpeed)
    {
        checkThat(topSpeed)
            .usingMessage("Top Speed must be > 0")
            .is(NumberAssertions.greaterThan(0));
        
        this.topSpeed = topSpeed;
        return this;
    }

    public CarBuilder withEngine(Engine engine)
    {
        checkThat(engine).is(Assertions.notNull());
        
        this.engine = engine;
        return this;
    }

    public CarBuilder withAcceleration(Acceleration acceleration)
    {
        checkThat(acceleration).is(notNull());
        
        this.acceleration = acceleration;
        return this;
    }

    public CarBuilder withDecceleration(Deceleration deceleration)
    {
        checkThat(deceleration).is(Assertions.notNull());
        
        this.deceleration = deceleration;
        return this;
    }

    public Vehicle build()
    {
        checkThat(topSpeed > 0).usingMessage("Top Speed not set").throwing(IllegalStateException.class);
        
        checkThat(acceleration, deceleration, engine)
            .throwing(IllegalStateException.class)
            .are(Assertions.notNull());
       
        return new BaseVehicle(engine, topSpeed, acceleration, deceleration);
    }

    @Override
    public String toString()
    {
        return "CarBuilder{" + "topSpeed=" + topSpeed + ", engine=" + engine + ", acceleration=" + acceleration + ", decceleration=" + deceleration + '}';
    }

}
