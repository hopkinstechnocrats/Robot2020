/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.targeting.optimization;

import java.util.Map;

import frc.robot.motion.Movement;
import frc.robot.targeting.vision.CameraData;

/**
 * Add your docs here.
 */
public abstract class Optimizer {

    public abstract Movement getMovement(Map<String, Object> parameters);


}
