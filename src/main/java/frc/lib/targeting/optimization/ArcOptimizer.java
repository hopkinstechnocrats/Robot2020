/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.lib.targeting.optimization;

import java.util.Map;

import frc.robot.data.Constants;
import frc.lib.motion.Arc;
import frc.lib.motion.Movement;

/**
 * Twists the drivetrain in place to optimize a value towards a target
 */
public class ArcOptimizer extends Optimizer {

    double target;
    double forwardSpeed;
    boolean sensorPhase;

    /**
     * 
     * @param target optimal x value of the target
     * @param forwardSpeed forward percent output speed to drive at
     * @param sensorPhase whether x values increase clockwise
     */
    public ArcOptimizer(double target, double forwardSpeed,boolean sensorPhase) {
        this.target = target;
        this.sensorPhase = sensorPhase;
        this.forwardSpeed = forwardSpeed;
    }

    /** 
     * 
     * @param inputdata sensed values to optimize. In ArcOptimizer, consists of "position"
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
        return new Arc(-error*Constants.TWIST_OPTIMIZER_KP, this.forwardSpeed);
    }



}
