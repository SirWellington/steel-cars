/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tech.sirwellington.steelcars;

import tech.sirwellington.alchemy.annotations.designs.patterns.BuilderPattern;
import tech.sirwellington.alchemy.arguments.Arguments;
import tech.sirwellington.alchemy.arguments.assertions.Assertions;
import tech.sirwellington.alchemy.arguments.assertions.NumberAssertions;

import static tech.sirwellington.alchemy.annotations.designs.patterns.BuilderPattern.Role.BUILDER;

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
    private Decceleration decceleration;

    public static CarBuilder newBuilder()
    {
        return new CarBuilder();
    }

    public CarBuilder()
    {
    }

    public CarBuilder withTopSpeed(int topSpeed)
    {
        Arguments.checkThat(topSpeed).usingMessage("Top Speed must be > 0").is(NumberAssertions.greaterThan(0));
        this.topSpeed = topSpeed;
        return this;
    }

    public CarBuilder withEngine(Engine engine)
    {
        Arguments.checkThat(engine).is(Assertions.notNull());
        this.engine = engine;
        return this;
    }

    public CarBuilder withAcceleration(Acceleration acceleration)
    {
        Arguments.checkThat(acceleration).is(Assertions.notNull());
        this.acceleration = acceleration;
        return this;
    }

    public CarBuilder withDecceleration(Decceleration decceleration)
    {
        Arguments.checkThat(decceleration).is(Assertions.notNull());
        this.decceleration = decceleration;
        return this;
    }

    public Vehicle build()
    {
        Arguments.checkThat(topSpeed > 0).usingMessage("Top Speed not set").throwing(IllegalStateException.class);
        Arguments.checkThat(acceleration, decceleration, engine).throwing(IllegalStateException.class).are(Assertions.notNull());
        return new BaseVehicle(engine, topSpeed, acceleration, decceleration);
    }

    @Override
    public String toString()
    {
        return "CarBuilder{" + "topSpeed=" + topSpeed + ", engine=" + engine + ", acceleration=" + acceleration + ", decceleration=" + decceleration + '}';
    }

}
