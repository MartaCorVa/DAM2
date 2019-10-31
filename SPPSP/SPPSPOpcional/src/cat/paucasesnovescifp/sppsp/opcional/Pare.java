package cat.paucasesnovescifp.sppsp.opcional;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marta
 */
public class Pare {

    public static void metodo1() {
        Scanner sc = new Scanner(System.in);
        Process p;
        BufferedReader br;
        String texto;

        try {
            System.out.println("Escribe tu frase: ");
            texto = sc.nextLine();

            //Iniciamos el proceso
            p = Runtime.getRuntime().exec("C:\\Program Files\\Java\\jdk-11.0.3/bin/java -cp C:\\Users\\marta\\OneDrive\\Documentos\\Proyectos\\SPPSP\\SPPSPOpcional\\dist\\SPPSPOpcional.jar cat.paucasesnovescifp.sppsp.opcional.Hijo1");

            // Obtener datos de la clase Hijo1
            InputStream is = p.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            //Para escribir en el proceso entrada hijo
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
            out.write(texto);
            out.flush();
            out.close();

            String resultado = br.readLine();
            System.out.println(resultado);

        } catch (IOException ex) {
            Logger.getLogger(Pare.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void metodo2() {
        
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcio;
        
        do {
            System.out.println("Introduce un numero del menu: ");
            opcio = sc.nextInt();
            switch (opcio) {
                case 1:
                    metodo1();
                    break;
                case 2:
                    break;
                default:
                    break;
            }

        } while (opcio != 3);

    }

}
