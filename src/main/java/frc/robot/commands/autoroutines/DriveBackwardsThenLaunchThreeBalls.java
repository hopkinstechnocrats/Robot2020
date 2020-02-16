/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoroutines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.commands.DriveMotionProfile;
import frc.robot.commands.FeedBall;
import frc.robot.commands.SpinLauncher;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.TankDrive;

public class DriveBackwardsThenLaunchThreeBalls extends CommandGroup {
  /**
   * Add your docs here.
   */
  public DriveBackwardsThenLaunchThreeBalls(Launcher launcher, Feed feed, TankDrive drivetrain) {
    addParallel(new DriveMotionProfile("backwardsOneFoot", drivetrain));
    addSequential(new SpinLauncher(launcher, Constants.LAUNCHER_WHEELS_ENCODER_SPEED), 5);
    addParallel(new SpinLauncher(launcher, Constants.LAUNCHER_WHEELS_ENCODER_SPEED), 10);
    addParallel(new FeedBall(feed, Constants.FEED_WHEELS_SPEED), 10);
  }
}
