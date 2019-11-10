package cat.paucasesnovescifp.sppsp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class ExecutaCompara2 {

    public static void main(String[] args) {
        // Cream una variable tipus String per guardar els errors al fitxer
        String cadena = "";
        // Cream una variable tipus String per guardar l'url del fitxer
        String url = "C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\SPPSPExamenTema01\\src\\cat\\paucasesnovescifp\\sppsp\\fitxers\\";
        // Utilitzam una ArrayList per guardar els parametres de nombres.txt
        ArrayList<String> nombres = new ArrayList<>();
        // Sout amb l'indicació de que esteim lletgint el fitxer
        System.out.println("Proces pare - Lletgint dades del fitxer...");
        // BufferedReader per lletgir l'arxiu
        // Utilitzam directament un try-catch-with resources per tancar el Buffer
        try (BufferedReader inStream = new BufferedReader(new FileReader(url + "nombres.txt"))) {
            // Afegim el contingut del fitxer dins l'ArrayList
            while (inStream.ready()) {
                nombres.add(inStream.readLine());
            }
        } catch (FileNotFoundException ex) {
            // Guardam els errors a la variable cadena
            cadena += ex.getMessage() + "\n";
        } catch (IOException ex) {
            // Guardam els errors a la variable cadena
            cadena += ex.getMessage() + "\n";
        }

        try {
            // Cream un procés
            Process p = null;
            // ProcessBuilder amb la ruta d'execució de Compara i els arguments corresponents
            // Executam el .jar de Compara que representa el procés fill
            ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Java\\jdk-11.0.3/bin/java", "-cp", "C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\SPPSPExamenTema01\\dist\\SPPSPExamenTema01.jar", "cat.paucasesnovescifp.sppsp.Compara", nombres.get(0), nombres.get(1));
            // Iniciam el proces i executam el ProcessBuilder
            p = pb.start();
            // Creació del BufferedReader per lletgir les dades del procés
            try (BufferedReader inStream = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                // Imprimim el resultat per pantalla
                System.out.println(inStream.readLine());
            } catch (IOException ex) {
                cadena += ex.getMessage() + "\n";
            }
            // Creació del BufferedWriter per escriure els errors al fitxer
            try (BufferedWriter outputStream = new BufferedWriter(new FileWriter(url + "errors.txt"))) {
                    outputStream.write(cadena);
            } catch (IOException ex) {
                Logger.getLogger(ExecutaCompara2.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(ExecutaCompara2.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

}
