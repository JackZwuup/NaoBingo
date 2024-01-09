package Bingo;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.*;

public class Default {
    public Application application;
    private ALAudioDevice alAudioDevice;
    private String name;



    public Default(Application application) {
        this.application = application;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String defaultFunctions(int volume) {

        try {
            this.alAudioDevice = new ALAudioDevice(this.application.session());
            this.alAudioDevice.setOutputVolume(volume);
        } catch (Exception e) {
            System.out.println("AudioDevice has " + e.getMessage());
        }

//        try {
//            new ReadBingoCard(this.application).setDetectionAllowed(false);
//        } catch (Exception e) {
//            System.out.println("Set bingo card to false" + e.getMessage());
//        }

        try {
            ALRobotPosture robotPost = new ALRobotPosture(this.application.session());
// Die gebruikt een applicatie van ALRobotPosture.
            robotPost.goToPosture("Stand", 0.5f);
// Crouch is al gedefinieërd. Daar kan je de posture van stelen(gebruiken).
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

// White eyes.
        try {
            ALLeds eyeProxy = new ALLeds(this.application.session());
            eyeProxy.fadeRGB("FaceLeds", 0x00ffffff, 1.0f);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            this.name = "Terminator";
            ALSystem alSystem = new ALSystem(this.application.session());
            alSystem.setRobotName(name);
            ALMemory alMemory = new ALMemory(this.application.session());
            alMemory.subscribeToEvent("ALSystem/RobotNameChanged", o -> {
                setName(this.name);
                getName();
                System.out.println(getName());

            });
        } catch (Exception e) {
            System.out.println("Change name" + e.getMessage());
        }
        System.out.println(name);
        return name;
    }
    }




