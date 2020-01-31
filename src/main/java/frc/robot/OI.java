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
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.*;
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public XboxController controller;
  POVButton up = new POVButton(controller, 0);
  POVButton upLeft = new POVButton(controller, 45);
  POVButton left = new POVButton(controller, 90);
  POVButton downLeft = new POVButton(controller, 135);
  POVButton down = new POVButton(controller, 180);
  POVButton downRight = new POVButton(controller, 225);
  POVButton right = new POVButton(controller, 270);
  POVButton upRight = new POVButton(controller, 315);
  JoystickButton aButton;
  JoystickButton bButton;
  JoystickButton xButton;
  JoystickButton yButton;
  JoystickButton leftBumper;
  JoystickButton rightBumper;

  public OI(XboxController controller){

    this.controller = controller;
    aButton = new JoystickButton(controller, 1);
    bButton = new JoystickButton(controller, 2);
    xButton = new JoystickButton(controller, 3);
    yButton = new JoystickButton(controller, 4);
    leftBumper = new JoystickButton(controller, 5);
    rightBumper = new JoystickButton(controller, 6);
    aButton.whenPressed(new DriveMotionProfile("testpath", Robot.tankDrive));
    leftBumper.whileHeld(new IntakeBall(Robot.intake));
    rightBumper.whileHeld(new LauncherWheels(Robot.launcher, -.65));
    bButton.whileHeld(new LauncherWheels(Robot.launcher, -.5));
    xButton.whileHeld(new LauncherWheels(Robot.launcher, -.55));
    yButton.whileHeld(new LauncherWheels(Robot.launcher, -.6));



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
