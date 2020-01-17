package cat.paucasesnovescifp.sppsp.runtime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author marta
 */
public class EjecutaRuntime {

    public static void main(String[] args) throws InterruptedException {
        //creación de un proceso
        Process p = null;

        try {
            // runtime inicializado
            Runtime rt = Runtime.getRuntime();
            // ejecución de Numeros.class a traves de runtime
            // se almacena el resultado en el proceso
            p = rt.exec("C:\\Program Files\\Java\\jdk-11.0.3/bin/java -cp C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\SPPSPtema01\\dist\\SPPSPtema01.jar cat.paucasesnovescifp.sppsp.programa.Numeros 1 2");
            // variable rc que indica si el proceso se ha ejecutado correctamente
            // 1 = error, 0 = correcto
            int rc = p.waitFor();
            System.out.println("RC: " + rc);
        } catch (IOException e) {
            System.err.println("Error en exec()");
            e.printStackTrace();
        }
        
        // creación del BufferedReader para leer los datos del proceso
        try (BufferedReader inStream = new BufferedReader(new InputStreamReader(p.getInputStream()))){   
            // el resultado se imprime por pantalla
            System.out.println(inStream.readLine());
        } catch (IOException e) {
            System.err.println("Error en inStream.readLine()");
            e.printStackTrace();
        }
    }
}
