package frc.robot.commands;

import frc.robot.commands.JoystickDrive;
import frc.robot.subsystems.TankDrive;

import org.junit.Before;
import org.junit.Test;

import edu.wpi.first.wpilibj.command.Scheduler;

public class JoystickDriveTest {

    private JoystickDrive command;
    private Scheduler scheduler = null;
    private TankDrive subsystem;

    @Before
    public void setup() {
        scheduler = Scheduler.getInstance();
        subsystem = mock(TankDrive.class);
        command = new JoystickDrive();
    }

    @Test
    public void testJoystickDrive() throws InterruptedException{

    }

}