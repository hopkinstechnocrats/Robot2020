/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.targeting.geometry;

/**
 * Add your docs here.
 */
public class DistanceCalculator {
    
    private double CAMERA_ANGLE_TO_HORIZONTAL;
    private double CAMERA_TO_TARGET_VERTICAL_DISTANCE;

    /**
     * 
     * @param CAMERA_ANGLE_TO_HORIZONTAL angle from the center of the field of view of the camera to the horizontal.
     * @param CAMERA_TO_TARGET_VERTICAL_DISTANCE vertical distance in inches from the limelight to the center of the vision tape.
     */
    public DistanceCalculator(double CAMERA_ANGLE_TO_HORIZONTAL, double CAMERA_TO_TARGET_VERTICAL_DISTANCE) {
        this.CAMERA_ANGLE_TO_HORIZONTAL = CAMERA_ANGLE_TO_HORIZONTAL;
        this.CAMERA_TO_TARGET_VERTICAL_DISTANCE = CAMERA_TO_TARGET_VERTICAL_DISTANCE;
    }

    /**
     * 
     * @param verticalAngle Vertical angle to target in degrees measured from the center of the field of view of the camera
     * @return Horizontal Distance in inches to the target
     */
    public double calculateHorizontalDistance(double verticalAngle) {
        double netAngle = CAMERA_ANGLE_TO_HORIZONTAL + verticalAngle;
        return CAMERA_TO_TARGET_VERTICAL_DISTANCE/Math.tan(Math.toRadians(netAngle));
    }

}
