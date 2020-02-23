/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.targeting.optimization;

import java.util.Map;

import frc.robot.data.Constants;
import frc.robot.motion.Movement;
import frc.robot.motion.Twist;

/**
 * Twists the drivetrain in place to optimize a value towards a target
 */
public class TwistOptimizer extends Optimizer {

    double target;
    boolean sensorPhase;


    /**
     * 
     * @param target optimal x value of the target
     * @param sensorPhase whether x values increase clockwise
     */
    public TwistOptimizer(double target, boolean sensorPhase) {
        this.target = target;
        this.sensorPhase = sensorPhase;
    }

    /** 
     * 
     * @param inputdata sensed values to optimize. In TwistOptimizer, consists of "position"
     */
    @Override
    public Movement getMovement(Map<String, Object> inputdata) {
        double error;
        double position = (Double)inputdata.get("position");

        if (sensorPhase){
            error = target-position;
        } else {
            error = target+position;
        }
        return new Twist(-error*Constants.TWIST_OPTIMIZER_KP);
    }

}
