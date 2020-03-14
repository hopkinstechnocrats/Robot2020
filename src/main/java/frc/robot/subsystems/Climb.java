/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.commands.FeedBall;
import frc.robot.components.Talon;
import frc.robot.commands.StopClimb;
/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */

public class Climb extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  XboxController controller;
  Talon motor;

  public Climb(Talon component, XboxController controller) {
    this.controller = controller;
    this.motor = component;
  }

  public void runClimb(double speed) {
    motor.lazySet(speed);
  }
  
  public void stopClimb() {
      motor.lazySet(0);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new StopClimb(this));
  }

}
