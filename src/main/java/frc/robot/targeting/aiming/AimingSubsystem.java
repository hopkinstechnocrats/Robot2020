/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.targeting.aiming;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.targeting.vision.Camera;

/**
 * Generic Subsystem that uses camera data to aim towards a target
 */
public class AimingSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  Camera source;

  public AimingSubsystem(Camera source) {
    this.source = source;
  }

  public void getDrivetrainAction() {
    
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
