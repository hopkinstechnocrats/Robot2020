/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Robot;

public class TurnToTape extends Command {
  public static final double TURN_SPEED = 0.01;
  DifferentialDrive drive;
  XboxController testXbox;

  public TurnToTape() {
    // Use requires() here to declare subsystem dependencies
    requires(Robot.limelight);
    requires(Robot.tankDrive);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    Robot.limelight.getNetworkTable().getEntry("pipeline").setNumber(0);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute(){
    Robot.limelight.getNetworkTable().getEntry("pipeline").setNumber(0);
    double[] limelightdata = Robot.limelight.getTapeLocation();
    //System.out.println(String.format("Limelight X: %f", limelightdata[0]));

    if (isTargetVisible(limelightdata)) {
      
    } else {
      drive.tankDrive(0,0);
    }

    SmartDashboard.putBoolean("TargetVisible", isTargetVisible(limelightdata));
    SmartDashboard.putNumber("LimelightX",limelightdata[0]);
    SmartDashboard.putNumber("LimelightY",limelightdata[1]);
    SmartDashboard.putNumber("LimelightArea", limelightdata[2]);
    System.out.println("Executing DriveToHatch");
    SmartDashboard.putNumber("Distance to target", Robot.limelight.getDistance());
    SmartDashboard.putNumber("Target Angle", Robot.limelight.getAngle());
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    // System.out.println("isFinished(); on exampleCommand")
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

