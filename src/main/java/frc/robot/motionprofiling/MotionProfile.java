/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.motionprofiling;

import jaci.pathfinder.Trajectory;

import com.ctre.phoenix.motion.BufferedTrajectoryPointStream;
import com.ctre.phoenix.motion.TrajectoryPoint;

import edu.wpi.first.wpilibj.Filesystem;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

import java.io.File;
import java.io.IOException;

import jaci.pathfinder.Pathfinder;
/**
 * Add your docs here.
 */
public class MotionProfile {

    public Trajectory trajectory;

    public MotionProfile(String csvpath) throws IOException{
        // @TODO Fix profile path location
        // This won't actually work because the code runs on the ROBOT, which does not have a C: drive.
        // The path files need to be bundled in the code sent to the robot somehow.
        File pathweaverFolder = new File(Filesystem.getDeployDirectory() + "/PathWeaver/output/");
        //if (!pathweaverFolder.isDirectory()) throw new IOException("Folder should exist");

        File myFile = new File(pathweaverFolder, csvpath);
        trajectory = Pathfinder.readFromCSV(myFile);
    }

    public MotionProfile(Trajectory trajectory) {
        this.trajectory = trajectory;
    }

    public BufferedTrajectoryPointStream getBufferedTrajectoryPointStream() {
        TrajectoryPoint point;
        TrajectoryPoint[] points = new TrajectoryPoint[trajectory.length()];
        for (int i = 0; i < trajectory.length(); i++) {
            Trajectory.Segment seg = trajectory.get(i);
            point = new TrajectoryPoint();
            point.position = seg.position*Constants.ENCODER_TICKS_PER_INCH_DRIVETRAIN;
            point.velocity = seg.velocity*Constants.ENCODER_TICKS_PER_INCH_DRIVETRAIN/10;
            points[i] = point;
        }
        BufferedTrajectoryPointStream btps = new BufferedTrajectoryPointStream();
        System.out.println(points.toString());
        System.out.println("Trajectory Point Buffer Length: "+trajectory.length());
        for (int i = 0; i < trajectory.length(); i++) {
            btps.Write(points[i]);
        }
        return btps;
    }
}
