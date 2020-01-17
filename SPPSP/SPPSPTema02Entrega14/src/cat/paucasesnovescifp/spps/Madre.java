package cat.paucasesnovescifp.spps;

import static cat.paucasesnovescifp.spps.Galletas.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class Madre extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                noHayGalletas.acquire();
                tarro.acquire();
                galletas = 10;
                System.out.println("Tarro repuesto");
                System.out.println("Galletas: " + galletas);
                tarro.release();
            } catch (InterruptedException ex) {
                Logger.getLogger(Madre.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
