package Bingo.BRoundTwoThreeZero;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALRobotPosture;

import java.util.Random;

public class SkillTwoChangePositions {

    private boolean[] alreadyPassed = new boolean[7];

    public Application application;

    public SkillTwoChangePositions(Application application) {
        this.application = application;
        stand();
    }

    public int stand() {
        System.out.println("stand");
        try {
            ALRobotPosture robotPost = new ALRobotPosture(this.application.session());
// Die gebruikt een applicatie van ALRobotPosture.
            robotPost.goToPosture("Stand", 0.5f);
// Crouch is al gedefinieërd. Daar kan je de posture van stelen(gebruiken).
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 1;
    }

    public int crouch() {
        System.out.println("crouch");
        try {
            ALRobotPosture robotPost = new ALRobotPosture(this.application.session());
// Die gebruikt een applicatie van ALRobotPosture.
            robotPost.goToPosture("Crouch", 0.5f);
// Crouch is al gedefinieërd. Daar kan je de posture van stelen(gebruiken).
        } catch (Exception e) {
            System.out.println("Crouch: " + e.getMessage());
        }
        return 2;
    }

    public int sit() {
        try {
            System.out.println("sit");

            ALRobotPosture robotPost = new ALRobotPosture(this.application.session());
// Die gebruikt een applicatie van ALRobotPosture.
            robotPost.goToPosture("Sit", 0.5f);
// Crouch is al gedefinieërd. Daar kan je de posture van stelen(gebruiken).
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }


    public int sitRelax() {
        System.out.println("Relax sit");
        try {
            ALRobotPosture robotPost = new ALRobotPosture(this.application.session());
// Die gebruikt een applicatie van ALRobotPosture.
            robotPost.goToPosture("SitRelax", 0.5f);
// Crouch is al gedefinieërd. Daar kan je de posture van stelen(gebruiken).
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 3;
    }

    public int standInit() {
        System.out.println("Stand Init");
        try {
            ALRobotPosture robotPost = new ALRobotPosture(this.application.session());
// Die gebruikt een applicatie van ALRobotPosture.
            robotPost.goToPosture("StandInit", 0.2f);
// Crouch is al gedefinieërd. Daar kan je de posture van stelen(gebruiken).
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 4;
    }

    public int standZero() {
        System.out.println("stand zero");
        try {
            ALRobotPosture robotPost = new ALRobotPosture(this.application.session());
// Die gebruikt een applicatie van ALRobotPosture.
            robotPost.goToPosture("StandInit", 0.2f);
// Crouch is al gedefinieërd. Daar kan je de posture van stelen(gebruiken).
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return 5;
    }

    public void generateRandomPositions() {
        Random randomGenerator = new Random();


        for (int i = 0; i < 2; i++) {
            int random = randomGenerator.nextInt(7) + 1;
            if (random == 1) {
                stand();
            } else if (random == 2) {
                sit();
            } else if (random == 3) {
                sitRelax();
            } else if (random == 4) {
                crouch();
            } else if (random == 5) {
                standInit();
            } else if (random == 6) {
                standZero();

            }

            stand();


        }

    }
}
