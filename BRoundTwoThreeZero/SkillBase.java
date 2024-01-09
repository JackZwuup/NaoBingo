package Bingo.BRoundTwoThreeZero;

import com.aldebaran.qi.Application;

import java.util.Random;

public class SkillBase {
    public SkillBase(Application application) {
        this.application = application;
    }

    private Application application;

    public void randomSkills() {
        Random randomGenerator = new Random();
        int random = randomGenerator.nextInt(3) + 1;

        System.out.println(random);
        switch (random) {
            case 1:
                new SkillOneChangingEyeColor(this.application).generateRandomEyeColour();
                break;
            case 2:
                new SkillThreeMoveArmsHead(this.application).randomMovement();
                break;
            case 3:
                new SkillTwoChangePositions(this.application).generateRandomPositions();
                break;

        }



    }
}
