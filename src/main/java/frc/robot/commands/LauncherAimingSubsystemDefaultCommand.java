/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.LauncherAimingSubsystem;

public class LauncherAimingSubsystemDefaultCommand extends CommandGroup {

  LauncherAimingSubsystem limelight;

  public LauncherAimingSubsystemDefaultCommand(LauncherAimingSubsystem limelight) {
    // Use requires() here to declare subsystem dependencies
    requires(limelight);
    addSequential(new DriverVision(limelight));
    addSequential(new CalculateDistance(limelight));
  }

  
}
