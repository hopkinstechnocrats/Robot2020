/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.components;

import edu.wpi.first.hal.sim.mockdata.AnalogInDataJNI;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import frc.robot.logger.Status;
import frc.robot.logger.StatusType;
import frc.robot.targeting.vision.Camera;
import frc.robot.targeting.vision.CameraData;
import frc.robot.targeting.vision.LimelightCameraData;
import frc.robot.targeting.vision.PixyCameraData;

/**
 * Add your docs here.
 */
public class Pixy extends Component implements Camera {

    AnalogInput pixy_x;
    DigitalInput pixy_on;
    double averageVoltage;
    boolean isDetected = false;

    public Pixy() {
        pixy_x = new AnalogInput(0);
        pixy_x.setOversampleBits(2);
        pixy_x.setAverageBits(2);
        pixy_on = new DigitalInput(0);
    }

    public Status getStatus(){
        return new Status(StatusType.LOG, "Example Limelight Log Message");
    }

    public PixyCameraData getCameraData() {
        PixyCameraData cameraData = new PixyCameraData(pixy_x.getAverageVoltage(), pixy_on.get());
        return cameraData;
    }

}
