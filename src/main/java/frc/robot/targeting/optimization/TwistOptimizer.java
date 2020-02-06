/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.targeting.optimization;

import frc.robot.Constants;
import frc.robot.motion.Movement;
import frc.robot.motion.Twist;
import frc.robot.targeting.vision.CameraData;

/**
 * Twists the drivetrain in place to optimize a value towards a target
 */
public class TwistOptimizer extends Optimizer {

    double target;
    boolean sensorPhase;

    public TwistOptimizer(double target, boolean sensorPhase) {
        this.target = target;
        this.sensorPhase = sensorPhase;
    }

    @Override
    public Movement getMovement(double position) {
        double error;

        if (sensorPhase){
            error = target-position;
        } else {
            error = target+position;
        }
        return new Twist(error*Constants.TWIST_OPTIMIZER_KP);
    }



}
