package frc.robot.subsystems;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import edu.wpi.first.wpilibj.*;
import org.junit.*;
import frc.robot.Components;
import frc.robot.components.Talon;
import frc.robot.subsystems.*;


public class TankDriveTest {

    Talon mocktalonleft1;
    Talon mocktalonleft2;
    Talon mocktalonright1;
    Talon mocktalonright2;
    TankDrive drive;
    XboxController controller;
    //This is the deadband set in RobotDriveBase, not the one set it JoystickDrive. 
    double deadband = 0.02;

    @Before
    public void setup() {
        mocktalonleft1 = mock(Talon.class);
        mocktalonleft2 = mock(Talon.class);
        mocktalonright1 = mock(Talon.class);
        mocktalonright2 = mock(Talon.class);
        controller = mock(XboxController.class);
        drive = new TankDrive(mocktalonleft1, mocktalonleft2, mocktalonright1, mocktalonright2, controller);
    }


    //This method is meant to mimic the function of RobotDriveBase.applyDeadband(), and rescales the zone from the deadband to 1 to be from 0 to 1
    private double applyDeadband(double input) {
        if(input <= deadband && input >= -deadband) {
            return 0;
        } else if (input >= 0) {
            return (input-deadband)/(1-deadband);
        } else {
            return -(Math.abs(input)-deadband)/(1-deadband);
        }
    }

    private void testDriveTemplate(double leftspeed, double rightspeed) {
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set(applyDeadband(leftspeed));
        verify(mocktalonleft2).set(applyDeadband(leftspeed));
        verify(mocktalonright1).set(-applyDeadband(rightspeed));
        verify(mocktalonright2).set(-applyDeadband(rightspeed));
    }

    @Test
    public void testDriveFowardFull() {
        // double leftspeed = 1;
        // double rightspeed = 1;
        // drive.tankDrive(leftspeed, rightspeed, false);
        // verify(mocktalonleft1).set(applyDeadband(leftspeed));
        // verify(mocktalonleft2).set(applyDeadband(leftspeed));
        // verify(mocktalonright1).set(-applyDeadband(rightspeed));
        // verify(mocktalonright2).set(-applyDeadband(rightspeed));
        testDriveTemplate(1,1);
    }

    @Test
    public void testDriveForwardHalf() {
        double leftspeed = 0.5;
        double rightspeed = 0.5;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set(applyDeadband(leftspeed));
        verify(mocktalonleft2).set(applyDeadband(leftspeed));
        verify(mocktalonright1).set(-applyDeadband(rightspeed));
        verify(mocktalonright2).set(-applyDeadband(rightspeed));
    }

    @Test
    public void testDriveBackwardFull() {
        double leftspeed = -1;
        double rightspeed = -1;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set(applyDeadband(leftspeed));
        verify(mocktalonleft2).set(applyDeadband(leftspeed));
        verify(mocktalonright1).set(-applyDeadband(rightspeed));
        verify(mocktalonright2).set(-applyDeadband(rightspeed));
    }

    @Test
    public void testDriveBackwardHalf() {
        double leftspeed = -0.5;
        double rightspeed = -0.5;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set(applyDeadband(leftspeed));
        verify(mocktalonleft2).set(applyDeadband(leftspeed));
        verify(mocktalonright1).set(-applyDeadband(rightspeed));
        verify(mocktalonright2).set(-applyDeadband(rightspeed));
    }

    @Test
    public void testDriveStill() {
        double leftspeed = 0;
        double rightspeed = 0;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set(applyDeadband(leftspeed));
        verify(mocktalonleft2).set(applyDeadband(leftspeed));
        verify(mocktalonright1).set(-applyDeadband(rightspeed));
        verify(mocktalonright2).set(-applyDeadband(rightspeed));
    }

    @Test
    public void testTurnRightFull() {
        double leftspeed = 1;
        double rightspeed = -1;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set(applyDeadband(leftspeed));
        verify(mocktalonleft2).set(applyDeadband(leftspeed));
        verify(mocktalonright1).set(-applyDeadband(rightspeed));
        verify(mocktalonright2).set(-applyDeadband(rightspeed));
    }

    @Test
    public void testTurnLeftFull() {
        double leftspeed = -1;
        double rightspeed = 1;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set(applyDeadband(leftspeed));
        verify(mocktalonleft2).set(applyDeadband(leftspeed));
        verify(mocktalonright1).set(-applyDeadband(rightspeed));
        verify(mocktalonright2).set(-applyDeadband(rightspeed));
    }

    @Test
    public void testTurnRightHalf() {
        double leftspeed = 0.5;
        double rightspeed = -0.5;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set(applyDeadband(leftspeed));
        verify(mocktalonleft2).set(applyDeadband(leftspeed));
        verify(mocktalonright1).set(-applyDeadband(rightspeed));
        verify(mocktalonright2).set(-applyDeadband(rightspeed));
    }

    @Test
    public void testTurnLeftHalf() {
        double leftspeed = -0.5;
        double rightspeed = 0.5;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set(applyDeadband(leftspeed));
        verify(mocktalonleft2).set(applyDeadband(leftspeed));
        verify(mocktalonright1).set(-applyDeadband(rightspeed));
        verify(mocktalonright2).set(-applyDeadband(rightspeed));
    }

    @Test
    public void testDriveForwardWithinDeadband() {
        double leftspeed = 0.01;
        double rightspeed = 0.01;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set(applyDeadband(leftspeed));
        verify(mocktalonleft2).set(applyDeadband(leftspeed));
        verify(mocktalonright1).set(-applyDeadband(rightspeed));
        verify(mocktalonright2).set(-applyDeadband(rightspeed));
    }
}
