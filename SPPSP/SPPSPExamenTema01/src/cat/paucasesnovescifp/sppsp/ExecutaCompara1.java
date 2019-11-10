package cat.paucasesnovescifp.sppsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class ExecutaCompara1 {

    public static void main(String[] args) {
        // Cream un scanner per lletgir els nombres
        Scanner sc = new Scanner(System.in);
        // Cream un procés
        Process p;

        try {
            // Demanam el primer nombre i el guardam a la variable num1
            System.out.println("Proces pare - Introdueix el primer nombre: ");
            int num1 = sc.nextInt();
            // Demanam el segon nombre i el guardam a la variable num2
            System.out.println("Proces pare - Introdueix el segon nombre: ");
            int num2 = sc.nextInt();
                        
            // Iniciam el procés amb les dues variables com a argument
            // Executam el .jar de Compara que representa el procés fill
            p = Runtime.getRuntime().exec("C:\\Program Files\\Java\\jdk-11.0.3/bin/java -cp C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\SPPSPExamenTema01\\dist\\SPPSPExamenTema01.jar cat.paucasesnovescifp.sppsp.Compara " + num1 + " " + num2);
            
            // Creació del BufferedReader per lletgir les dades del procés
        try (BufferedReader inStream = new BufferedReader(new InputStreamReader(p.getInputStream()))){   
            // Imprimim el resultat per pantalla
            System.out.println(inStream.readLine());
        } catch (IOException e) {
            // Capturam els posibles errors
            System.err.println("Error en inStream.readLine()");
            e.printStackTrace();
        }
        } catch (IOException ex) {
            // Capturam els posibles errors
            Logger.getLogger(ExecutaCompara1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
