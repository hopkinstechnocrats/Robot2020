/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.data;

/**
 * (Distance to target in inches, Launcher encoder speed) data
 */
public class TestLauncherSpeedDataset extends Dataset{
    public static double [][] data = {
        {100, 1000},
        {500, 5000},
        {1000,10000}
    };
}
