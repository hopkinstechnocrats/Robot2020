/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.robot.Robot;

public class JoystickDrive extends Command {

  TankDrive drivetrain;
  double deadband;
  boolean isFlipped;
  boolean isSquared;
  XboxController controller;
  POVButton up;
  POVButton upLeft;
  POVButton left;
  POVButton downLeft;
  POVButton down;
  POVButton downRight;
  POVButton right;
  POVButton upRight;

  public JoystickDrive(TankDrive drivetrain, XboxController controller, double deadband, boolean isFlipped, boolean isSquared) {
    // Use requires() here to declare subsystem dependencies
    requires(drivetrain);
    this.drivetrain = drivetrain;
    this.deadband = deadband;
    this.isFlipped = isFlipped;
    this.isSquared = isSquared;
    this.controller = controller;
    up = new POVButton(controller, 0);
    upLeft = new POVButton(controller, 45);
    left = new POVButton(controller, 90);
    downLeft = new POVButton(controller, 135);
    down = new POVButton(controller, 180);
    downRight = new POVButton(controller, 225);
    right = new POVButton(controller, 270);
    upRight = new POVButton(controller, 315);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
   drivetrain.clearOldMotionProfiles();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Math.abs(Robot.oi.controller.getRawAxis(1)) > deadband || Math.abs(Robot.oi.controller.getRawAxis(5)) > deadband){
      if(isFlipped){
        drivetrain.tankDrive(Robot.oi.controller.getRawAxis(5), Robot.oi.controller.getRawAxis(1), isSquared);
      }else{
        drivetrain.tankDrive(-Robot.oi.controller.getRawAxis(1), -Robot.oi.controller.getRawAxis(5), isSquared);
      }
    }else{
      drivetrain.tankDrive(0,0, false);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    if(up.get()){
      drivetrain.setSpeed(1);
    }else if(right.get()){
      drivetrain.setSpeed(.75);
    }else if(down.get()){
      drivetrain.setSpeed(.6);
    }else if (left.get()){
      drivetrain.setSpeed(.25);
    }
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
