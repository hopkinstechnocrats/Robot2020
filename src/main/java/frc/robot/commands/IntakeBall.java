/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.TankDrive;
import edu.wpi.first.wpilibj.buttons.POVButton;
import frc.robot.data.Constants;
import frc.robot.Robot;

public class IntakeBall extends Command {

  TankDrive drivetrain;
  double deadband;
  boolean isFlipped;
  boolean isSquared;
  XboxController controller;
  POVButton up;
  POVButton upLeft;
  POVButton left;
  POVButton downLeft;
  POVButton down;
  POVButton downRight;
  POVButton right;
  POVButton upRight;
  Intake subsystem;
  boolean inverted;

  public IntakeBall(Intake intake, boolean inverted) {
    // Use requires() here to declare subsystem dependencies
    requires(intake);
    this.subsystem = intake;
    this.inverted = inverted;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    subsystem.runIntake(inverted);
  }
  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
