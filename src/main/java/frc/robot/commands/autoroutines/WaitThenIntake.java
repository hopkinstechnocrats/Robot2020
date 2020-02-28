/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoroutines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.DriveMotionProfile;
import frc.robot.commands.FeedBall;
import frc.robot.commands.IntakeBall;
import frc.robot.commands.SetFeedSpeed;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.TankDrive;

public class WaitThenIntake extends CommandGroup {
  /**
   * Add your docs here.
   */
  public WaitThenIntake(Launcher launcher, Feed feed, TankDrive drivetrain, Intake intake, double waitTime, double intakeTime) {
    addSequential(new SetFeedSpeed(feed, 1), waitTime);
    addParallel(new FeedBall(feed, false));
    addSequential(new IntakeBall(intake, false), intakeTime);
  }
}
