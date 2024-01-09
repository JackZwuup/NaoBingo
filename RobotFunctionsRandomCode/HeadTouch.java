package Bingo.RobotFunctionsRandomCode;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALMemory;

public class HeadTouch {

    private Application application;
    private boolean isTouchedStatus;

    public HeadTouch(Application application) {
        this.application = application;
    }

    public boolean HeadIsTouched() {
        try {
            ALMemory alMemory = new ALMemory(this.application.session());
            alMemory.subscribeToEvent("FrontTactilTouched", o -> {
                this.isTouchedStatus = !Boolean.parseBoolean(o.toString());
                setIsTouchedStatus(this.isTouchedStatus);
                System.out.println(isTouchedStatus);
            });
        } catch (Exception e) {
            System.out.println("HeadisTouched " + e.getMessage());
        }
        return getIsTouchedStatus();
    }

    public boolean getIsTouchedStatus() {
        return isTouchedStatus;
    }

    public void setIsTouchedStatus(boolean objectStatus) {
            this.isTouchedStatus = objectStatus;
        }


}

