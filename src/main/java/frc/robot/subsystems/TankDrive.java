/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.io.IOException;
import java.util.HashMap;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.commands.JoystickDrive;
import frc.robot.components.*;
import frc.robot.motion.Movement;

import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motorcontrol.IMotorController;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */

public class TankDrive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  SpeedControllerGroup left;
  SpeedControllerGroup right;
  public Talon leftTalon1;
  public Talon leftTalon2;
  public Talon rightTalon1;
  public Talon rightTalon2;
  public DifferentialDrive diffDrive;
  XboxController controller;
  public double speed;
  public boolean flipped = false;
  
  public TankDrive(Talon leftTalon1, Talon leftTalon2, Talon rightTalon1, Talon rightTalon2, XboxController controller) {
    left = new SpeedControllerGroup(leftTalon1);
    right = new SpeedControllerGroup(rightTalon1);
    diffDrive = new DifferentialDrive(left, right);
    this.leftTalon1 = leftTalon1;
    this.leftTalon2 = leftTalon2;
    this.leftTalon2.follow(leftTalon1);
    this.rightTalon1 = rightTalon1;
    this.rightTalon2 = rightTalon2;
    this.rightTalon2.follow(rightTalon1);
    this.controller = controller;
    this.speed = .3;
    this.leftTalon1.configureDrivetrainFalcon();
    this.rightTalon1.configureDrivetrainFalcon();
  }

  public void tankDrive(double left, double right, boolean isSquared){
    diffDrive.tankDrive(speed*left, speed*right, isSquared);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new JoystickDrive(this, controller, .01, false, true));
  }

  public void setSpeed(double speed){
    this.speed = speed;
  }

  public void driveMovement(Movement movement) {
    this.tankDrive(movement.leftSpeed, movement.rightSpeed, false);
  }

  public void setFlipped(boolean flipped){
    this.flipped = flipped;
  }

  public boolean loadMotionProfile(String name, Boolean isInverted) throws IOException{
    boolean success = true;
    success = success && leftTalon1.loadMotionProfile(name, (name+".left.pf1.csv"), isInverted);
    success = success && rightTalon1.loadMotionProfile(name, (name+".right.pf1.csv"), !isInverted);
    return success;
  }

  public void startMotionProfile(String name) {
    leftTalon1.startMotionProfile(name);
    rightTalon1.startMotionProfile(name);
  }

  public boolean isMotionProfileFinished() {
    boolean finished = false;
    finished = finished || leftTalon1.isMotionProfileFinished();
    finished = finished || rightTalon1.isMotionProfileFinished();
    if (finished) {
      cancelMotionProfile();
    }
    return finished;
  }

  public HashMap getMotionProfileStatuses() {
    HashMap statuses = new HashMap<String, MotionProfileStatus>();
    statuses.put("Left", leftTalon1.getMotionProfileStatus());
    statuses.put("Right", rightTalon1.getMotionProfileStatus());
    return statuses;
  }

  public void cancelMotionProfile() {
    leftTalon1.cancelMotionProfile();
    rightTalon1.cancelMotionProfile();
  }

  public void clearOldMotionProfiles() {
    leftTalon1.clearOldMotionProfiles();
    rightTalon1.clearOldMotionProfiles();
  }

  public void zeroEncoders() {
    leftTalon1.zeroEncoder();
    rightTalon1.zeroEncoder();
  }

  public void feedMotorSafety() {
    leftTalon1.feed();
    rightTalon1.feed();
    leftTalon2.feed();
    rightTalon2.feed();
    diffDrive.feed();
  }

}
