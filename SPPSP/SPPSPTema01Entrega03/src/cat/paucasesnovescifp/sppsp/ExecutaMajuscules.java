/*
 *  Marta Córcoles Valle
 * 
 */
package cat.paucasesnovescifp.sppsp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author marta
 */
public class ExecutaMajuscules {

    public static void main(String[] args) {
        // Runtime inicializado
        Runtime rt = Runtime.getRuntime();
        // Creación de un proceso
        Process pFill = null;
        Scanner sc = new Scanner(System.in);
        boolean sortir = false;
        System.out.println("-->");

        do {
            String text =  sc.nextLine();
            // Text a minúsculas
            switch (text.toLowerCase()) {
                case "sortir":
                    sortir = true;
                    break;
                default:
                    try {
                        // Inicializamos el proceso
                        pFill = rt.exec("C:\\Program Files\\Java\\jdk-11.0.3/bin/java -cp C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\SPPSPTema01Entrega03\\dist\\SPPSPTema01Entrega03.jar cat.paucasesnovescifp.sppsp.Majuscules");
                        // Introducimos los datos obtenidos
                        OutputStream os = pFill.getOutputStream();
                        OutputStreamWriter osw = new OutputStreamWriter(os);
                        PrintWriter pw = new PrintWriter(osw);
                        pw.print(text);
                        pw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // Obtener datos de la clase Majuscules
                    InputStream is = pFill.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    try {
                        // Introducimos los datos obtenidos y los imprimimos
                        String printFill = br.readLine();
                        System.out.println(printFill);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        } while (!sortir);
        System.out.println("Finalitzat");
    }
}
