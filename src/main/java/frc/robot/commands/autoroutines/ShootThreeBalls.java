/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoroutines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.Constants;
import frc.robot.commands.FeedBall;
import frc.robot.commands.SetFeedSpeed;
import frc.robot.commands.SpinLauncher;
import frc.robot.commands.StopLauncher;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Launcher;

public class ShootThreeBalls extends CommandGroup {
  /**
   * Add your docs here.
   */
  public ShootThreeBalls(Launcher launcher, Feed feed) {
    addSequential(new StopLauncher(launcher), 3);
    addSequential(new SpinLauncher(launcher, Constants.CLOSE_LAUNCHER_WHEELS_ENCODER_SPEED), 2);
    addParallel(new SetFeedSpeed(feed, .35));
    addParallel(new SpinLauncher(launcher, Constants.CLOSE_LAUNCHER_WHEELS_ENCODER_SPEED), 7);
    addSequential(new FeedBall(feed, false), 7);
    addSequential(new SetFeedSpeed(feed, .5));
  }
}
