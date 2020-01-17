package cat.paucasesnovescifp.spps;

import static cat.paucasesnovescifp.spps.Galletas.*;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class Nin extends Thread {

    @Override
    public void run() {
        while (true) {
            try {
                // Niño coge el tarro
                tarro.acquire();
                if (galletas == 0) {                   
                    System.out.println("Llamando Madre");
                    noHayGalletas.release();
                    // Niño suelta el tarro
                    tarro.release();                    
                } else {                    
                    sleep(3000);
                    galletas--;
                    System.out.println("Niño coge una galleta, quedan " + galletas);
                    // Niño suelta el tarro
                    tarro.release();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Nin.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
