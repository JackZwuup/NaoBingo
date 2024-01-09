package Bingo.RobotFunctionsRandomCode;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALAnimatedSpeech;
import com.aldebaran.qi.helper.proxies.ALTextToSpeech;

public class NaoSpeech {
    private Application application;

    public NaoSpeech(Application application) {
        this.application = application;
    }

    public void talking(String text, String language) throws Exception {
        // Create an ALTextToSpeech object and link it to your current session
        try {
            ALTextToSpeech tts = new ALTextToSpeech(this.application.session());
            ALTextToSpeech speech = new ALTextToSpeech(this.application.session());
            speech.setLanguage(language);
            // Make your robot say something
            tts.say("\\rspd=75\\" + text);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void speakInLanguage(String language) {
        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void animatedSpeech(String text, String language) throws Exception {
        try {
            ALAnimatedSpeech animatedSpeech = new ALAnimatedSpeech(this.application.session());
            ALTextToSpeech speech = new ALTextToSpeech(this.application.session());
            speech.setLanguage(language);

            animatedSpeech.say("\\rspd=75\\" + text);

        } catch (Exception e) {
            System.out.println("Animated speech: " + e.getMessage());
        }
    }
}
