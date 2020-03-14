/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.lib.motionprofiling;

import static org.junit.Assert.assertEquals;

import com.ctre.phoenix.motion.BufferedTrajectoryPointStream;
import com.ctre.phoenix.motion.TrajectoryPoint;

import org.junit.*;
import jaci.pathfinder.Trajectory;
import jaci.pathfinder.Trajectory.Segment;

/**
 * Add your docs here.
 */
public class MotionProfileTest {

    final Segment[] segments = {new Segment(0.02, 0, 0, 1, 1, 0, 0, 0), new Segment(0.02, 0, 0, 2, 2, 0, 0, 0)};
    MotionProfile mp;
    Trajectory traj;

    @Before
    public void setup() {
        traj = new Trajectory(segments);
        mp = new MotionProfile(traj);
    }

    @Test
    public void testGetBufferedTrajectoryPointStream() {
        BufferedTrajectoryPointStream btpsActual = mp.getBufferedTrajectoryPointStream();
        BufferedTrajectoryPointStream btpsExpected = new BufferedTrajectoryPointStream();
        TrajectoryPoint point = new TrajectoryPoint();
        point.position = 1;
        point.velocity = 1;
        btpsExpected.Write(point);
        point.position = 2;
        point.velocity = 2;
        btpsExpected.Write(point);
        assertEquals(btpsActual, btpsExpected);
    }
}
