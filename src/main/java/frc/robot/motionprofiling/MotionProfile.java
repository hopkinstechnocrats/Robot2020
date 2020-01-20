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

import java.io.File;
import java.io.IOException;

import jaci.pathfinder.Pathfinder;
/**
 * Add your docs here.
 */
public class MotionProfile {

    public Trajectory trajectory;

    public MotionProfile(String csvpath) throws IOException{
        File myFile = new File("myfile.traj");
        trajectory = Pathfinder.readFromCSV(myFile);
    }

    public MotionProfile(Trajectory trajectory) {
        this.trajectory = trajectory;
    }

    public BufferedTrajectoryPointStream getBufferedTrajectoryPointStream() {
        TrajectoryPoint[] points = new TrajectoryPoint[trajectory.length()];
        for (int i = 0; i < trajectory.length(); i++) {
            Trajectory.Segment seg = trajectory.get(i);
            TrajectoryPoint point = new TrajectoryPoint();
            point.position = seg.position;
            point.velocity = seg.velocity;
            points[i] = point;
        }
        BufferedTrajectoryPointStream btps = new BufferedTrajectoryPointStream();
        btps.Write(points);
        return btps;
    }
}
