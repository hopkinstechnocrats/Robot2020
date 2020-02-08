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
import frc.robot.targeting.vision.Camera;
import frc.robot.targeting.vision.LimelightCameraData;

/**
 * Add your docs here.
 */
public class Limelight extends Component implements Camera{

    public NetworkTable table;
    public NetworkTableEntry ty;
    public NetworkTableEntry tx;
    public NetworkTableEntry ta;
    public NetworkTableEntry tl;
    public NetworkTableEntry pipeline;
    public NetworkTableEntry tv;
    public NetworkTableEntry ts;
    public NetworkTableEntry tshort;
    public NetworkTableEntry tlong;
    public NetworkTableEntry thor;
    public NetworkTableEntry tvert;
    public NetworkTableEntry getpipe;
    public NetworkTableEntry camtran;
    public NetworkTableEntry ledMode;
    public NetworkTableEntry camMode;
    public NetworkTableEntry stream;
    public NetworkTableEntry snapshot;

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
        data.cameraTransformation = camtran.getDoubleArray(new double[] {0,0,0,0,0,0});
        data.currentPipeline = getpipe.getNumber(0).intValue();
        data.isTargetVisible = tv.getNumber(0).intValue() == 1;
        data.longSideLength = tlong.getDouble(0);
        data.pipelineLatency = tl.getDouble(0);
        data.targetSkew = ts.getDouble(0);
        data.shortSideLength = tshort.getDouble(0);
        data.verticalSideLength = tvert.getDouble(0);
        data.horizontalSideLength = thor.getDouble(0);
        return data;
    }

}
