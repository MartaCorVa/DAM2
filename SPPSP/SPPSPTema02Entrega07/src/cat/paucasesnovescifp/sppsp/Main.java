package cat.paucasesnovescifp.sppsp;

/**
 *
 * @author marta
 */
public class Main {

    private boolean activa = true;

    public static void main(String[] args) {
        boolean activa = true;
        
        while (activa) {
            new FillTIC().start();
            activa = false;
        }
        
        while (!activa) {
           new FillTAC().start(); 
           activa = true;
        }        
    }

}
