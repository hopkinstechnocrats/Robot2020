/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.data.Constants;
import frc.robot.Robot;
import frc.robot.commands.StopIntake;
import frc.robot.components.*;


/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */

public class Intake extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  XboxController controller;
  Talon motor;
  LinearActuator actuator;

  public Intake(Talon motor, XboxController controller) {
    this.controller = controller;
    this.motor = motor;
    //this.actuator = new LinearActuator(Constants.INTAKE_SOLENOID_PORT, Constants.INTAKE_SOLENOID_DEFAULT_STATE);
    //this.actuator.initialize();
  }

  public void runIntake(boolean inverted) {
    if(inverted){
      motor.set(-Constants.INTAKE_WHEELS_SPEED);
    }else{
      motor.set(Constants.INTAKE_WHEELS_SPEED);
    }
  }

  public void stopIntake() {
    motor.set(0);
  }

  // public void toggleActuator() {
  //   actuator.toggleState();
  // }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new StopIntake(this));
  }

}
