/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.targeting.vision;

/**
 * Add your docs here.
 */
public class PixyCameraData extends CameraData {
    
    public PixyCameraData(double rawXValue, boolean isTargetVisible){
        this.x = ((rawXValue/3.3)-0.5)*30;
        this.isTargetVisible = isTargetVisible;
    }

}
