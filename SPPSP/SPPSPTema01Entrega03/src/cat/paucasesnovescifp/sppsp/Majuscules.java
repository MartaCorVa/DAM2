/*
 *  Marta Córcoles Valle
 * 
 */
package cat.paucasesnovescifp.sppsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author marta
 */
public class Majuscules {

   public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader sc = new BufferedReader (isr);
        String cadena = null;
        try {
            // Guardar el valor del buffered reader
            cadena = sc.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Imprimir el valor y ponerlo en mayúsculas
        System.out.println(cadena.toUpperCase());
    }
}
