/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.autoroutines;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.TankDrive;

/**
 * Drives to trench run and simultaneously activates the intake and feed to pickup the first two balls in the trench run
 */
public class DriveToTrenchRunAndIntakeTwoBalls extends CommandGroup {
  /**
   * Drives to trench run and simultaneously activates the intake and feed to pickup the first two balls in the trench run
   * @param launcher launcher subsystem object
   * @param feed feed subsystem object
   * @param drivetrain drivetrain subsystem object
   * @param intake intake subsystem object
   */
  public DriveToTrenchRunAndIntakeTwoBalls(Launcher launcher, Feed feed, TankDrive drivetrain, Intake intake) {
    addParallel(new WaitThenIntake(launcher, feed, drivetrain, intake, 3, 0.5, 1));
    addSequential(new DriveToTrenchRun(drivetrain));
  }
}
