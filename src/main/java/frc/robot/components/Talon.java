package frc.robot.components;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.motion.MotionProfileStatus;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FollowerType;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

import frc.robot.components.configurations.DrivetrainFalcon;
import frc.robot.components.configurations.LauncherFalcon;
//import frc.lib.logger.Status;
import frc.lib.logger.StatusType;
import frc.lib.motionprofiling.MotionProfile;
import edu.wpi.first.wpilibj.SpeedController;

import java.io.IOException;
import java.util.*;

public class Talon extends Component implements SpeedController{

    public WPI_TalonFX hardwareTalon;
    public double lastPercentoutput = 0;
    HashMap<String, MotionProfile> motionProfiles = new HashMap<String, MotionProfile>();

    public Talon(int id){
        hardwareTalon = new WPI_TalonFX(id);
        hardwareTalon.configFactoryDefault();
    }

    public void setPercentOutput(double percentoutput) {
        hardwareTalon.set(ControlMode.PercentOutput, percentoutput);
    }

    public void set(double percentoutput){
        if(!(percentoutput == lastPercentoutput)){
            setPercentOutput(percentoutput);
        }
        lastPercentoutput = percentoutput;
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

//    public Status getStatus(){
//        return new Status(StatusType.LOG, "Example Talon Log Message");
//    }

    public boolean loadMotionProfile(String name, String ProfilePath) throws IOException{
        return loadMotionProfile(name, ProfilePath, false);
    }

    public boolean loadMotionProfile(String name, String ProfilePath, boolean isInverted) throws IOException{
        MotionProfile mp = new MotionProfile(ProfilePath, isInverted);
        loadMotionProfile(name, mp);
        return true;
    }

    public boolean loadMotionProfile(String name, MotionProfile mp) throws IOException{
        motionProfiles.put(name, mp);
        return true;
    }

    public void startMotionProfile(String name){
        MotionProfile mp =  motionProfiles.get(name);
        ErrorCode error = hardwareTalon.startMotionProfile(mp.getBufferedTrajectoryPointStream(), 50, ControlMode.MotionProfile);
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

    public void follow(Talon master) {
        hardwareTalon.follow(master.hardwareTalon, FollowerType.PercentOutput);
    }
    
    public void clearOldMotionProfiles() {
        hardwareTalon.clearMotionProfileHasUnderrun();
        hardwareTalon.clearMotionProfileTrajectories();
    }

    public void configureDrivetrainFalcon() {
        hardwareTalon.configAllSettings(DrivetrainFalcon.getConfiguration());
    }

    public void configureLauncherFalcon() {
        hardwareTalon.configAllSettings(LauncherFalcon.getConfiguration());
    }

    public void zeroEncoder() {
        hardwareTalon.setSelectedSensorPosition(0);
    }

    public void setClosedLoopVelocity(double speed) {
        hardwareTalon.set(ControlMode.Velocity, speed);
    }

    public int getEncoderSpeed() {
        return hardwareTalon.getSelectedSensorVelocity();
    }

    public void feed() {
        hardwareTalon.feed();
    }
}
