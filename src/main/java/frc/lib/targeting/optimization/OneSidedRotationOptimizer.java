/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.lib.targeting.optimization;

import java.util.Map;

import frc.robot.data.Constants;
import frc.lib.motion.OneSidedRotation;
import frc.lib.motion.Movement;

/**
 * Twists the drivetrain in place to optimize a value towards a target
 */
public class OneSidedRotationOptimizer extends Optimizer {

    double target;
    boolean sensorPhase;

    public OneSidedRotationOptimizer(double target, boolean sensorPhase) {
        this.target = target;
        this.sensorPhase = sensorPhase;
    }

    public Movement getMovement(Map<String, Object> inputData) {
        double error;
        double position = (Double)inputData.get("position");

        if (sensorPhase){
            error = target-position;
        } else {
            error = target+position;
        }
        
        return new OneSidedRotation(error*Constants.TWIST_OPTIMIZER_KP, false);
    }
}
