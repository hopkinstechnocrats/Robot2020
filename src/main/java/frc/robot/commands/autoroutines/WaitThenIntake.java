/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoroutines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.FeedBall;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.SetFeedSpeed;
import frc.robot.commands.StopFeed;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.TankDrive;

/**
 * Waits, then intakes balls
 */
public class WaitThenIntake extends CommandGroup {
  /**
   * Performs the following actions in sequence: 1. Activates intake and feed 2. Turns of intake and feed for spaceTime 3. turns on intake for waitTime 4. Repeat steps two and three 2 times
   * @param launcher launcher subsystem object
   * @param feed feed subsystem object
   * @param drivetr ain drivetrain subsystem object
   * @param intake intake subsystem object
   * @param waitTime time to wait before executing the command
   * @param intakeTime time to run the intake and feed for
   * @param spaceTime time to space successive runs of the the intake and feed by
   */
  public WaitThenIntake(Launcher launcher, Feed feed, TankDrive drivetrain, Intake intake, double waitTime, double intakeTime, double spaceTime) {
    addSequential(new SetFeedSpeed(feed, 1), waitTime);
    addParallel(new IntakeBall(intake, false));
    addSequential(new FeedBall(feed, false), intakeTime);
    addSequential(new StopFeed(feed), spaceTime);
    addSequential(new FeedBall(feed, false), intakeTime);
    addSequential(new StopFeed(feed), spaceTime);
    addSequential(new FeedBall(feed, false), intakeTime);
    addSequential(new StopFeed(feed), spaceTime);
  }
}
