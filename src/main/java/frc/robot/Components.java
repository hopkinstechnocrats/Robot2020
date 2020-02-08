package frc.robot;

import java.util.HashMap;
import frc.robot.logger.Status; //still needs to be implemented
import frc.robot.components.Component;
import frc.robot.components.Limelight;
import frc.robot.components.Talon;
import java.util.ArrayList;

public class Components {
    private HashMap<String,Component> components;

    public Components() {
        components = new HashMap<String, Component>();
        addComponent("LeftTalon1", new Talon(1));
        addComponent("LeftTalon2", new Talon(2));
        addComponent("RightTalon1", new Talon(3));
        addComponent("RightTalon2", new Talon(4));
        addComponent("LauncherLeft", new Talon(5));
        addComponent("LauncherRight", new Talon(6));
        addComponent("IntakeMotor", new Talon(7));
        addComponent("FeedMotor", new Talon(8));
        addComponent("Limelight", new Limelight());

    }
    

    private void addComponent(String name, Component component){
        components.put(name, component);
    }
    
    public ArrayList<Status> checkComponents(){
        ArrayList<Status> compstatuses = new ArrayList<Status>();
        for (Component comp : components.values()) {
            compstatuses.add(comp.getStatus());
        }
        return compstatuses;
    }

    public Component getComponent(String name){
        
        // try {
            return components.get(name);
        // }
        // catch (Exception e) {
        //     System.out.println("Components doesn't include \""+name+"\"");

        // }

    }

}