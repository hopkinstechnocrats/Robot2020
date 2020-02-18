/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.HashMap;
import java.util.Map;

import frc.robot.Constants;
import frc.robot.commands.LauncherAimingSubsystemDefaultCommand;
import frc.robot.motion.Movement;
import frc.robot.targeting.aiming.AimingSubsystem;
import frc.robot.targeting.optimization.TwistOptimizer;
import frc.robot.targeting.vision.Camera;
import frc.robot.targeting.vision.CameraData;

/**
 * Add your docs here.
 */
public class LauncherAimingSubsystem extends AimingSubsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public LauncherAimingSubsystem(double targetPos, Camera source) {
    super(new TwistOptimizer(Constants.LIMELIGHT_TARGET_X, Constants.LIMELIGHT_SENSOR_PHASE), source);
  }

  public Movement getDrivetrainAction() {
    CameraData cameraData = source.getCameraData();
    if (cameraData.isTargetVisible) {
      return super.getDrivetrainAction(source.getCameraData().x
      );
    } else {
      Movement movement = new Movement();
      movement.leftSpeed = 0;
      movement.rightSpeed = 0;
      return movement;
    }
  }

  public Map<String, Object> getHorizontalDistance() {
    CameraData cameraData = source.getCameraData();
    HashMap<String, Object> returnValue = new HashMap<String, Object>();
    returnValue.put("isTargetVisible", cameraData.isTargetVisible);
    returnValue.put("horizontalDistance", cameraData.y);
    return returnValue;
  }

  public Camera getSource(){
    return source;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LauncherAimingSubsystemDefaultCommand(this));
  }
}
