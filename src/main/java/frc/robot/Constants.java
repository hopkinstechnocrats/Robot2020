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
    //drivetrain
    public static final int ENCODER_TICKS_PER_INCH_DRIVETRAIN = 1193;
    public static final double DRIVETRAIN_MOTION_PROFILE_KP = 1;
    public static final double DRIVETRAIN_MOTION_PROFILE_KF = 0.04;
    public static final int DRIVETRAIN_MOTION_PROFILE_ALLOWABLE_ERROR = 0;
    //intake
    public static final double INTAKE_WHEELS_SPEED = 1;
    public static final int INTAKE_SOLENOID_PORT = 0;
    public static final boolean INTAKE_SOLENOID_DEFAULT_STATE = true;
    //launcher
    public static final double LAUNCHER_WHEELS_SPEED = -1;
    public static final double CLOSE_LAUNCHER_WHEELS_ENCODER_SPEED = -9750;
    public static final double MEDIUM_LAUNCHER_WHEELS_ENCODER_SPEED = -10000;
    public static final double FAR_LAUNCHER_WHEELS_ENCODER_SPEED = -10500;
    public static final double LAUNCHER_KP = 0.7;
    public static final double LAUNCHER_KI = 0.0001;
    public static final double LAUNCHER_KD = 60;
    //limelight
    public static final double DRIVETRAIN_WIDTH = 27;
    public static final double TWIST_OPTIMIZER_KP = 0.003;
	public static final double LIMELIGHT_TARGET_X = 0;
    public static final boolean LIMELIGHT_SENSOR_PHASE = true;
    //feed
    public static final double FEED_WHEELS_SPEED = 0.5;
    //climb
    public static final double CLIMB_WINCH_SPEED = 0.5;
    
    
}
