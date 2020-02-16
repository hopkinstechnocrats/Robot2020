/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoroutines;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.commands.FeedBall;
import frc.robot.commands.SpinLauncher;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Launcher;

public class ThreeBallsFromStartingPosition extends CommandGroup {
  /**
   * Add your docs here.
   */
  public ThreeBallsFromStartingPosition(Launcher launcher, Feed feed) {
    addSequential(new SpinLauncher(launcher, Constants.LAUNCHER_WHEELS_ENCODER_SPEED), 5);
    addParallel(new SpinLauncher(launcher, Constants.LAUNCHER_WHEELS_ENCODER_SPEED), 10);
    addParallel(new FeedBall(feed, Constants.FEED_WHEELS_SPEED), 10);
  }
}
