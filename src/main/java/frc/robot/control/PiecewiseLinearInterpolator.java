/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.control;

/**
 * Returns a value based on the line through the two surrounding data points
 */
public class PiecewiseLinearInterpolator extends Interpolator {

    public double get(double xvalue) throws Exception {
        double [][] nearPoints = getNearPoints(xvalue);
        double [][] zeroPoints = {{0d,0d},{0d,0d}};
        if (nearPoints == zeroPoints) {
            throw new Exception("xvalue out of range of dataset");
        }
        double slope = (nearPoints[1][1]-nearPoints[0][1])/(nearPoints[1][0]-nearPoints[0][1]);
        //return the launcher speed estimated by the line between the two closest points in the tuned dataset
        return (nearPoints[0][1]+slope*(xvalue-nearPoints[0][0]));
    }

    private double[][] getNearPoints(double xvalue) {
        double[] beforePoint = {0d,0d};
        double[] afterPoint = {0d,0d};
        double[][] blankReturnValue = {beforePoint, afterPoint};
        //if we are too close, or are too far to shoot, return a blank point
        if (xvalue < dataset.get(0)[0] || xvalue > dataset.get(dataset.getLength()-1)[0]) {
            return blankReturnValue;
        }
        //find the launcher speed that is associated with the closest tuned distance in the dataset
        for (int i = 1; i < dataset.getLength(); i++) {
            if (xvalue < dataset.get(i)[0]){
                beforePoint = dataset.get(i-1);
                afterPoint = dataset.get(i);
                break;
            }
        }
        double[][] returnValue = {beforePoint, afterPoint};
        //return the point below and above the observed distance in dataset
        return returnValue;
    }   

}
