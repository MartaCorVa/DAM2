package cat.paucasesnovescifp.sppsp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class FillTAC extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                FillTAC.sleep(2000);
                System.out.println("    TAC");
            } catch (InterruptedException ex) {
                Logger.getLogger(FillTAC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
