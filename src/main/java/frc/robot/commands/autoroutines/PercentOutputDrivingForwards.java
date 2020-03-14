/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoroutines;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import frc.lib.motion.Forwards;
import frc.robot.subsystems.TankDrive;

/**
 * Drives forwards at a certain percent output indefinitely (timeout intended when initializing)
 */
public class PercentOutputDrivingForwards extends Command {

  XboxController controller;
  double speed;
  TankDrive subsystem;

  /**
   * Drives forwards at a certain percent output indefinitely (timeout intended when initializing)
   * @param subsystem drivetrain subsystem object
   * @param speed percent output speed, between -1 and 1.
   */
  public PercentOutputDrivingForwards(TankDrive subsystem, double speed) {
    // Use requires() here to declare subsystem dependencies
    this.subsystem = subsystem;
    this.speed = speed;
    requires(subsystem);
  }


  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    subsystem.driveMovement(new Forwards(speed, speed));
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
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
