package cat.paucasesnovescifp.sppsp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class FillTIC extends Thread {

    @Override
    public void run() {
        while (true) {
            System.out.println("TIC");
            try {
                FillTIC.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(FillTIC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
}

