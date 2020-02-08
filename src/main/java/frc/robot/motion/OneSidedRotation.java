/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.motion;

import frc.robot.Constants;

/**
 * Twists clockwise about the center of the robot at a specified angular speed
 */
public class OneSidedRotation extends Movement {

    /**
     * 
     * @param speed the speed that the drivetrain is to be set at
     * @param side true is left, false is right
     */
    public OneSidedRotation(double speed, boolean side) {
        if(side) {
                this.leftSpeed = speed;
                this.rightSpeed = 0;
        }
        else {
                this.rightSpeed = speed;
                this.leftSpeed = 0;
        }
    }

}

//|a| = v^2/r
//|a| = v_left^2/r-robot_widt/2= v_right^2/r+robot_width
