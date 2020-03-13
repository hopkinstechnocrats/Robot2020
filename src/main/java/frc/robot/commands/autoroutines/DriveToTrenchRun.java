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
 * Drives from the end position of driveBackwards to the trench run, in position to pickup the first two balls
 */
public class DriveToTrenchRun extends CommandGroup {
    /**
     * Drives from the end position of driveBackwards to the trench run, in position to pickup the first two balls
     * @param drivetrain drivetrain subsystem object
     */
    public DriveToTrenchRun(TankDrive drivetrain) {
        addSequential(new DriveMotionProfile("turnAround", drivetrain, true));
        addSequential(new DriveMotionProfile("driveToTrenchRun", drivetrain, false));
    }
}
