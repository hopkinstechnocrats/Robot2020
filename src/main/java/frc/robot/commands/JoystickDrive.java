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
import frc.robot.Robot;

public class JoystickDrive extends Command {

  TankDrive drivetrain;
  double deadband;
  boolean isFlipped;
  boolean isSquared;
  XboxController controller;

  public JoystickDrive(TankDrive drivetrain, XboxController controller, double deadband, boolean isFlipped, boolean isSquared) {
    // Use requires() here to declare subsystem dependencies
    requires(drivetrain);
    this.drivetrain = drivetrain;
    this.deadband = deadband;
    this.isFlipped = isFlipped;
    this.isSquared = isSquared;
    this.controller = controller;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(Math.abs(Robot.oi.controller.getRawAxis(1)) > deadband || Math.abs(Robot.oi.controller.getRawAxis(4)) > deadband){
      if(isFlipped){
        drivetrain.tankDrive(Robot.oi.controller.getRawAxis(1), -Robot.oi.controller.getRawAxis(4), isSquared);
      }else{
        drivetrain.tankDrive(Robot.oi.controller.getRawAxis(1), Robot.oi.controller.getRawAxis(4), isSquared);
      }
    }else{
      drivetrain.tankDrive(0,0, false);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
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
