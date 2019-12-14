/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.TankDrive;
import frc.robot.Robot;

/**
 * An example command.  You can replace me with your own command.
 */
public class JoystickDrive extends Command {

  DifferentialDrive drivetrain;
  double speed;
  double deadband;
  boolean isFlipped;
  boolean isSquared;

  public JoystickDrive(DifferentialDrive drivetrain, double speed, double deadband, boolean isFlipped, boolean isSquared) {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.tankDrive);
    this.drivetrain = drivetrain;
    this.speed = speed;
    this.deadband = deadband;
    this.isFlipped = isFlipped;
    this.isSquared = isSquared;
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
        drivetrain.tankDrive(-speed*Robot.oi.controller.getRawAxis(1), -speed*Robot.oi.controller.getRawAxis(4), isSquared);
      }else{
        drivetrain.tankDrive(speed*Robot.oi.controller.getRawAxis(1), speed*Robot.oi.controller.getRawAxis(4), isSquared);
      }
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
