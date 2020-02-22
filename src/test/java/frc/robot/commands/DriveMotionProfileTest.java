/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.subsystems.TankDrive;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.io.IOException;

import org.junit.*;
import frc.robot.commands.DriveMotionProfile;

/**
 * Add your docs here.
 */
public class DriveMotionProfileTest {
    
    TankDrive subsystem;
    DriveMotionProfile command;

    @Before
    public void setup() {
        subsystem = mock(TankDrive.class);
        command = new DriveMotionProfile("testname", subsystem);
    }; 

    @Test
    public void testInitialize() throws IOException {
        command.initialize();
        verify(subsystem).clearOldMotionProfiles();
        verify(subsystem).zeroEncoders();
        verify(subsystem).loadMotionProfile("testname");
        verify(subsystem).startMotionProfile("testname");
    }

    @Test
    public void testExecute() {
        command.execute();
        verify(subsystem).feedMotorSafety();
        verify(subsystem).getMotionProfileStatuses();
    }

    @Test
    public void testIsFinished() {
        when(subsystem.isMotionProfileFinished()).thenReturn(true);
        assertEquals(command.isFinished(), true);
        when(subsystem.isMotionProfileFinished()).thenReturn(false);
        assertEquals(command.isFinished(), false);
    }

    @Test
    public void testEnd() {
        command.end();
        verify(subsystem).cancelMotionProfile();
        verify(subsystem).clearOldMotionProfiles();
    }

    @Test
    public void testInterrupted() {
        command.interrupted();
        verify(subsystem).cancelMotionProfile();
        verify(subsystem).clearOldMotionProfiles();
    }

}
