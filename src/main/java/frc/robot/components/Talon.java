package frc.robot.components;
import com.ctre.phoenix.motion.BufferedTrajectoryPointStream;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.logger.Status;
import frc.robot.logger.StatusType;
import edu.wpi.first.wpilibj.SpeedController;
import java.util.*;

public class Talon extends Component implements SpeedController{

    WPI_TalonSRX hardwareTalon;
    HashMap<String, BufferedTrajectoryPointStream> motionProfiles = new HashMap<String, BufferedTrajectoryPointStream>();
    

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

    public boolean loadMotionProfile(String ProfilePath){
        try{
            
        }
        catch(Exception e){
            return false;
        }
        return true;
    }
}
