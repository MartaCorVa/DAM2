package cat.paucasesnovescifp.spaad;

import cat.paucasesnovescifp.spaad.auxiliars.Alumne;
import cat.paucasesnovescifp.spaad.auxiliars.AlumneException;

/**
 *
 * @author marta
 */
public class Executable {

    public static void main(String[] args) {
        try {
            Alumne marta = new Alumne("Marta", "Corcoles");
            Alumne joselito = new Alumne("Joselito", "");
        } catch (AlumneException e){
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
}
