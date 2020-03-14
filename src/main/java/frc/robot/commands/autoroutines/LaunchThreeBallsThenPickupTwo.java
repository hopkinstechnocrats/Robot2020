/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoroutines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.StopLauncher;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.TankDrive;

/**
 * Drives backwards from the initiation line, launches three preloaded balls, then drives to the trench run and picks up two more.
 */
public class LaunchThreeBallsThenPickupTwo extends CommandGroup {

  /**
   * Drives backwards from the initiation line, launches three preloaded balls, then drives to the trench run and picks up two more.
   * @param launcher launcher subsystem object
   * @param feed feed subsystem object
   * @param drivetrain drivetrain subsystem object
   * @param intake intake subsystem object
   */
  public LaunchThreeBallsThenPickupTwo(Launcher launcher, Feed feed, TankDrive drivetrain, Intake intake) {
    addSequential(new DriveBackwardsThenLaunchThreeBalls(launcher, feed, drivetrain), 10);
    addSequential(new StopLauncher(launcher), 1);
    addSequential(new DriveToTrenchRunAndIntakeTwoBalls(launcher, feed, drivetrain, intake));
  }
}
