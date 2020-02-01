/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class Constants {
    public static final int ENCODER_TICKS_PER_INCH_DRIVETRAIN = 1173;
    public static final double DRIVETRAIN_MOTION_PROFILE_KP = 1;
    public static final double DRIVETRAIN_MOTION_PROFILE_KF = 0.04;
    public static final int DRIVETRAIN_MOTION_PROFILE_ALLOWABLE_ERROR = 0;
    public static final double INTAKE_WHEELS_SPEED = -1;
    public static final double LAUNCHER_WHEELS_SPEED = -1;
    public static final double LAUNCHER_WHEELS_ENCODER_SPEED = -10000;
    public static final double LAUNCHER_KP = 0.7;
    public static final double LAUNCHER_KI = 0.0001;
    public static final double LAUNCHER_KD = 60;
}
