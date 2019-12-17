package frc.robot.commands;

import frc.robot.commands.JoystickDrive;
import frc.robot.subsystems.TankDrive;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Scheduler;

public class JoystickDriveTest {

    private JoystickDrive command;
    private Scheduler scheduler = null;
    private TankDrive subsystem;
    private XboxController controller;

    @Before
    public void setup() {
        scheduler = Scheduler.getInstance();
        subsystem = mock(TankDrive.class);
        controller = mock(XboxController.class);
        command = new JoystickDrive(subsystem, controller, 0.01, true, false);
    }

    @Test
    public void testForwardFull() throws InterruptedException {
        when(controller.getRawAxis(1)).thenReturn(1.0);
        when(controller.getRawAxis(4)).thenReturn(1.0);
        scheduler.add(command);
        command.start();
        scheduler.run();
        verify(subsystem).tankDrive(1.0, 1.0, false);
    }

}