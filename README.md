# Robot2020

This is the code used in FRC Team 2239, The Technocrats' 2020 Robot.

## Package Description
- `frc.robot`: Contains central classes such as `Main`, `Robot`, `OI`, and `Components`
- `frc.robot.subsystems`: Contains subsystems of the robot that extend the class `Subsystem`
- `frc.robot.commands`: Contains commands used to describe time-dependent subsystem behavior and extend the class `Command`
- `frc.robot.motion`: Contains classes extending `Movement` that contain simple drivetrain actions with no time-dependent behavior. Classes in this package are primarily used by classes in `frc.robot.targeting`
- `frc.robot.logger`: Work in progress that is currently not being used.
- `frc.robot.data`: Contains any numerical data that is tuned for the robot. Most data is stored in `frc.robot.data.Constants`
- `frc.robot.components`: Contains component classes extending `Component` that encapsulate specific pieces of robot hardware and implement game-independent functions.
- `frc.robot.targeting`: Translates camera input into drivetrain actions to accurately move the robot to a desired position
- `frc.robot.motionprofiling`: Takes Motion Profiles from PathWeaver's CSV format and prepares them for use by the Talon FX's Motion Profile Executor
