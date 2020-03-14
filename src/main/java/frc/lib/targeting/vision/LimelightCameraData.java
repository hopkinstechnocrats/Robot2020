/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.lib.targeting.vision;

/**
 * Add your docs here.
 */
public class LimelightCameraData extends CameraData {

    public double targetArea;
    public double targetSkew;
    public double pipelineLatency;
    public double shortSideLength;
    public double longSideLength;
    public double horizontalSideLength;
    public double verticalSideLength;
    public int currentPipeline;
    public double[] cameraTransformation;

}
