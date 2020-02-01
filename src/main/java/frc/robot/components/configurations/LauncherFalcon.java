/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.components.configurations;

import com.ctre.phoenix.motorcontrol.can.TalonFXConfiguration;

import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class LauncherFalcon {

    public static TalonFXConfiguration getConfiguration() {
        TalonFXConfiguration conf = new TalonFXConfiguration();
        conf.slot0.kP = Constants.LAUNCHER_KP;
        conf.slot0.kD = Constants.LAUNCHER_KD;
        conf.slot0.kI = Constants.LAUNCHER_KI;
        return conf;
    }

}
