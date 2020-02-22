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
public class Arc extends Movement {

    /**
     * 
     * @param angularSpeed angular speed to twist clockwise at
     * @param forwardSpeed percent output forward speed to drive at
     */
    public Arc(double angularSpeed, double forwardSpeed) {
        this.leftSpeed = forwardSpeed+angularSpeed*Constants.DRIVETRAIN_WIDTH/2;
        this.rightSpeed = forwardSpeed-angularSpeed*Constants.DRIVETRAIN_WIDTH/2;
    }

}
