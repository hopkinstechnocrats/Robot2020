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

    @Before
    public void setup() {
        mocktalonleft1 = mock(Talon.class);
        mocktalonleft2 = mock(Talon.class);
        mocktalonright1 = mock(Talon.class);
        mocktalonright2 = mock(Talon.class);
        drive = new TankDrive(mocktalonleft1, mocktalonleft2, mocktalonright1, mocktalonright2);
    }

    @Test
    public void testDriveFowardFull() {
        double leftspeed = 1;
        double rightspeed = 1;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set(leftspeed);
        verify(mocktalonleft2).set(leftspeed);
        verify(mocktalonright1).set(-rightspeed);
        verify(mocktalonright2).set(-rightspeed);
    }

    @Test
    public void testDriveForwardHalf() {
        double leftspeed = 0.5;
        double rightspeed = 0.5;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set(leftspeed);
        verify(mocktalonleft2).set(leftspeed);
        verify(mocktalonright1).set(-rightspeed);
        verify(mocktalonright2).set(-rightspeed);
    }

    @Test
    public void testDriveBackwardFull() {
        double leftspeed = -1;
        double rightspeed = -1;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set((double)leftspeed);
        verify(mocktalonleft2).set((double)leftspeed);
        verify(mocktalonright1).set((double)-rightspeed);
        verify(mocktalonright2).set((double)-rightspeed);
    }

    @Test
    public void testDriveBackwardHalf() {
        double leftspeed = -0.5;
        double rightspeed = -0.5;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set((double)leftspeed);
        verify(mocktalonleft2).set((double)leftspeed);
        verify(mocktalonright1).set((double)-rightspeed);
        verify(mocktalonright2).set((double)-rightspeed);
    }

    @Test
    public void testDriveStill() {
        double leftspeed = 0;
        double rightspeed = 0;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set((double)leftspeed);
        verify(mocktalonleft2).set((double)leftspeed);
        verify(mocktalonright1).set((double)-rightspeed);
        verify(mocktalonright2).set((double)-rightspeed);
    }

    @Test
    public void testTurnRightFull() {
        double leftspeed = 1;
        double rightspeed = -1;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set((double)leftspeed);
        verify(mocktalonleft2).set((double)leftspeed);
        verify(mocktalonright1).set((double)-rightspeed);
        verify(mocktalonright2).set((double)-rightspeed);
    }

    @Test
    public void testTurnLeftFull() {
        double leftspeed = -1;
        double rightspeed = 1;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set((double)leftspeed);
        verify(mocktalonleft2).set((double)leftspeed);
        verify(mocktalonright1).set((double)-rightspeed);
        verify(mocktalonright2).set((double)-rightspeed);
    }

    @Test
    public void testTurnRightHalf() {
        double leftspeed = 0.5;
        double rightspeed = -0.5;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set((double)leftspeed);
        verify(mocktalonleft2).set((double)leftspeed);
        verify(mocktalonright1).set((double)-rightspeed);
        verify(mocktalonright2).set((double)-rightspeed);
    }

    @Test
    public void testTurnLeftHalf() {
        double leftspeed = -0.5;
        double rightspeed = 0.5;
        drive.tankDrive(leftspeed, rightspeed, false);
        verify(mocktalonleft1).set((double)leftspeed);
        verify(mocktalonleft2).set((double)leftspeed);
        verify(mocktalonright1).set((double)-rightspeed);
        verify(mocktalonright2).set((double)-rightspeed);
    }
}
