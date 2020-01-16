/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.motionprofiling;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import edu.wpi.first.wpilibj.*;
import org.junit.*;
import frc.robot.Components;
import frc.robot.components.Talon;
import frc.robot.subsystems.*;
import frc.robot.motionprofiling.MotionProfile;
import jaci.pathfinder.Trajectory;

/**
 * Add your docs here.
 */
public class MotionProfileTest {

    MotionProfile mp;
    Trajectory traj;

    @Before
    public void setup() {
        traj = new Trajectory();
        MotionProfile mp = new MotionProfile();

    }
}
