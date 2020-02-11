/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.ButtonMonitor;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public XboxController controller;
  public XboxController operatorController;
  POVButton up;
  POVButton upLeft;
  POVButton left;
  POVButton downLeft;
  POVButton down;
  POVButton downRight;
  POVButton right;
  POVButton upRight;
 
  JoystickButton aButton;
  JoystickButton bButton;
  JoystickButton xButton;
  JoystickButton yButton;
  JoystickButton leftBumper;
  JoystickButton rightBumper;
  JoystickButton rightStick;
  JoystickButton leftStick;

  JoystickButton operatorAbutton;
  JoystickButton operatorBbutton;
  JoystickButton operatorXbutton;
  JoystickButton operatorYbutton;
  JoystickButton operatorLeftBumper;
  JoystickButton operatorRightBumper;
  JoystickButton operatorBackButton;
  JoystickButton operatorStartButton;
  JoystickButton operatorLeftStick;
  JoystickButton operatorRightStick;


  public OI(XboxController controller, XboxController operatorController){

    this.controller = controller;
    this.operatorController = operatorController;
    up = new POVButton(controller, 0);
    upLeft = new POVButton(controller, 45);
    left = new POVButton(controller, 90);
    downLeft = new POVButton(controller, 135);
    down = new POVButton(controller, 180);
    downRight = new POVButton(controller, 225);
    right = new POVButton(controller, 270);
    upRight = new POVButton(controller, 315);
    aButton = new JoystickButton(controller, 1);
    bButton = new JoystickButton(controller, 2);
    xButton = new JoystickButton(controller, 3);
    yButton = new JoystickButton(controller, 4);
    leftBumper = new JoystickButton(controller, 5);
    rightBumper = new JoystickButton(controller, 6);
    rightStick = new JoystickButton(controller, 10);
    leftStick = new JoystickButton(controller, 9);
    operatorAbutton = new JoystickButton(operatorController, 1);
    operatorBbutton = new JoystickButton(operatorController, 2);
    operatorXbutton = new JoystickButton(operatorController, 3);
    operatorYbutton = new JoystickButton(operatorController, 4);
    operatorLeftBumper = new JoystickButton(operatorController, 5);
    operatorRightBumper = new JoystickButton(operatorController, 6);
    operatorBackButton = new JoystickButton(operatorController, 7);
    operatorStartButton = new JoystickButton(operatorController, 8);
    operatorLeftStick = new JoystickButton(operatorController, 9);
    operatorRightStick = new JoystickButton(operatorController, 10);
    operatorAbutton.whenPressed(new DriveMotionProfile("testpath", Robot.tankDrive));
    operatorLeftBumper.whileHeld(new IntakeBall(Robot.intake));
    operatorRightBumper.whileHeld(new SpinLauncher(Robot.launcher, Constants.LAUNCHER_WHEELS_ENCODER_SPEED));
    operatorBackButton.whileHeld(new SpinLauncher(Robot.launcher, SmartDashboard.getNumber("LauncherSpeed", 0)));
    operatorBbutton.whileHeld(new TurnToTape(Robot.launcherAimingSubsystem, Robot.tankDrive));
    up.whenPressed(new SetDriveSpeed(Robot.tankDrive, .8));
    right.whenPressed(new SetDriveSpeed(Robot.tankDrive, .65));
    down.whenPressed(new SetDriveSpeed(Robot.tankDrive, .5));
    left.whenPressed(new SetDriveSpeed(Robot.tankDrive, .35));
    operatorRightStick.whileHeld(new FeedBall(Robot.feed, Constants.FEED_WHEELS_SPEED));
    operatorLeftStick.whileHeld(new FeedBall(Robot.feed, -Constants.FEED_WHEELS_SPEED));
    aButton.whenPressed(new DriveMotionProfile("testpath", Robot.tankDrive));
    leftBumper.whileHeld(new IntakeBall(Robot.intake));
    rightBumper.whileHeld(new SpinLauncher(Robot.launcher, Constants.LAUNCHER_WHEELS_ENCODER_SPEED));
    


    // up.whenPressed(new SetDriveSpeed(1.0));
    // left.whenPressed(new SetDriveSpeed(.75));
    // down.whenPressed(new SetDriveSpeed(.5));
    // right.whenPressed(new SetDriveSpeed(.25));

  }

  public XboxController getXboxController(){
    return controller;
  }
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
