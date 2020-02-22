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
        drive.speed = 1;
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
        System.out.println(String.format("leftspeed: %f\trightspeed: %f\tdeadbanded leftspeed: %f\tdeadbanded rightspeed: %f", leftspeed, rightspeed, applyDeadband(leftspeed), applyDeadband(rightspeed)));
        verify(mocktalonleft1).set(applyDeadband(leftspeed));
        verify(mocktalonleft2).follow(mocktalonleft1);
        verify(mocktalonright1).set(-applyDeadband(rightspeed));
        verify(mocktalonright2).follow(mocktalonright1);
    }

    @Test
    public void testDriveFowardFull() {
        testDriveTemplate(1,1);
    }

    @Test
    public void testDriveForwardHalf() {
        testDriveTemplate(0.5, 0.5);
    }

    @Test
    public void testDriveBackwardFull() {
        testDriveTemplate(-1, -1);
    }

    @Test
    public void testDriveBackwardHalf() {
        testDriveTemplate(-0.5, -0.5);
        
    }

    @Test
    public void testDriveStill() {
        testDriveTemplate(0, 0);
      
    }

    @Test
    public void testTurnRightFull() {
        testDriveTemplate(1, -1);

    }

    @Test
    public void testTurnLeftFull() {
        testDriveTemplate(-1, 1);

    }

    @Test
    public void testTurnRightHalf() {
        testDriveTemplate(0.5, -0.5);

    }

    @Test
    public void testTurnLeftHalf() {
        testDriveTemplate(-0.5, 0.5);

    }

    @Test
    public void testDriveForwardWithinDeadband() {
        testDriveTemplate(0.01, 0.01);

    }
}
