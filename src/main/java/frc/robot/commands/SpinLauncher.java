/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.TankDrive;
import frc.robot.components.*;

public class SpinLauncher extends Command {

  TankDrive drivetrain;
  double deadband;
  boolean isFlipped;
  boolean isSquared;
  XboxController controller;
  Talon left;
  Talon right;
  double speed;
  Launcher launcher;

  public SpinLauncher(Launcher launcher, double speed) {
    // Use requires() here to declare subsystem dependencies
    this.launcher = launcher;
    this.speed = speed;
    requires(launcher);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    speed = SmartDashboard.getNumber("LauncherWheelsSetSpeed", -8000);
    launcher.spinWheels(speed);
    SmartDashboard.putNumber("LauncherWheelsSpeed", launcher.getSpeed());
    SmartDashboard.putBoolean("IsLauncherFastEnough", launcher.getSpeed()>(speed-50));
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
