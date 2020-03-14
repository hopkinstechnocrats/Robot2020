/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.lib.control;

import frc.robot.data.Dataset;

/**
 * Generic interpolator, meant to be subclassed
 */
public abstract class Interpolator {

    protected Dataset dataset;

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

    public abstract double get(double xvalue) throws Exception;

}
