/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoroutines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.DriveMotionProfile;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.TankDrive;

/**
 * Auto routine that starts on the initiation line, drives backwards two feet, then launches three balls into the outer port
 */
public class DriveBackwardsThenLaunchThreeBalls extends CommandGroup {

  /**
   * Auto routine that starts on the initiation line, drives backwards two feet, then launches three balls into the outer port
   * @param launcher launcher subsystem object
   * @param feed feed subsystem object
   * @param drivetrain drivetrain subsystem object
   */
  public DriveBackwardsThenLaunchThreeBalls(Launcher launcher, Feed feed, TankDrive drivetrain) {
    addSequential(new DriveMotionProfile("backwardsOneFoot", drivetrain, true));
    addSequential(new ShootThreeBalls(launcher, feed), 10);
  }
}
