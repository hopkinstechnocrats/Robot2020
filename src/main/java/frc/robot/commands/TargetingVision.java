/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.LauncherAimingSubsystem;
import frc.robot.components.Limelight;

public class TargetingVision extends Command {

  LauncherAimingSubsystem limelight;

  public TargetingVision(LauncherAimingSubsystem limelight) {
    // Use requires() here to declare subsystem dependencies
    requires(limelight);
    this.limelight = limelight;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    ((Limelight)limelight.getSource()).setPipeline(0);
    SmartDashboard.putNumber("distanceToTarget", ((Double)limelight.getHorizontalDistance().get("horizontalDistance")));
    SmartDashboard.putBoolean("isTargetVisible", (Boolean)limelight.getHorizontalDistance().get("isTargetVisible"));
  }
  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
