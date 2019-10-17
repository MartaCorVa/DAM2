package cat.paucasesnovescifp.sppsp.aleatoris;

/**
 *
 * @author marta
 */
public class Aleatoris {
    
    // métode que torna un número random entre el 0 i 10.
    public int generaAleatori() {  
        return (int)(Math.random() * (11)); 
    }
    
    public static void main(String[] args) {
        Aleatoris aleatori = new Aleatoris();
        System.out.println(aleatori.generaAleatori());
    }
}
