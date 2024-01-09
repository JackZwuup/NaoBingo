package Bingo.ARoundOneFiveTen;

import Bingo.BingoNumberGenerator;
import Bingo.RobotFunctionsRandomCode.NaoSpeech;
import Bingo.RobotFunctionsRandomCode.NaoVerbind;
import com.aldebaran.qi.Application;

import java.util.Objects;

public class BeginningSentences {

    boolean dutch;

    public String dutchSentences() {


        String[] comingBy = {"Hebben  jullie  het  een  beetje  naar  jullie  zin? Haha  ik  ook",
                "Ik  hoop  dat  jullie  goed  hebben  opgelet, want  ik  herhaal  de  getallen  alleen  maar  1  keer",
                "Het  zal  fijn  zijn  als  jullie  een  beetje  zijn  ingekomen. Het  is  natuurlijk  gek  om  bingo  te  spelen  met  een  robot.",};

        int randomNumber = new BingoNumberGenerator().RandomThreeActivityGenerator();

        return comingBy[randomNumber];
    }

    public String englishSentences() {
        String[] comingBy = {"Are  you  all  doing  okay  so  far? I  really  hope  so. ",
                "I  think  it's  nice  to  have  you  all  here, that's  all  let's  continue",
                "It's  fun  playing  bingo  with  you. I'll  do  my  best"};
        int randomNumber = new BingoNumberGenerator().RandomThreeActivityGenerator();


        return comingBy[randomNumber];
    }

    public void setDutch(boolean dutch) {
        this.dutch = dutch;
    }

    public boolean isDutch() {
        return dutch;
    }

    public String randomSentences() {
        String[] theseOpenings = new String[2];
        theseOpenings[0] = dutchSentences();
        theseOpenings[1] = englishSentences();
//        theseOpenings[1] = dutchSentences();

        int randomNumber = new BingoNumberGenerator().RandomTwoActivityGenerator();
        System.out.println("Random number = " + randomNumber);
        System.out.println(theseOpenings[randomNumber]);
        if(Objects.equals(theseOpenings[randomNumber], theseOpenings[0])) {
            setDutch(true);
        }
        else {
            setDutch(false);
        }

        return theseOpenings[randomNumber];


    }
}