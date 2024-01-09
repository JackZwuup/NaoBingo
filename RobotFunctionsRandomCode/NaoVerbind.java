package Bingo.RobotFunctionsRandomCode;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.helper.proxies.*;

public class NaoVerbind {

    private String naam;
    public Application application;

    private final int ZERO = 0;
    private final int ONE = 1;
    private final int NINE = 9;
    private final int ONEFIVE = 15;
    private boolean timer = true;

    private ALBarcodeReader barcode_service;
    private int lastReadCard;
    private int qrCodeDetected = 0;
    private boolean detectionAllowed;

    public Application verbind(String hostname, int port) {
        try {
            String robotUrl = "tcp://" + hostname + ":" + port;
            // Create a new application
            this.application = new Application(new String[]{}, robotUrl);
            // De application verwacht dat er argumenten worden weergeven. Maar die gebruiken we echter niet.
            // Start your application
            application.start();
            System.out.println("\nSUCCESVOL VERBONDEN MET NAO");
        } catch (Exception e) {
            System.out.println("Verbind" + e.getMessage());
        }
        return application;
    }
}
