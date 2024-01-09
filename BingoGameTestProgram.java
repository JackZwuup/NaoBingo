package Bingo;

import Bingo.ARoundOneFiveTen.BeginningSentences;
import Bingo.BRoundTwoThreeZero.SkillBase;
import Bingo.RobotFunctionsRandomCode.HeadTouch;
import Bingo.RobotFunctionsRandomCode.NaoSpeech;
import Bingo.RobotFunctionsRandomCode.NaoVerbind;
import Bingo.RobotFunctionsRandomCode.ReadBingoCard;
import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALSpeechRecognition;

public class BingoGameTestProgram {
    private static ALSpeechRecognition alSpeechRecognition;
    private static Application application;

    // To reset the code.
    public static void main(String[] args) throws Exception {
        run();
    }


    public static void run() throws Exception {
        NaoVerbind naoVerbind = new NaoVerbind();

        application = naoVerbind.verbind("Simon.local", 9559);

        BeginningSentences beginningSentences = new BeginningSentences();
        HeadTouch headTouch = new HeadTouch(application);
        Default defaulth = new Default(application);
        BingoGame game = new BingoGame();
        ReadBingoCard scanBingo = new ReadBingoCard(application);
        NaoSpeech naoSpeech = new NaoSpeech(application);
        SkillBase skillBase = new SkillBase(application);

        final int ZERO = 0;
        final int ONE = 1;
        final int FIVETEN = 15;
        final int SIXTEN = 16;
        final int SEVENFIVE = 75;

        int ballsRead = 0;
        int cardNumber = 0;

        defaulth.defaultFunctions(50);

        naoSpeech.animatedSpeech("Hello. ^start(animations/Stand/Gestures/Hey_1)I'm nao. Nice to meet you! ", "English");

//        naoSpeech.animatedSpeech("We gaan ^start(animations/Stand/Exclamation/NAO/Center_Strong_EXC_09access_robot_settings_nao", "Dutch") bingo spelen met elkaar");
//        naoSpeech.animatedSpeech("^start(animations/Stand/Gestures/YouKnowWhat_1access_robot_settings_nao) Luister goed naar de nummers en als u bingo hebt laat u mij uw kaart zien");
        naoSpeech.speakInLanguage("English");
//        naoSpeech.animatedSpeech(" ^start(animations/Stand/Gestures/YouKnowWhat_1access_robot_settings_nao) Listen closely to the numbers and if you have bingo show me your card please. Lets begin");

// Explain in dutch than in English how the game works.


// Repeat generating balls, until all is read.
        do {
            ballsRead++;

            headTouch.HeadIsTouched();
            if (headTouch.getIsTouchedStatus()) {
                naoSpeech.talking("Dit was het dan, bedankt voor het spelen", "Dutch");
                naoSpeech.talking("It was nice playing with you", "English");
                System.exit(0);
            }
            ;

            int ball;
// Generate ball, until a new one is found.
            do {
                scanBingo.setDetectionAllowed(true);
                ball = game.generateNumber();
            }
            while (game.isNumberRead(ball));

            System.out.println();
            System.out.printf("%d: Number of ball = %d \n", ballsRead, ball);

////TODO: Read number out loud. First in dutch, than in english. This works!

// Making sure to film the robot, so you can decide on the animation.
// Say the number of the ball in dutch afterwards in english

//            naoSpeech.animatedSpeech("^start(animations/Stand/Exclamation/NAO/Right_Neutral_EXC_05access_robot_settings_nao)Bal nummer " + ball, "Dutch");

//            Thread.sleep(1000);

            naoSpeech.speakInLanguage("English");
//            naoSpeech.talking(Integer.toString(ball), "English");

//            Thread.sleep(2000);

// Set ball read. Store the number.
            game.setNumberRead(ball);

            scanBingo.barcodeEventTest();

            cardNumber = scanBingo.barcodeEventTest();
            System.out.println(cardNumber);


            if (cardNumber > ZERO && game.ifCardIsCorrect(cardNumber)) {
                System.out.println("Gefeliciteerd, Je hebt bingo!");
                naoSpeech.talking("Gefeliciteerd kaart nummer: "+ cardNumber + " Je hebt bingo!, raak mijn hoofd aan om af te sluiten", "Dutch");


            } else if (cardNumber > ZERO) {
                naoSpeech.speakInLanguage("English");
                naoSpeech.talking("Kaart nummer: "+ cardNumber + " You cheater! What do you think you're doing?", "English");
                scanBingo.setLastReadCard(0);
            }

            scanBingo.setDetectionAllowed(false);

            Object yes = beginningSentences.randomSentences();

            if (ballsRead == 15 & beginningSentences.isDutch()) {
                naoSpeech.talking((String) yes, "Dutch");
            } else if (ballsRead == 15){
                naoSpeech.talking((String) yes, "English");
            }

            if (ballsRead == 30) {
                naoSpeech.animatedSpeech("Kijk eens naar wat ik kan", "Dutch");
                naoSpeech.animatedSpeech("See what I can do", "English");

                skillBase.randomSkills();

            }

            if (ballsRead == 45) {
                int quotes = (int)(Math.random() * 3);

//TODO: English quotes
            }

            for (int i = 0; i < SIXTEN; i++) {
                if (game.ifCardIsCorrect(i)) {
                    System.out.printf("Card %d has bingo \n", i);
                }
            }
        }
        while (!game.ifAllNumbersRead());

        System.out.println("Game is done!");
    }

}