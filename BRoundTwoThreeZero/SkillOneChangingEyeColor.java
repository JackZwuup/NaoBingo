package Bingo.BRoundTwoThreeZero;

import Bingo.BingoNumberGenerator;
import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALLeds;

import java.util.Random;

public class SkillOneChangingEyeColor {


    public Application application;


    public SkillOneChangingEyeColor(Application application) {
        this.application = application;
    }

    public void eyeColourCollection() {
        try {
            ALLeds eyeProxy = new ALLeds(this.application.session());
            eyeProxy.rotateEyes(0x00999900, 2.0f, 2.0f);

        } catch (Exception e) {
            System.out.println("EyeLeds: ");
            ;
        }
    }

    public void eyeColourYellow() {
        try {
            ALLeds eyeProxy = new ALLeds(this.application.session());
            eyeProxy.rotateEyes(0x00999900, 2.0f, 2.0f);
        } catch (Exception e) {
            System.out.println("EyeLeds: ");
        }
    }

    public void eyeColourRed() {
        try {
            ALLeds eyeProxy = new ALLeds(this.application.session());
            eyeProxy.rotateEyes(0x00990000, 2.0f, 2.0f);
        } catch (Exception e) {
            System.out.println("EyeLeds: ");

        }
    }


    public void eyeColourOrange() {
        try {
            ALLeds eyeProxy = new ALLeds(this.application.session());
            eyeProxy.rotateEyes(0x00ff7900, 2.0f, 2.0f);
        } catch (Exception e) {
            System.out.println("EyeLeds: ");
        }
    }

    public void eyeColourWhite() {
        try {
            ALLeds eyeProxy = new ALLeds(this.application.session());
            eyeProxy.rotateEyes(0x00ffffff, 2.0f, 2.0f);
        } catch (Exception e) {
            System.out.println("EyeLeds: ");
        }
    }

    public void eyeColourGreen() {
        try {

            ALLeds eyeProxy = new ALLeds(this.application.session());
            eyeProxy.rotateEyes(0x00009900, 2.0f, 2.0f);
        } catch (Exception e) {
            System.out.println("EyeLeds: ");
        }
    }

    public void eyeColourDarkBlue() {
        try {
            ALLeds eyeProxy = new ALLeds(this.application.session());
            eyeProxy.rotateEyes(0x0000003f, 2.0f, 2.0f);
        } catch (Exception e) {
            System.out.println("EyeLeds: ");

        }
    }

    public void eyeColourLightBlue() {
        try {

            ALLeds eyeProxy = new ALLeds(this.application.session());
//        eyeProxy.rotateEyes(0x0072bcd4, 2.0f, 2.0f);
            eyeProxy.rotateEyes(0x0048a9a6, 2.0f, 2.0f);
        } catch (Exception e) {
            System.out.println("EyeLeds: ");
        }
    }

    public void eyeColourPurple() {
        try {

            ALLeds eyeProxy = new ALLeds(this.application.session());
            eyeProxy.rotateEyes(0x00793079, 2.0f, 2.0f);
        } catch (Exception e) {
            System.out.println("EyeLeds: ");

        }
    }

    public void eyeColourPink() {
        try {
            ALLeds eyeProxy = new ALLeds(this.application.session());
            eyeProxy.rotateEyes(0x00ff748c, 2.0f, 2.0f);
        } catch (Exception e) {
            System.out.println("EyeLeds: ");

        }
    }

    public void EyeColourT() {
        eyeColourLightBlue();
        eyeColourPink();
        eyeColourWhite();
        eyeColourPink();
        eyeColourLightBlue();
    }

    public void EyecolourG() {
        eyeColourRed();
        eyeColourOrange();
        eyeColourYellow();
        eyeColourGreen();
        eyeColourLightBlue();
        eyeColourDarkBlue();
        eyeColourPurple();
    }

    public void randomEyeColours() {
        int random = new BingoNumberGenerator().RandomSixActivityGenerator();

        switch (random) {
            case 1:
                eyeColourYellow();

            case 2:
                eyeColourPink();

            case 3:
                eyeColourRed();

            case 4:
                eyeColourPurple();

            case 5:
                eyeColourDarkBlue();

            case 6:
                eyeColourGreen();

        }
    }

    public int generateRandomEyeColour() {

        Random randomGenerator = new Random();

        int random = randomGenerator.nextInt(3) + 1;

        switch (random) {
            case 1:
                EyeColourT();
                break;
            case 2:
                EyecolourG();
                break;
            case 3:
                randomEyeColours();
                break;
        }

        return 1;
    }


}

