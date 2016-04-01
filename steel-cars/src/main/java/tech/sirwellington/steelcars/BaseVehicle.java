/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tech.sirwellington.steelcars;

import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tech.sirwellington.alchemy.annotations.access.Internal;
import tech.sirwellington.alchemy.annotations.designs.patterns.BuilderPattern;

import static tech.sirwellington.alchemy.annotations.designs.patterns.BuilderPattern.Role.PRODUCT;
import static tech.sirwellington.alchemy.arguments.assertions.Assertions.notNull;
import static tech.sirwellington.alchemy.arguments.Arguments.checkThat;
import static tech.sirwellington.alchemy.arguments.assertions.NumberAssertions.greaterThan;

/**
 * This internal package-private class holds the skeleton structure for a Vehicle. It's not designed to be used by the outside
 * world directly, but rather to be extended internally.
 *
 * @author SirWellington
 */
@Internal
@BuilderPattern(role = PRODUCT)
class BaseVehicle implements Vehicle
{

    private final static Logger LOG = LoggerFactory.getLogger(BaseVehicle.class);

    protected final Engine engine;
    protected final int topSpeed;
    private final Acceleration acceleration;
    private final Deceleration deceleration;

    public BaseVehicle(Engine engine, int topSpeed, Acceleration acceleration, Deceleration deceleration)
    {
        checkThat(engine, acceleration, deceleration)
            .are(notNull());

        checkThat(topSpeed)
            .usingMessage("Expecting Top Speed to be > 0")
            .is(greaterThan(0));

        this.engine = engine;
        this.topSpeed = topSpeed;
        this.acceleration = acceleration;
        this.deceleration = deceleration;
    }

    @Override
    public void accelerate()
    {
        acceleration.accelerate();
    }

    @Override
    public void decelerate()
    {
        deceleration.decelerate();
    }

    @Override
    public Engine getEngine()
    {
        return engine;
    }

    @Override
    public int getTopSpeed()
    {
        return topSpeed;
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.engine);
        hash = 89 * hash + this.topSpeed;
        hash = 89 * hash + Objects.hashCode(this.acceleration);
        hash = 89 * hash + Objects.hashCode(this.deceleration);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        
        if (obj == null)
        {
            return false;
        }
        
        if (getClass() != obj.getClass())
        {
            return false;
        }
        
        final BaseVehicle other = (BaseVehicle) obj;
        if (this.topSpeed != other.topSpeed)
        {
            return false;
        }
        
        if (this.engine != other.engine)
        {
            return false;
        }
        
        if (!Objects.equals(this.acceleration, other.acceleration))
        {
            return false;
        }
        
        if (!Objects.equals(this.deceleration, other.deceleration))
        {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString()
    {
        return "AbstractVehicle{" + "engine=" + engine + ", topSpeed=" + topSpeed + ", acceleration=" + acceleration + ", deceleration=" + deceleration + '}';
    }

    static CarBuilder builder()
    {
        return new CarBuilder();
    }

}
