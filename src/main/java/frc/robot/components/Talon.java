package frc.robot.components;
import com.ctre.phoenix.motion.BufferedTrajectoryPointStream;
import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.logger.Status;
import frc.robot.logger.StatusType;
import frc.robot.motionprofiling.MotionProfile;
import edu.wpi.first.wpilibj.SpeedController;

import java.io.IOException;
import java.util.*;

public class Talon extends Component implements SpeedController{

    WPI_TalonSRX hardwareTalon;
    HashMap<String, MotionProfile> motionProfiles = new HashMap<String, MotionProfile>();

    public Talon(int id){
        hardwareTalon = new WPI_TalonSRX(id);
        hardwareTalon.configFactoryDefault();
    }

    public void setPercentOutput(double percentoutput) {
        hardwareTalon.set(ControlMode.PercentOutput, percentoutput);
    }

    public void set(double percentoutput){
        setPercentOutput(percentoutput);
    }

    public double get(){
        return hardwareTalon.get();
    }

    public void disable(){
        hardwareTalon.disable();
    }

    public void stopMotor(){
        hardwareTalon.stopMotor();
    }

    public void pidWrite(double x){
        hardwareTalon.pidWrite(x);
    }

    public void setInverted(boolean isInverted){
        hardwareTalon.setInverted(isInverted);
    }

    public boolean getInverted(){
        return hardwareTalon.getInverted();
    }

    public Status getStatus(){
        return new Status(StatusType.LOG, "Example Talon Log Message");
    }

    public boolean loadMotionProfile(String name, String ProfilePath) throws IOException{
        MotionProfile mp = new MotionProfile(ProfilePath);
        loadMotionProfile(name, mp);
        return true;
    }

    public boolean loadMotionProfile(String name, MotionProfile mp) throws IOException{
        motionProfiles.put(name, mp);
        return true;
    }
    public void startMotionProfile(String name){
        MotionProfile mp =  motionProfiles.get(name);
        hardwareTalon.startMotionProfile(mp.getBufferedTrajectoryPointStream(), 5, ControlMode.MotionProfile);
    }
    public void cancelMotionProfile(){
        this.set(0);
    }
    public boolean isMotionProfileFinished(){
        return hardwareTalon.isMotionProfileFinished();
    }
    public MotionProfileStatus getMotionProfileStatus(){
        MotionProfileStatus tempstatus = new MotionProfileStatus();
        hardwareTalon.getMotionProfileStatus(tempstatus);
        return tempstatus;
    }

}
