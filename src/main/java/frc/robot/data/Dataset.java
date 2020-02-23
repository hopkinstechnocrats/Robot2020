/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.data;

/**
 * Data table for a single variable function
 */
public class Dataset {

    //data should be an array with a variable length and a width of 2.
    //each row will include a distance and a launcher speed
    public static double[][] data;

    public int getLength() {
        return data.length;
    }

    public double[] get(int i) {
        return data[i];
    }
}
