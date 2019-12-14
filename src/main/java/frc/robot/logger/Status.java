package frc.robot.logger;

public class Status {
    
    String source;
    StatusType type;
    String message;

    public Status(StatusType type, String message){
        this.type = type;
        this.message = message;
    }

}
