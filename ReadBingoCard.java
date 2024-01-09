package Bingo;

import com.aldebaran.qi.Application;
import com.aldebaran.qi.CallError;
import com.aldebaran.qi.helper.EventCallback;
import com.aldebaran.qi.helper.proxies.ALBarcodeReader;
import com.aldebaran.qi.helper.proxies.ALMemory;


import java.util.concurrent.atomic.AtomicReference;

public class ReadBingoCard {

    private final int ZERO = 0;
    private final int ONE = 1;
    private final int NINE = 9;
    private final int ONEFIVE = 15;
    private String colourString;
    public Application application;
    private int lastReadCard;
    private boolean detectionAllowed;

    public ReadBingoCard(Application application) throws Exception{
        this.application = application;
        setLastReadCard(0);
    }

    public int barcodeDetection(String nameString){
        for (int i = ONE; i < ONEFIVE; i++) {
            if(nameString.contains(("number " + i))){
                setLastReadCard(i);
                System.out.println(getLastReadCard() + " CONFIRMED");
            }
        }
        return getLastReadCard();
    }
    public int barcodeEventTest() throws Exception {
        ALBarcodeReader barcode_service = new ALBarcodeReader(this.application.session());
        barcode_service.subscribe("test_barcode");
        ALMemory alMemory = new ALMemory(this.application.session());
        alMemory.subscribeToEvent("BarcodeReader/BarcodeDetected", o -> {
            colourString = o.toString();
            if (detectionAllowed) {
                barcodeDetection(colourString);

            }
        });

        return getLastReadCard();
    }
    public void setDetectionAllowed(boolean detectionAllowed) {this.detectionAllowed = detectionAllowed;}

    public int getLastReadCard() {
        return lastReadCard;
    }

    public void setLastReadCard(int lastReadCard) {
        this.lastReadCard = lastReadCard;
    }

    }
