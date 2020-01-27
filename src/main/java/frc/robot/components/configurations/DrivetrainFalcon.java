/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.components.configurations;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;

import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class DrivetrainFalcon {

    public static TalonSRXConfiguration getConfiguration() {
        TalonSRXConfiguration conf = new TalonSRXConfiguration();
        conf.slot0.allowableClosedloopError = Constants.DRIVETRAIN_MOTION_PROFILE_ALLOWABLE_ERROR;
        conf.slot0.kP = Constants.DRIVETRAIN_MOTION_PROFILE_KP;
        conf.slot0.kF = Constants.DRIVETRAIN_MOTION_PROFILE_KF;
        return conf;
    }
}
