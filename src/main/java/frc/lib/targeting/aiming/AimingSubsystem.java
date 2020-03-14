/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.lib.targeting.aiming;

import java.util.HashMap;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.lib.motion.Movement;
import frc.lib.targeting.optimization.Optimizer;
import frc.lib.targeting.vision.Camera;

/**
 * Generic Subsystem that uses camera data to aim towards a target
 */
public class AimingSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  protected Camera source;
  private Optimizer optimizer;

  public AimingSubsystem(Optimizer optimizer, Camera source) {
    this.optimizer = optimizer;
    this.source = source;
  }

  public Movement getDrivetrainAction(double x) {
    HashMap inputData = new HashMap<String, Object>();
    inputData.put("position", x);
    return optimizer.getMovement(inputData);
  }

  public Camera getSource(){
    return source;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
