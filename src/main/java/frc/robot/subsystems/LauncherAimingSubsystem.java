/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.data.Constants;
import frc.robot.data.LauncherSpeedDataset;
import frc.robot.commands.LauncherAimingSubsystemDefaultCommand;
import frc.lib.control.PiecewiseLinearInterpolator;
import frc.lib.motion.Movement;
import frc.lib.targeting.aiming.AimingSubsystem;
import frc.lib.targeting.optimization.TwistOptimizer;
import frc.lib.targeting.vision.Camera;
import frc.lib.targeting.vision.CameraData;
import frc.lib.targeting.geometry.DistanceCalculator;
/**
 * Add your docs here.
 */
public class LauncherAimingSubsystem extends AimingSubsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.\
  DistanceCalculator distanceCalculator;
  PiecewiseLinearInterpolator interpolator;


  public LauncherAimingSubsystem(double targetPos, Camera source) {
    super(new TwistOptimizer(Constants.LIMELIGHT_TARGET_X, Constants.LIMELIGHT_SENSOR_PHASE), source);
    distanceCalculator = new DistanceCalculator(Constants.CAMERA_ANGLE_TO_HORIZONTAL, Constants.CAMERA_TO_TARGET_VERTICAL_DISTANCE);
    SmartDashboard.putNumber("LauncherWheelsSetSpeed", -8000);
    interpolator = new PiecewiseLinearInterpolator();
    interpolator.setDataset(new LauncherSpeedDataset());
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
    returnValue.put("horizontalDistance", distanceCalculator.calculateHorizontalDistance(cameraData.y));
    return returnValue;
  }

  public double getLauncherSpeed() {
    try {
      if ((boolean)this.getHorizontalDistance().get("isTargetVisible")) {
        return interpolator.get((double)this.getHorizontalDistance().get("horizontalDistance"));
      }else {
        throw new Exception();
      }
    } catch (Exception e) {
      return Constants.FAR_LAUNCHER_WHEELS_ENCODER_SPEED;
    }
  }

  public Camera getSource() {
    return source;
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    setDefaultCommand(new LauncherAimingSubsystemDefaultCommand(this));
  }
}
