/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.components;

import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.logger.Status;
import frc.robot.logger.StatusType;

/**
 * Add your docs here.
 */
public class LinearActuator extends Component {

    private Solenoid hardwareSolenoid;
    private boolean state;

    public LinearActuator(int id, boolean defaultState) {
        this.hardwareSolenoid = new Solenoid(id);
        this.state = defaultState;
    }

    public void initialize() {
        this.hardwareSolenoid.set(state);
    }

    public void toggleState() {
        this.state = !this.state;
        this.hardwareSolenoid.set(this.state);
    }

    public Status getStatus(){
        return new Status(StatusType.LOG, "Example Limelight Log Message");
    }

}
