/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.HashMap;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Components;
import frc.robot.commands.JoystickDrive;
import frc.robot.components.*;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */

public class TankDrive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  SpeedControllerGroup left;
  SpeedControllerGroup right;
  DifferentialDrive diffdrive;
  public double speed = 0.75;
  public boolean flipped = false;
  
  public TankDrive(Talon leftTalon1, Talon leftTalon2, Talon rightTalon1, Talon rightTalon2) {
    left = new SpeedControllerGroup(leftTalon1, leftTalon2);
    right = new SpeedControllerGroup(rightTalon1, rightTalon2);
    diffdrive = new DifferentialDrive(left, right);
  }

  public void tankDrive(double left, double right, boolean isSquared){
    diffdrive.tankDrive(speed*left, speed*right, isSquared);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new JoystickDrive(this, Robot.oi.getXboxController(), .01, false, true));
  }

  public void setSpeed(double speed){
    this.speed = speed;
  }

  public void setFlipped(boolean flipped){
    this.flipped = flipped;
  }
}
