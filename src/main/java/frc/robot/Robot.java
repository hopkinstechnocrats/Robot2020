/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriverVision;
import frc.robot.commands.autoroutines.DriveBackwards;
import frc.robot.commands.autoroutines.DriveBackwardsThenLaunchThreeBalls;
import frc.robot.commands.autoroutines.ShootThreeBalls;
import frc.robot.components.Limelight;
import frc.robot.components.Talon;
import frc.robot.subsystems.Climb;
import frc.robot.subsystems.Feed;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.LauncherAimingSubsystem;
import frc.robot.subsystems.TankDrive;
import frc.robot.targeting.vision.Camera;
import frc.robot.data.Constants;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static Components components = new Components();
  private static XboxController controller = new XboxController(0);
  private static XboxController operatorController = new XboxController(1);
  public static TankDrive tankDrive = new TankDrive((Talon)components.getComponent("LeftTalon1"), 
                                                    (Talon)components.getComponent("LeftTalon2"), 
                                                    (Talon)components.getComponent("RightTalon1"), 
                                                    (Talon)components.getComponent("RightTalon2"),
                                                    controller);
  public static Intake intake = new Intake((Talon)components.getComponent("IntakeMotor"), controller);
  public static Launcher launcher = new Launcher((Talon)components.getComponent("LauncherLeft"), (Talon)components.getComponent("LauncherRight"), controller);
  public static Feed feed = new Feed((Talon)components.getComponent("FeedMotor"), controller);
  public static Climb climb = new Climb((Talon)components.getComponent("ClimbMotor"), controller);
  public static LauncherAimingSubsystem launcherAimingSubsystem = new LauncherAimingSubsystem(Constants.LIMELIGHT_TARGET_X, (Camera)components.getComponent("Limelight"));
  public static OI oi = new OI(controller, operatorController);
  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<Command>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    ((Limelight)launcherAimingSubsystem.getSource()).setPipeline(1);
    m_chooser.addOption("DriveBackwards", new DriveBackwards(tankDrive));
    m_chooser.addOption("DriveBackwardsThenLaunchThreeBalls", new DriveBackwardsThenLaunchThreeBalls(launcher, feed, tankDrive));
    m_chooser.addOption("ThreeBallsFromStartingPosition", new ShootThreeBalls(launcher, feed));
    SmartDashboard.putData("Autonomous Routine", m_chooser);
    //tankDrive = new TankDrive((Talon)components.getComponent("leftTalon1"), (Talon)components.getComponent("leftTalon2"), (Talon)components.getComponent("rightTalon1"), (Talon)components.getComponent("rightTalon2"));
    // m_chooser.setDefaultOption("Default Auto", new ExampleCommand());
    // chooser.addOption("My Auto", new MyAutoCommand());
    // SmartDashboard.putData("Auto mode", m_chooser);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
    ((Limelight)launcherAimingSubsystem.getSource()).setPipeline(1);
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
    ((Limelight)launcherAimingSubsystem.getSource()).setPipeline(1);
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    // m_autonomousCommand = m_chooser.getSelected();
    m_autonomousCommand = new DriveBackwardsThenLaunchThreeBalls(launcher, feed, tankDrive);
    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */ 
  @Override 
  public void teleopPeriodic() {
    Scheduler.getInstance().run(); 
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}
