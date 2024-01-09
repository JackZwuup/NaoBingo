package Bingo.BRoundTwoThreeZero;

import Bingo.BingoNumberGenerator;
import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALMotion;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkillThreeMoveArmsHead {
    private Application application;

    public SkillThreeMoveArmsHead(Application application) {
        this.application = application;
    }

    public void thatsWrong() {

        try {
            ALMotion robotPosture;
            robotPosture = new ALMotion(this.application.session());

            ALRobotPosture robotPost = new ALRobotPosture(this.application.session());
// Die gebruikt een applicatie van ALRobotPosture.
            robotPost.goToPosture("Crouch", 0.5f);
// Crouch is al gedefinieërd. Daar kan je de posture van stelen(gebruiken).

            List<String> arms = new ArrayList<>(Arrays.asList("LShoulderRoll", "RShoulderRoll"));
            List<Double> angleList = new ArrayList<>(Arrays.asList(Math.PI / -2, Math.PI / 2));
            List<String> setDefault = new ArrayList<>(Arrays.asList("HeadYaw"));
            List<String> setDefaultArms = new ArrayList<>(Arrays.asList("LShoulderRoll", "RShoulderRoll", "LShoulderPitch"));

            for (int i = 0; i < 2; i++) {
                robotPosture.angleInterpolation("HeadYaw", Math.PI / 4, 1.0f, true);
                robotPosture.angleInterpolation("HeadYaw", Math.PI / -4, 1.0f, true);
            }

            robotPosture.angleInterpolation(setDefault, 0, 0.5f, true);

            robotPosture.angleInterpolation("LShoulderPitch", Math.PI / 4, 1.0f, true);
            robotPosture.angleInterpolation(arms, angleList, 1.0f, true);

            robotPosture.angleInterpolation(setDefaultArms, 0, 1.0f, true);
        } catch (Exception e) {
            System.out.println("That's wrong movement" + e.getMessage());
        }

    }

    public void thatsRight() {

        try {
            ALMotion robotPosture;
            robotPosture = new ALMotion(this.application.session());

            String[] names = {"HeadYaw", "HeadPitch"};

            List<String> head = new ArrayList<>(Arrays.asList("HeadPitch"));
            List<String> bothHands = new ArrayList<>(Arrays.asList("RShoulderPitch", "LShoulderPitch"));
            List<String> setDefault = new ArrayList<>(Arrays.asList("HeadPitch", "LShoulderRoll"));
            List<Double> headDegree = new ArrayList<>(Arrays.asList(Math.PI / 4, Math.PI / 2));

            for (int i = 0; i < 2; i++) {
                robotPosture.angleInterpolation("HeadPitch", Math.PI / 4, 0.7f, true);
                robotPosture.angleInterpolation("HeadPitch", Math.PI / -16, 0.7f, true);
            }
            robotPosture.angleInterpolation(bothHands, Math.PI / 10, 2.0f, true);

            robotPosture.angleInterpolation(setDefault, 0, 1.0f, true);
        } catch (Exception e) {
            System.out.println("That's right movement: " + e.getMessage());
        }
    }

    public int randomMovement() {
        int randomNumber = new BingoNumberGenerator().RandomTwoActivityGenerator() + 1;
        switch (randomNumber) {
            case 1:
                thatsWrong();
                break;
            case 2:
                thatsRight();
                break;
        }

        return 2;
    }
}
