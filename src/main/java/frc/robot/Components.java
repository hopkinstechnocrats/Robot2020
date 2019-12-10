package frc.robot;

import java.util.HashMap;
import frc.robot.logger.Status; //still needs to be implemented
import frc.components.Component;

public class Components {
    private HashMap<String,Component> components;

    public Components() {
        
        //instantiate components from frc.components.* here
    }

    private addComponent(Component component){
        components.put(component.name, component)
    }
    
    public Status checkComponents (){
        //return status of each components
    }

    public Component getComponentByName(String name){
        return components.get(name);
    }

}