package cat.paucasesnovescifp.sppsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class Compara2 {

    public static void main(String[] args) {        
        String nom = "";
        // Utilitzam un BufferedReader per lletgir el nom del proces que indicam a la clase pare
        try (BufferedReader sc = new BufferedReader(new InputStreamReader(System.in))){
            nom = sc.readLine();
        } catch (IOException ex) {
            Logger.getLogger(Compara2.class.getName()).log(Level.SEVERE, null, ex);
        }       
               
        // Cream la variable num1 i l'hi afegim el primer argument
        int num1 = Integer.parseInt(args[0]);
        // Cream la variable num2 i l'hi afegim el segon argument
        int num2 = Integer.parseInt(args[1]);

        // Feim un if() amb les tres condicions possibles
        if (num1 > num2) {
            System.out.println("Proces fill " + nom + " - El primer nombre " + num1 + " es major que el segon nombre " + num2);
        } else if (num1 < num2) {
            System.out.println("Proces fill " + nom + " - El primer nombre " + num1 + " es menor que el segon nombre " + num2);
        } else {
            System.out.println("Proces fill " + nom + " - El primer nombre " + num1 + " es igual que el segon nombre " + num2);
        }
    }
}
