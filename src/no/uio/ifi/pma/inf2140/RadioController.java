package no.uio.ifi.pma.inf2140;


import java.awt.*;

class RadioController implements IRadioController {

    private boolean RadioState = false;
    volatile private IRadioDisplay display;
    volatile private IRotator rotator;

	//不要改动
    RadioController(IRadioDisplay display, IRotator rotator) {
        this.display = display;
        this.rotator = rotator;
    }

    public void eventLock() {
        if(RadioState) {
            rotator.stopScanning();
        }
    }

    public void eventScan() {
        if(RadioState) {
            rotator.startScanning();
        }
    }
    
    public void eventOn() {
        RadioState = true;
        display.setText("108MHZ");


    }
    
    public void eventOff() {
        RadioState = false;
        System.out.print("OFF");
        display.setText("OFF");
    }
    
    public void eventReset() {
        if(RadioState) {
            display.setText("108MHZ");
        }


    }
    
}


/****************************************************************************/
