package Bingo.RobotFunctionsRandomCode;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.ALMemory;
import com.aldebaran.qi.helper.proxies.ALSpeechRecognition;

import java.util.ArrayList;
import java.util.List;

public class BingoListener {

    private boolean isListeningEnabled;
    private boolean wasBingoHeard;
    private ALSpeechRecognition speech;
    public Application application;

    // Makes sure that application is passed true.
    public BingoListener(Application application) throws Exception {
        this.application = application;

//        recogniseSpeech(this.application);
    }

    // Hetzelfde als de constructor.
    public void recogniseSpeech(Application application) throws Exception {
        System.out.println("Recognise");
//        try {
        this.application = application;
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
        this.speech = new ALSpeechRecognition(application.session());
        ALMemory alMemory = new ALMemory(this.application.session());

//        try {
        // Put the words in the vocabulary of the robot
//            this.speech.unsubscribe("WordRecognized");
        this.speech.pause(true);
        this.speech.setLanguage("English");
        ArrayList<String> words1 = new ArrayList<String>();
        words1.add("Bingo");
        words1.add("bingo");
        words1.add("BINGO");
        words1.add("stop");

        this.speech.setVocabulary(words1, true);
//        this.speech.subscribe(APP_NAME);
//        alMemory.subscribeToEvent("WordRecognized", "recogniseSpeech::(m)", this);

        alMemory.subscribeToEvent("SpeechDetected", o -> {
            System.out.println("Speech detected = " + o.toString());
        });

        alMemory.subscribeToEvent("WordRecognized", o -> {
            System.out.println("bla bla bli bloep" + o.toString());
//            if (isListeningEnabled) {
//                wasBingoHeard = true;
//                System.out.println("Did someone say bingo? Laat de kaart scannen");
//            }
//            else {
//                System.out.println("Someone said bingo, but listening is not enabled");
//            }
            Object words = "bingo";
            String word = (String) ((List<Object>) o).get(0);
            System.out.println("Word" + word);

            if (o.equals("bingo")) {
                System.out.println("Bingo");
                this.speech.pause(false);
            }

            if (word.equals("bingo")) {
                System.out.println("Bingo 2");
            }

            System.out.println("Yeah");
        });


//            this.speech.setWordListAsVocabulary(Arrays.asList("stop", "bingo"));
//            this.speech.setVocabulary(supplierNames, true);
//            this.speech.loadVocabulary("C:\\Users\\Administrator\\IdeaProjects\\MemorySpel\\src\\Bingo");


//        this.speech.subscribe("WordRecognized");
//        recogniseSpeechEvent();
//        } catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//        this.isListeningEnabled = false;
    }


    public void speechDetectedEvent() throws Exception {
        ALMemory alMemory = new ALMemory(this.application.session());
        alMemory.subscribeToEvent("SpeechDetected", o -> {
            System.out.println("no voice" + o.toString());
            boolean value = Boolean.parseBoolean(o.toString());


        });

        System.out.println("Test");

    }

    public void recogniseSpeechEvent() throws Exception {

        System.out.println("test___________________________________________________________________________________________");
//        ALSpeechRecognition speechRecognition = new ALSpeechRecognition(this.application.session())
//
//        List<String> bingo = Collections.singletonList("bingo");
//        speechRecognition.setVocabulary(bingo, true);
//
//        speechRecognition.subscribe("Test_speechRecognition");
//        System.out.println("Engine started");
//        Thread.sleep(20000);
//        speechRecognition.unsubscribe("Test_speechRecognition");
        ALMemory alMemory = new ALMemory(this.application.session());
        alMemory.subscribeToEvent("SpeechDetected", o -> {
                    boolean value = Boolean.parseBoolean(o.toString());
                    System.out.println(value);
                    if (!value) {
                        System.out.println("nothing heard");
                    }
                }


        );
        alMemory.subscribeToEvent("WordRecognized", o -> {
            System.out.println("bla bla bli bloep" + o.toString());
            if (isListeningEnabled) {
                wasBingoHeard = true;
                System.out.println("Did someone say bingo? Laat de kaart scannen");
            } else {
                System.out.println("Someone said bingo, but listening is not enabled");
            }

        });
        System.out.println("Test");
    }

    public void setListeningEnabled(boolean toValue) {
        this.isListeningEnabled = toValue;
    }

    public boolean getWasBingoHeard() {
        return this.wasBingoHeard;
    }

    public void resetWasBingoHeard() {
        wasBingoHeard = false;
    }
}

