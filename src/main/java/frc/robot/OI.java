/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
import frc.robot.data.Constants;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public XboxController controller;
  public XboxController operatorController;
  //ordered from 0->315, 45 increment
  POVButton up;
  POVButton upLeft;
  POVButton left;
  POVButton downLeft;
  POVButton down;
  POVButton downRight;
  POVButton right;
  POVButton upRight;
  //ordered from 0->315, 45 increment
  POVButton operatorUp;
  POVButton operatorUpLeft;
  POVButton operatorLeft;
  POVButton operatorDownLeft;
  POVButton operatorDown;
  POVButton operatorDownRight;
  POVButton operatorRight;
  POVButton operatorUpRight;
  //ordered from ID 1->10
  JoystickButton aButton;
  JoystickButton bButton;
  JoystickButton xButton;
  JoystickButton yButton;
  JoystickButton leftBumper;
  JoystickButton rightBumper;
  JoystickButton backButton;
  JoystickButton startButton;
  JoystickButton leftStick;
  JoystickButton rightStick;
  //ordered from ID 1->10
  JoystickButton operatorAButton;
  JoystickButton operatorBButton;
  JoystickButton operatorXButton;
  JoystickButton operatorYButton;
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
    upRight = new POVButton(controller, 45);
    right = new POVButton(controller, 90);
    downRight = new POVButton(controller, 135);
    down = new POVButton(controller, 180);
    downLeft = new POVButton(controller, 225);
    left = new POVButton(controller, 270);
    upLeft = new POVButton(controller, 315);

    operatorUp = new POVButton(operatorController, 0);
    operatorUpRight = new POVButton(operatorController, 45);
    operatorRight = new POVButton(operatorController, 90);
    operatorDownRight = new POVButton(operatorController, 135);
    operatorDown = new POVButton(operatorController, 180);
    operatorDownLeft = new POVButton(operatorController, 225);
    operatorLeft = new POVButton(operatorController, 270);
    operatorUpLeft = new POVButton(operatorController, 315);

    aButton = new JoystickButton(controller, 1);
    bButton = new JoystickButton(controller, 2);
    xButton = new JoystickButton(controller, 3);
    yButton = new JoystickButton(controller, 4);
    leftBumper = new JoystickButton(controller, 5);
    rightBumper = new JoystickButton(controller, 6);
    backButton = new JoystickButton(controller, 7);
    startButton = new JoystickButton(controller, 8);
    leftStick = new JoystickButton(controller, 9);
    rightStick = new JoystickButton(controller, 10);

    operatorAButton = new JoystickButton(operatorController, 1);
    operatorBButton = new JoystickButton(operatorController, 2);
    operatorXButton = new JoystickButton(operatorController, 3);
    operatorYButton = new JoystickButton(operatorController, 4);
    operatorLeftBumper = new JoystickButton(operatorController, 5);
    operatorRightBumper = new JoystickButton(operatorController, 6);
    operatorBackButton = new JoystickButton(operatorController, 7);
    operatorStartButton = new JoystickButton(operatorController, 8);
    operatorLeftStick = new JoystickButton(operatorController, 9);
    operatorRightStick = new JoystickButton(operatorController, 10);


    aButton.whenPressed(new ExtendArm(Robot.intake));
    bButton.whileHeld(new SpinLauncher(Robot.launcher, Constants.CLOSE_LAUNCHER_WHEELS_ENCODER_SPEED));
    xButton.whileHeld(new TurnToTape(Robot.launcherAimingSubsystem, Robot.tankDrive));
    yButton.whileHeld(new TargetingVision(Robot.launcherAimingSubsystem));
    leftBumper.whileHeld(new IntakeBall(Robot.intake, false));
    rightBumper.whileHeld(new SpinLauncher(Robot.launcher, Constants.FAR_LAUNCHER_WHEELS_ENCODER_SPEED));
    backButton.whileHeld(new SpinClimb(Robot.climb, -Constants.CLIMB_WINCH_SPEED));
    startButton.whileHeld(new SpinClimb(Robot.climb, Constants.CLIMB_WINCH_SPEED));
    leftStick.whileHeld(new SpinClimb(Robot.climb, -.75));
    rightStick.whileHeld(new SpinClimb(Robot.climb, .75));

    up.whenPressed(new SetDriveSpeed(Robot.tankDrive, .8));
    right.whenPressed(new SetDriveSpeed(Robot.tankDrive, .65));
    down.whenPressed(new SetDriveSpeed(Robot.tankDrive, .5));
    left.whenPressed(new SetDriveSpeed(Robot.tankDrive, .35));
    


    operatorAButton.whileHeld(new SpinLauncher(Robot.launcher, Constants.CLOSE_LAUNCHER_WHEELS_ENCODER_SPEED));
    operatorBButton.whileHeld(new SpinLauncher(Robot.launcher, Constants.MEDIUM_LAUNCHER_WHEELS_ENCODER_SPEED));
    operatorXButton.whenPressed(new ExtendArm(Robot.intake));
    operatorYButton.whileHeld(new SpinLauncher(Robot.launcher, Constants.FAR_LAUNCHER_WHEELS_ENCODER_SPEED));
    operatorLeftBumper.whileHeld(new IntakeBall(Robot.intake, false));
    operatorRightBumper.whileHeld(new SpinLauncher(Robot.launcher, -12000));
    operatorBackButton.whileHeld(new IntakeBall(Robot.intake, true));
    operatorStartButton.whileHeld(new SpinLauncher(Robot.launcher, SmartDashboard.getNumber("LauncherSpeed", 0)));
    operatorLeftStick.whileHeld(new FeedBall(Robot.feed, true));
    operatorRightStick.whileHeld(new FeedBall(Robot.feed, false));

    operatorUp.whenPressed(new SetFeedSpeed(Robot.feed, 1));
    operatorRight.whenPressed(new SetFeedSpeed(Robot.feed, .7));
    operatorDown.whileHeld(new SpinClimb(Robot.climb, -Constants.CLIMB_WINCH_SPEED));
    operatorLeft.whileHeld(new SpinClimb(Robot.climb, Constants.CLIMB_WINCH_SPEED));

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
