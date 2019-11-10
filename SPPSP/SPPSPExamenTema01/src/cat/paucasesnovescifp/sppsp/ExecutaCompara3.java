package cat.paucasesnovescifp.sppsp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class ExecutaCompara3 {

    public static void main(String[] args) {
        // Cream un scanner per lletgir els nombres
        Scanner sc = new Scanner(System.in);
        // Cream un procés
        Process p;
        // Cream una variable per guardar l'opció
        String opcio;
        // Cream una variable per tancar l'execució
        boolean tancar = true;

        try {
            do {
                System.out.println("Proces pare - Introdueix el nom del proces fill o adeu per sortir: ");
                opcio = sc.nextLine();

                switch (opcio) {
                    case "adeu":
                        tancar = false;
                        break;
                    default:
                        // Demanam el primer nombre i el guardam a la variable num1
                        System.out.println("Proces pare - Introdueix el primer nombre: ");
                        String num1 = sc.nextLine();
                        // Demanam el segon nombre i el guardam a la variable num2
                        System.out.println("Proces pare - Introdueix el segon nombre: ");
                        String num2 = sc.nextLine();

                        // ProcessBuilder amb la ruta d'execució de Compara i els arguments corresponents
                        // Executam el .jar de Compara que representa el procés fill
                        ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Java\\jdk-11.0.3/bin/java", "-cp", "C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\SPPSPExamenTema01\\dist\\SPPSPExamenTema01.jar", "cat.paucasesnovescifp.sppsp.Compara2", num1, num2);
                        // Iniciam el proces i executam el ProcessBuilder
                        p = pb.start();
                        
                        // Per escriure en el proces d'entrada del fill
                        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
                        out.write(opcio);
                        out.flush();
                        out.close();

                        // Creació del BufferedReader per lletgir les dades del procés
                        try (BufferedReader inStream = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                            // Imprimim el resultat per pantalla
                            System.out.println(inStream.readLine());
                        } catch (IOException e) {
                            // Capturam els posibles errors
                            System.err.println("Error en inStream.readLine()");
                            e.printStackTrace();
                        }
                        break;
                }
            } while (tancar);

        } catch (IOException ex) {
            // Capturam els posibles errors
            Logger.getLogger(ExecutaCompara1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
