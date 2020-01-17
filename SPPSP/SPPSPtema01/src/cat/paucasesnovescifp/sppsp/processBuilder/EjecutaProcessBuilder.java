package cat.paucasesnovescifp.sppsp.processBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class EjecutaProcessBuilder {

    public static void main(String[] args) {
        // variable con el url
        String url = "C:\\Users\\marta\\OneDrive\\Escritorio\\ficheros\\";
        // arraylist que almacenará los parametros de entrada.txt
        ArrayList<String> parametros = new ArrayList<>();
        // BufferedReader para leer el archivo
        try (BufferedReader inStream = new BufferedReader(new FileReader(url + "\\entrada.txt"))) {
            // añadir el contenido del fichero a la arraylist
            while (inStream.ready()) {
                parametros.add(inStream.readLine());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EjecutaProcessBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(EjecutaProcessBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // creación de un proceso
            Process p = null;
            // ProcessBuilder con la ruta de ejecución de Numeros.class y los parametros
            ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Java\\jdk-11.0.3/bin/java", "-cp", "C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\SPPSPtema01\\dist\\SPPSPtema01.jar", "cat.paucasesnovescifp.sppsp.programa.Numeros", parametros.get(0), parametros.get(1));
            // redirectOutput para escribir el resultado en sortida.txt
            pb.redirectOutput(new File(url + "sortida.txt"));
            // redirectError para escribir los errores en error.txt
            pb.redirectError(new File(url + "error.txt"));
            // inicialización del proceso y puesta en marcha del ProcessBuilder
            p = pb.start();
            // variable rc que indica si el proceso se ha ejecutado correctamente
            // 1 = error, 0 = correcto
            int rc = p.waitFor();
            System.out.println("RC: " + rc);
        } catch (IOException ex) {
            Logger.getLogger(EjecutaProcessBuilder.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(EjecutaProcessBuilder.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
