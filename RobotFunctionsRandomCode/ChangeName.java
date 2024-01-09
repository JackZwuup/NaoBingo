package Bingo.RobotFunctionsRandomCode;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALSystem;

public class ChangeName {

    private Application application;

    public ChangeName() {

    }

    public boolean ChangeName(String name) {
        try {
            ALSystem alSystem = new ALSystem(this.application.session());
            alSystem.setRobotName(name);
            ALMemory alMemory = new ALMemory(this.application.session());
            alMemory.subscribeToEvent("ALSystem/RobotNameChanged", o -> {


            });
        } catch (Exception e) {
            System.out.println("Change name" + e.getMessage());
        }
        return false;
    }
}
