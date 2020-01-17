package cat.paucasesnovescifp.spps;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class Galletas {

    static int galletas = 10;
    static Semaphore tarro = new Semaphore(1);
    static Semaphore noHayGalletas = new Semaphore(1);

    public static void main(String[] args) {
        try {
            noHayGalletas.acquire();
            creaPersonajes();
        } catch (InterruptedException ex) {
            Logger.getLogger(Galletas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void creaPersonajes() {
        Nin nin = new Nin();
        Nin nin1 = new Nin();
        Nin nin2 = new Nin();
        Nin nin3 = new Nin();
        Nin nin4 = new Nin();
        Nin nin5 = new Nin();
        Nin nin6 = new Nin();
        Nin nin7 = new Nin();
        Nin nin8 = new Nin();
        Nin nin9 = new Nin();
        Madre madre = new Madre();

        nin.start();
        nin1.start();
        nin2.start();
        nin3.start();
        nin4.start();
        nin5.start();
        nin6.start();
        nin7.start();
        nin8.start();
        nin9.start();
        madre.start();
    }

}
