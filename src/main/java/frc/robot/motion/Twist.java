/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.motion;

import frc.robot.data.Constants;

/**
 * Twists clockwise about the center of the robot at a specified angular speed
 */
public class Twist extends Movement {

    public Twist(double angularspeed) {
        this.leftSpeed = angularspeed*Constants.DRIVETRAIN_WIDTH/2;
        this.rightSpeed = -angularspeed*Constants.DRIVETRAIN_WIDTH/2;
    }

}
