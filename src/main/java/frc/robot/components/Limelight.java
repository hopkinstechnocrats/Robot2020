/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.components;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import frc.robot.logger.Status;
import frc.robot.logger.StatusType;
import frc.robot.vision.Camera;
import frc.robot.vision.LimelightCameraData;

/**
 * Add your docs here.
 */
public class Limelight extends Component implements Camera{

    NetworkTable table;
    NetworkTableEntry tx;
    NetworkTableEntry ty;
    NetworkTableEntry ta;
    NetworkTableEntry tl;
    NetworkTableEntry pipeline;
    NetworkTableEntry tv;
    NetworkTableEntry ts;
    NetworkTableEntry tshort;
    NetworkTableEntry tlong;
    NetworkTableEntry thor;
    NetworkTableEntry tvert;
    NetworkTableEntry getpipe;
    NetworkTableEntry camtran;
    NetworkTableEntry ledMode;
    NetworkTableEntry camMode;
    NetworkTableEntry stream;
    NetworkTableEntry snapshot;

    public Limelight() {
        table = NetworkTableInstance.getDefault().getTable("limelight");
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        tl = table.getEntry("tl");
        tv = table.getEntry("tv");
        ts = table.getEntry("ts");
        tshort = table.getEntry("tshort");
        tlong = table.getEntry("tlong");
        thor = table.getEntry("thor");
        tvert = table.getEntry("tvert");
        getpipe = table.getEntry("getpipe");
        camtran = table.getEntry("camtran");
        pipeline = table.getEntry("pipeline");
        ledMode = table.getEntry("ledMode");
        camMode = table.getEntry("camMode");
        stream = table.getEntry("stream");
        snapshot = table.getEntry("snapshot");
    }

    public Status getStatus(){
        return new Status(StatusType.LOG, "Example Limelight Log Message");
    }

    public void setPipeline(int pipelinenumber){
        pipeline.setNumber(pipelinenumber);
    }

    public LimelightCameraData getCameraData() {
        LimelightCameraData data = new LimelightCameraData();
        data.x = tx.getDouble(0);
        data.y = ty.getDouble(0);
        data.targetArea = ta.getDouble(0);
        data.cameraTransformation = camtran.getDoubleArray({0,0,0,0,0,0});
        data.currentPipeline = getpipe.getNumber(0);
        data.isTargetVisible = tv.getBoolean(false);
        data.longSideLength = tlong.getDouble();
        data.pipelineLatency = tl.getDouble(0);
        data.targetSkew = ts.getDouble();
        data.shortSideLength = tshort.getDouble();
        data.verticalSideLength = tvert.getDouble();
        data.horizontalSideLength = thor.getDouble();
    }

}
