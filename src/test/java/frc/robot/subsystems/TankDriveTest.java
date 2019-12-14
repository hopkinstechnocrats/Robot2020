/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import edu.wpi.first.wpilibj.*;
import org.junit.*;
import frc.robot.Components;
import frc.robot.components.Talon;
import frc.robot.subsystems.*;

/**
 * Add your docs here.
 */
public class TankDriveTest {

    @Test
    public void testConstructor() {
        //Arrange
        Talon mocktalonleft1 = mock(Talon.class);
        Talon mocktalonleft2 = mock(Talon.class);
        Talon mocktalonright1 = mock(Talon.class);
        Talon mocktalonright2 = mock(Talon.class);

        //Act
        TankDrive drive = new TankDrive(mocktalonleft1, mocktalonleft2, mocktalonright1, mocktalonright2);
        for (double i=-1; i<1; i+=0.1){
            drive.tankDrive(i, i, false);
            System.out.println(i);
            verify(mocktalonleft1).set((double)i);
            verify(mocktalonleft2).set((double)i);
            verify(mocktalonright1).set((double)-i);
            verify(mocktalonright2).set((double)-i);
        }
        
    }
}
