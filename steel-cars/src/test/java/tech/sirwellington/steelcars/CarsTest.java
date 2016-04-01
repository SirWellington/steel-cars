/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tech.sirwellington.steelcars;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import tech.sirwellington.alchemy.test.junit.runners.AlchemyTestRunner;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
import static tech.sirwellington.alchemy.arguments.Arguments.checkThat;
import static tech.sirwellington.alchemy.arguments.assertions.NumberAssertions.greaterThan;
import static tech.sirwellington.alchemy.test.junit.ThrowableAssertion.assertThrows;

/**
 *
 * @author SirWellington
 */
@RunWith(AlchemyTestRunner.class)
public class CarsTest
{

    @Before
    public void setUp() throws Exception
    {
    }

    @Test
    public void testCannotInstantiate()
    {
        assertThrows(() -> new Cars());
    }
    
    @Test
    public void testNewFerrari()
    {
        Vehicle result = Cars.newFerrari();
        checkCar(result);
    }

    @Test
    public void testNewHondaInsight()
    {
        Vehicle result = Cars.newHondaInsight();
        checkCar(result);
    }

    @Test
    public void testNewSemiTruck()
    {
        Vehicle result = Cars.newSemiTruck();
        checkCar(result);
    }

    @Test
    public void testNewHondaS2000()
    {
        Vehicle result = Cars.newHondaS2000();
        checkCar(result);
    }

    @Test
    public void testNewTeslaModel3()
    {
        Vehicle result = Cars.newTeslaModel3();
        checkCar(result);
    }

    @Test
    public void testNewToyotaPrius()
    {
        Vehicle result = Cars.newToyotaPrius();
        checkCar(result);
    }

    private void checkCar(Vehicle vehicle)
    {
        assertThat(vehicle, notNullValue());

        testAcceleration(vehicle);
        testDeceleration(vehicle);
        checkEngine(vehicle);
        checkTopSpeed(vehicle);
    }

    private void testAcceleration(Vehicle vehicle)
    {
        vehicle.accelerate();
    }

    private void testDeceleration(Vehicle vehicle)
    {
        vehicle.decelerate();
    }

    private void checkEngine(Vehicle vehicle)
    {
        assertThat(vehicle.getEngine(), notNullValue());
    }

    private void checkTopSpeed(Vehicle vehicle)
    {
        checkThat(vehicle.getTopSpeed())
            .usingMessage("Expecting Top Speed > 0")
            .is(greaterThan(0));
    }

}
