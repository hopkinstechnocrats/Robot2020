/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoroutines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.data.Constants;
import frc.robot.commands.FeedBall;
import frc.robot.commands.SetFeedSpeed;
import frc.robot.commands.SpinLauncher;
import frc.robot.commands.StopLauncher;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Launcher;

/**
 * Activates launcher and feed to shoot three preloaded balls
 */
public class ShootThreeBalls extends CommandGroup {

  /**
   * Activates launcher and feed to shoot three preloaded balls
   * @param launcher launcher subsystem object
   * @param feed feed subsystem object
   */
  public ShootThreeBalls(Launcher launcher, Feed feed) {
    addSequential(new StopLauncher(launcher), 1.5);
    addSequential(new SpinLauncher(launcher, -9200), 2);
    addSequential(new SetFeedSpeed(feed, 1));
    addParallel(new SpinLauncher(launcher, -9200), 4);
    addSequential(new FeedBall(feed, false), 4);
    addSequential(new SetFeedSpeed(feed, 1));
    addSequential(new StopLauncher(launcher), 1);
  }
}
