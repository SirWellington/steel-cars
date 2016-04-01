/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tech.sirwellington.steelcars;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import tech.sirwellington.alchemy.test.junit.runners.AlchemyTestRunner;
import tech.sirwellington.alchemy.test.junit.runners.GenerateEnum;
import tech.sirwellington.alchemy.test.junit.runners.GenerateInteger;
import tech.sirwellington.alchemy.test.junit.runners.Repeat;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import static tech.sirwellington.alchemy.generator.AlchemyGenerator.one;
import static tech.sirwellington.alchemy.generator.NumberGenerators.negativeIntegers;
import static tech.sirwellington.alchemy.test.junit.ThrowableAssertion.assertThrows;


/**
 *
 * @author SirWellington
 */
@Repeat(10)
@RunWith(AlchemyTestRunner.class)
public class CarBuilderTest 
{
    
    @GenerateInteger
    private int topSpeed;
    
    @GenerateEnum
    private Engine engine;
    
    @Mock
    private Acceleration acceleration;
    
    @Mock
    private Deceleration deceleration;
    
    private CarBuilder builder;

    @Before
    public void setUp() throws Exception
    {
        builder = new CarBuilder();
        
        setupData();
        setupMocks();
    }


    private void setupData() throws Exception
    {
        
    }

    private void setupMocks() throws Exception
    {
        
    }

    @Test
    public void testNewBuilder()
    {
        assertThat(CarBuilder.newBuilder(), notNullValue());
    }

    @Test
    public void testWithTopSpeed()
    {
        CarBuilder result = builder.withTopSpeed(topSpeed);
        assertThat(result, notNullValue());
    }
    
    @Test
    public void testWithTopSpeedWithBadArgs()
    {
        int negative = one(negativeIntegers());
        
        assertThrows(() -> builder.withTopSpeed(negative))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWithEngine()
    {
        CarBuilder result = builder.withEngine(engine);
        assertThat(result, notNullValue());
    }
    
    @Test
    public void testWithEngineWithBadArgs()
    {
        assertThrows(() -> builder.withEngine(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testWithAcceleration()
    {
        CarBuilder result = builder.withAcceleration(acceleration);
        assertThat(result, notNullValue());
    }

    @Test
    public void testWithAccelerationWithBadArgs()
    {
        assertThrows(() -> builder.withAcceleration(null))
            .isInstanceOf(IllegalArgumentException.class);
    }
    
    @Test
    public void testWithDecceleration()
    {
        CarBuilder result = builder.withDecceleration(deceleration);
        assertThat(result, notNullValue());
    }
    
    @Test
    public void testWithDecelerationWithBadArgs()
    {
        assertThrows(() -> builder.withDecceleration(null))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testBuild()
    {
        Vehicle result = builder.withTopSpeed(topSpeed)
            .withAcceleration(acceleration)
            .withDecceleration(deceleration)
            .withEngine(engine)
            .build();
        
        assertThat(result, notNullValue());
    }
    
    @Test
    public void testBuildWhenIncomplete()
    {
        assertThrows(() -> builder.build())
            .isInstanceOf(IllegalStateException.class);
    }

}