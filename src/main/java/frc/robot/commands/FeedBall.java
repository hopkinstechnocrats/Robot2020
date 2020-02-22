/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.TankDrive;
import frc.robot.components.*;
import frc.robot.data.Constants;
import frc.robot.Robot;

public class FeedBall extends Command {

  TankDrive drivetrain;
  double deadband;
  boolean isFlipped;
  boolean isSquared;
  XboxController controller;
  Talon left;
  Talon right;
  double speed;
  Feed feed;
  boolean inverted;

  public FeedBall(Feed feed, boolean inverted) {
    // Use requires() here to declare subsystem dependencies
    this.feed = feed;
    this.speed = feed.getSpeed();
    this.inverted = inverted;
    requires(feed);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    feed.runFeed(inverted);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
