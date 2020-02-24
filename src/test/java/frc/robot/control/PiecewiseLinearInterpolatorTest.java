/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.control;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import frc.robot.data.TestLauncherSpeedDataset;
import frc.robot.control.PiecewiseLinearInterpolator;

/**
 * Add your docs here.
 */
public class PiecewiseLinearInterpolatorTest {

    PiecewiseLinearInterpolator interpolator;

    @Before
    public void setup() {
        this.interpolator = new PiecewiseLinearInterpolator();
        this.interpolator.setDataset(new TestLauncherSpeedDataset());
    }

    @Test
    public void testGetNearPointsInnerCase() {
        double [][] ExpectedValue1 = {{100d,1000d},{500d,5000d}};
        assertEquals(ExpectedValue1, interpolator.getNearPoints(200));
        double [][] ExpectedValue2 = {{500d,5000d},{1000d,10000d}};
        assertEquals(ExpectedValue2, interpolator.getNearPoints(800));
    }

    @Test
    public void testGetNearPointsEdgeCase() {
        double [][] ExpectedValue1 = {{100d,1000d},{500d,5000d}};
        double [][] ExpectedValue2 = {{500d,5000d},{1000d,10000d}};
        assertEquals(ExpectedValue1, interpolator.getNearPoints(100));
        assertEquals(ExpectedValue1, interpolator.getNearPoints(500));
        assertEquals(ExpectedValue2, interpolator.getNearPoints(1000));
    }
    
    @Test
    public void testGetNearPointsOuterCase() {
        double [][] ExpectedErrorValue = {{0d, 0d},{0d, 0d}};
        assertEquals(ExpectedErrorValue, interpolator.getNearPoints(0));
        assertEquals(ExpectedErrorValue, interpolator.getNearPoints(1001));
        assertEquals(ExpectedErrorValue, interpolator.getNearPoints(99));

    }
}
