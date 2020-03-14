package frc.lib.logger;

public class SimpleStatus implements IStatus {

    String source;
    StatusType type;
    String message;

    public SimpleStatus(StatusType type, String message) {
        this.type = type;
        this.message = message;
    }

    @Override
    public String toString() {
        return "StatusType: " + this.type.toString() + " , Message: " + this.message;
    }

    @Override
    public String toJson() {
        return "{ \"Status Type\":\"" + this.type.toString() + "\",\n\"Message\":\"" + this.message + "\"";
    }

}