/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.data.Constants;
import frc.robot.commands.FeedBall;
import frc.robot.commands.StopFeed;
import frc.robot.components.Talon;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */

public class Feed extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  XboxController controller;
  Talon motor;
  double speed;

  public Feed(Talon component, XboxController controller) {
    this.controller = controller;
    this.motor = component;
    speed = Constants.FEED_WHEELS_SPEED;
  }

  public void runFeed(boolean inverted) {
    if(inverted){
      motor.set(-speed);
    }else{
      motor.set(speed);
    }
  }

  public void stopFeed(){
    motor.set(0);
  }

  public double getSpeed(){
    return speed;
  }

  public void setSpeed(double speed){
    this.speed = speed;
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new StopFeed(this));
  }

}
