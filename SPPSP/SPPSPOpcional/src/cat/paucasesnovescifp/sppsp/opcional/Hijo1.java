package cat.paucasesnovescifp.sppsp.opcional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author marta
 */
public class Hijo1 {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader sc = new BufferedReader(isr);
        String cadena = "";
        try {
            // Guardar el valor del buffered reader
            cadena = sc.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Imprimir el valor 
        System.out.println("El hijo 1 dice: " + cadena);
    }
}
