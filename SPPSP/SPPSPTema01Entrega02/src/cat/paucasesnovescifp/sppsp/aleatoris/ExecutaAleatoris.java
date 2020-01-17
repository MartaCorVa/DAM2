package cat.paucasesnovescifp.sppsp.aleatoris;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author marta
 */
public class ExecutaAleatoris {

    public static void main(String[] args) {
        //creación de un proceso
        Process p = null;
        Scanner sc = new Scanner(System.in);
        int contador = 0;
        String teclat = "";
        boolean tanca = false;
        // creación del BufferedReader para leer los datos del proceso
        BufferedReader inStream = null;

        do {
            System.out.println("--->");
            teclat = sc.nextLine();

            contador++;
            switch (teclat.toLowerCase()) {
                case "sortir":
                    tanca = true;
                    break;
                case "":
                    try {
                        // runtime inicializado
                        Runtime rt = Runtime.getRuntime();
                        // ejecución de Aleatoris.class a través de runtime
                        // se almacena el resultado en el proceso
                        p = rt.exec("C:\\Program Files\\Java\\jdk-11.0.3/bin/java -cp C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\SPPSPTema01Entrega02\\dist\\SPPSPTema01Entrega02.jar cat.paucasesnovescifp.sppsp.aleatoris.Aleatoris");
                        inStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
                        System.out.println(inStream.readLine());
                    } catch (IOException e) {
                        System.err.println("Error en inStream.readLine()");
                        e.printStackTrace();
                    }
                    break;
            }
        } while (contador != 10 && tanca != true);
        if (contador == 10) {
            System.out.println("FINALITZAT: no hi ha més nombres aleatoris");
        }
    }
}
